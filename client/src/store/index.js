import { createStore as _createStore } from 'vuex'
import axios from 'axios'
import expenseService from '../services/ExpenseService'

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      expenses: [],
    },

    mutations: {

      SET_AUTH_TOKEN(state, token) {
        state.token = token
        localStorage.setItem('token', token)
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },

      SET_USER(state, user) {
        state.user = user
        localStorage.setItem('user', JSON.stringify(user))
      },

      LOGOUT(state) {
        localStorage.removeItem('token')
        localStorage.removeItem('user')
        state.token = ''
        state.user = {}
        axios.defaults.headers.common = {}
      },

      SET_EXPENSES(state, id) {
        expenseService.deleteExpense(id).then(() => { })

        state.expenses = state.expenses.filter(expense => expense.id !== id)
      },
    },
  })
  return store
}
