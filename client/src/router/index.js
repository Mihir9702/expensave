import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Signup from '../views/Signup.vue'

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      requiresAuth: true
    }
  },

  {
    path: "/login",
    name: "Login",
    component: Login,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: "/logout",
    name: "Logout",
    component: Logout,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: "/create-expense",
    name: "CreateExpense",
    component: () => import("../views/CreateExpense.vue"),
    meta: {
      requiresAuth: true
    }
  }
]

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore()

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth)

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return { name: "Login" }
  }
  // Otherwise, do nothing and they'll go to their next destination
})

export default router
