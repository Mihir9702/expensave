import { RouteRecordRaw, createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'

const routes: Array<RouteRecordRaw> = [
	{
		path: '/',
		name: 'Home',
		component: Home,
	},
	{
		path: '/about',
		name: 'About',
		component: About,
	},
	{
		path: '/login',
		name: 'Login',
		component: Login,
	},
	{
		path: '/signup',
		name: 'Signup',
		component: Signup,
	},
]

export default createRouter({
	history: createWebHistory(),
	routes,
})
