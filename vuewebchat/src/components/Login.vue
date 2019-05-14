<template>
  <el-form :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" aria-placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" aria-placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
    </el-form-item>
    <el-button type="danger" style="width: 50%" @click="test">测试按钮</el-button>
    <el-button type="danger" style="width: 60%" @click="corstest">测试跨域</el-button>
  </el-form>
</template>
<script>
  import axios from 'axios'
  import baseUrl from '@/serviceAPI.config.js'
  export default {
    name: 'Login',
    data(){
      return{
        rules:{
          account:[{required:true,message:'请输入用户名',trigger:'blur'}],
          checkPass:[{required:true,message:'请输入密码',trigger:'blur'}]
        },
        checked:true,
        loginForm:{
          username:'duguqiubai',
          password:'123456'
        },
        loading:false
      }
    },
    methods:{
      submitClick:function () {
        /*let param = new URLSearchParams()
        param.append('username',this.loginForm.username)
        param.append('password',this.loginForm.password)*/
        axios({
          url:'/login',
          method:'post',
          data:{
            username: this.loginForm.username,
            password:this.loginForm.password
          },
          transformRequest: [function (data) {
            let ret = ''
            for (let it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            return ret
          }],
          header:{
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        }).then(response=>{
          console.log(response)
          if(response.status == 200){
            console.log("dengluchegng")
            this.$router.push({
              name:'Home',
              params:{
                frends:response.obj
              }
            })
          }
        }).catch(error=>{
          alert(error)
        })
      },
      test:function () {
        axios({
          url: "/test/findUser",
          method: "get"
        }).then(response=>{
          if(response.status == 200 ){
            console.log(response.data)
          }
        }).catch(error=>{
          alert(error)
        })
      },
      corstest:function () {
        axios({
          url:"/test/corsTest",
          method:"post",
          data:{
            username:this.loginForm.username,
            password:this.loginForm.password
          }
        }).then(response=>{
          if(response.status == 200){
            alert(response.data)
            console.log(response.data)
          }
        }).catch(error=>{
          alert(error)
        })
      }
    }
  }
</script>
<style scoped>
.login-container{
  width: 350px;
  margin: auto;
}
</style>
