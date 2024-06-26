import axios from 'axios'

export default {

  getExpenses() {
    return axios.get('/expenses')
  },

  getExpense(id) {
    return axios.get(`/expenses/${id}`)
  },

  createExpense(data) {
    return axios.post('/expenses', data)
  },

  deleteExpense(id) {
    return axios.delete(`/expenses/${id}`)
  },

}