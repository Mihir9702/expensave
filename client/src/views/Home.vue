<template>
  <div>
    <div v-if="isLoading">
      <Loader />
    </div>
    <div v-else>
      <h1>Home</h1>
      <div v-for="expense in expenses" :key="expense.id">
        <p>{{ expense.title }}</p>
        <p>{{ expense.amount }}</p>
        <p>{{ expense.category }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import Loader from "../components/Loader.vue";
import expenseService from "../services/ExpenseService";

export default {
  components: {
    Loader,
  },

  data() {
    return {
      isLoading: true,
      expenses: [],
    };
  },

  async created() {
    try {
      this.expenses = await expenseService.getExpenses();
      this.isLoading = false;
    } catch (error) {
      console.error(error);
    }
  },
};
</script>
