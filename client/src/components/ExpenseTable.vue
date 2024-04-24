<template>
<div class="flex flex-col border-2 border-transparent bg-white rounded-md shadow-md my-8">
  <div class="-m-1.5 overflow-x-auto">
    <div class="p-1.5 min-w-full inline-block align-middle">
      <div class="overflow-hidden">
        <table class="min-w-full divide-y divide-gray-200">
          <thead>
            <tr>
              <th scope="col" class="px-6 py-3 text-start text-xs font-medium text-gray-500 uppercase">Description</th>
              <th scope="col" class="px-6 py-3 text-start text-xs font-medium text-gray-500 uppercase">Amount</th>
              <th scope="col" class="px-6 py-3 text-start text-xs font-medium text-gray-500 uppercase">Date</th>
              <th scope="col" class="px-6 py-3 text-end text-xs font-medium text-gray-500 uppercase">Action</th>
            </tr>
          </thead>
          <tbody class="divide-y divide-gray-200">
            <tr v-for="expense in expenses" :key="expense.id">
              <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-800">{{ expense.description }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">${{ expense.amount }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">{{ expense.date }}</td>
              <td class="px-6 py-4 whitespace-nowrap text-end text-sm font-medium">
                <button @click="deleteExpense(expense.id)" type="button" class="inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent text-blue-600 hover:text-blue-800 disabled:opacity-50 disabled:pointer-events-none">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  props: {
    expenses: Array,
    deleteExpense: Function,
  },

  methods: {
    sortBy(key) {
      this.$store.commit("SORT_EXPENSES", key);
    },
  },
};
</script>
