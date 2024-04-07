import axios from 'axios'

export default {

  getExpenses() {
    return axios.get('/expenses')
  },

  getExpense(id) {
    return axios.get(`/expenses/${id}`)
  }

}