import axios from 'axios'

export default {

  login(user) {
    return axios.post('/login', user)
  },

  signup(user) {
    return axios.post('/signup', user)
  }

}
