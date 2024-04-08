<template>
  <table class="w-4/6 m-4 shadow-md">
    <thead>
      <tr class="bg-gray-300 text-black">
        <th class="w-1/4 p-2">Description</th>
        <th class="w-1/4 p-2">Amount</th>
        <th class="w-1/4 p-2">Date</th>
        <th class="w-1/4 p-2">Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="expense in expenses" :key="expense.id">
        <td class="p-2">{{ expense.description }}</td>
        <td class="p-2">${{ expense.amount }}</td>
        <td class="p-2">{{ expense.date }}</td>
        <td class="p-2">
          <button
            class="bg-gray-100 hover:bg-gray-200 shadow-md mx-8 transition-all text-lg w-fit px-5 rounded-md text-black py-1"
          >
            Edit
          </button>
          <button
            class="bg-gray-100 hover:bg-gray-200 shadow-md mx-8 transition-all text-lg w-fit px-5 rounded-md text-black py-1"
          >
            Delete
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props: {
    expenses: Array,
  },
};
</script>
