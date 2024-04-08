<template>
  <form @submit.prevent="submitForm">
    <div class="flex justify-between gap-4 mt-4">
      <label for="date">Date:</label>
      <input
        class="border-2 border-gray-500 rounded-sm outline-none bg-transparent px-[22px]"
        type="date"
        id="date"
        v-model="expenseToAdd.date"
        required
      />
    </div>

    <div class="flex justify-between gap-4 mt-4">
      <label for="description">Description:</label>
      <input
        class="border-2 border-gray-500 rounded-sm outline-none bg-transparent"
        type="text"
        id="description"
        v-model="expenseToAdd.description"
        required
      />
    </div>

    <div class="flex justify-between gap-4 mt-4">
      <label for="amount">Amount:</label>
      <input
        class="border-2 border-gray-500 rounded-sm outline-none bg-transparent"
        type="number"
        id="amount"
        v-model="expenseToAdd.amount"
        required
      />
    </div>

    <div class="flex justify-center mt-6">
      <button
        type="submit"
        class="bg-gray-200 border-gray-400 hover:bg-gray-300 transition-all text-lg w-fit px-6 rounded-md text-black py-1"
      >
        Create
      </button>
    </div>
  </form>
</template>

<script>
export default {
  props: {
    addExpense: Function,
  },

  data() {
    return {
      expenseToAdd: {
        date: "",
        description: "",
        amount: 0,
      },
    };
  },

  methods: {
    submitForm() {
      this.addExpense(this.expenseToAdd);
      this.expenseToAdd = {
        date: "",
        description: "",
        amount: 0,
      };
    },
  },
};
</script>
