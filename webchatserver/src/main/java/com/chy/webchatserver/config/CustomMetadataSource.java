package com.chy.webchatserver.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
