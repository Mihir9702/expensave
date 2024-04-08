<template>
  <div v-if="isLoading">
    <Loader />
  </div>
  <div v-else class="flex flex-col items-center">
    <h1 class="text-3xl font-bold mt-4">Expenses</h1>

    <div class="flex justify-center mt-4">
      <button
        class="bg-white hover:bg-gray-100 shadow-md transition-all text-lg w-fit px-6 rounded-md text-black py-1"
        @click="showForm = !showForm"
      >
        Add Expense
      </button>
    </div>

    <div v-if="showForm" class="bg-white p-4 rounded-md shadow-md m-4">
      <ExpenseForm :createExpense="createExpense" />
    </div>

    <ExpenseTable :expenses="expenses" :deleteExpense="deleteExpense" />
  </div>
</template>

<script>
import Loader from "../components/Loader.vue";
import expenseService from "../services/ExpenseService";
import ExpenseForm from "../components/ExpenseForm.vue";
import ExpenseTable from "../components/ExpenseTable.vue";

export default {
  components: {
    Loader,
    ExpenseForm,
    ExpenseTable,
  },

  data() {
    return {
      isLoading: true,
      expenses: [],
      showForm: false,
    };
  },

  methods: {
    async getExpenses() {
      try {
        const response = await expenseService.getExpenses();
        return response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async createExpense(expenseToAdd) {
      try {
        await expenseService.createExpense(expenseToAdd);
        this.expenses = await this.getExpenses();
        this.showForm = false;
      } catch (error) {
        console.error(error);
      }
    },

    async deleteExpense(id) {
      try {
        await expenseService.deleteExpense(id);
        this.expenses = await this.getExpenses();
      } catch (error) {
        console.error(error);
      }
    },
  },

  async created() {
    this.expenses = await this.getExpenses();
    this.isLoading = false;
  },
};
</script>
