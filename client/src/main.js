import { createApp } from 'vue'
import App from './App.vue'
import { createStore } from './store'
import router from './router'
import axios from 'axios'
import './styles/index.css'

axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API

let currentToken = localStorage.getItem('token')
let currentUser = {}

try {
  currentUser = JSON.parse(localStorage.getItem('user'))
} catch {
  localStorage.removeItem('token')
  localStorage.removeItem('user')
  currentToken = ''
}

if (currentToken) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`
}

const store = createStore(currentToken, currentUser)

const app = createApp(App)
app.use(store)
app.use(router)
app.mount('#app')