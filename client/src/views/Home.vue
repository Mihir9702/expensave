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
      <ExpenseForm :addExpense="addExpense" />
    </div>

    <ExpenseTable :expenses="expenses" />
  </div>
</template>

<script>
import Loader from "../components/Loader.vue";
import expenseService from "../services/ExpenseService";
import ExpenseForm from "../components/ExpenseForm.vue";
import ExpenseTable from "../components/ExpenseTable.vue";

async function getExpenses() {
  try {
    const response = await expenseService.getExpenses();
    return response.data;
  } catch (error) {
    console.error(error);
  }
}

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
    async addExpense() {
      try {
        await expenseService.addExpense(this.expenseToAdd);
        this.expenses = await getExpenses();
        this.expenseToAdd = {
          date: "",
          description: "",
          amount: 0,
        };
        this.showForm = false;
      } catch (error) {
        console.error(error);
      }
    },
  },

  async created() {
    this.expenses = await getExpenses();
    this.isLoading = false;
  },
};
</script>
