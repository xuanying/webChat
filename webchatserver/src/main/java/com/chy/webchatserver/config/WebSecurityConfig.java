package com.chy.webchatserver.config;

import com.chy.webchatserver.common.UserUtils;
import com.chy.webchatserver.entity.RespBean;
import com.chy.webchatserver.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Resource
    CustomMetadataSource customMetadataSource;
    @Resource
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Resource
    AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","/static/**","/login_p","/test/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(customMetadataSource);
                        object.setAccessDecisionManager(urlAccessDecisionManager);
                        return object;
                    }
                })
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("applocation/json;charset=utf-8");
                        RespBean respBean = null;
                        if(exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException){
                            respBean = RespBean.error("账户名或密码错误！");
                        }else if(exception instanceof LockedException){
                            respBean = RespBean.error("账户被锁定，请联系管理员！");
                        }else if(exception instanceof CredentialsExpiredException){
                            respBean = RespBean.error("密码过期，请联系管理员！");
                        }else if(exception instanceof AccountExpiredException){
                            respBean = RespBean.error("账户过期，请联系管理员！");
                        }else if(exception instanceof DisabledException){
                            respBean = RespBean.error("账户被禁用，请联系管理员！");
                        }else {
                            respBean = RespBean.error("登录失败");
                        }
                        response.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("applocation/json;charset=utf-8");
                        RespBean respBean = RespBean.ok("登录成功！", UserUtils.getCurrentUser());
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = response.getWriter();
                        out.write(om.writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
    }
}
