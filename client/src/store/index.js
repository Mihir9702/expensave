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

      SORT_EXPENSES(state, key) {
        console.log("sorting")
        if (key === 'date') {
          state.expenses = state.expenses.sort((a, b) => new Date(b.date) - new Date(a.date))
        } else if (key === 'amount') {
          state.expenses = state.expenses.sort((a, b) => b.amount - a.amount)
        } else if (key === 'description') {
          state.expenses = state.expenses.sort((a, b) => a.description.localeCompare(b.description))
        }
      }
    },
  })
  return store
}
