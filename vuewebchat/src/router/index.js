import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/helloword',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/',
      name:'Login',
      component:Login
    },
    {
      path:'/home',
      name:'Home',
      component:Home
    }
  ]
})
