<template>
	<div>
		<h1>Create Expense</h1>

		<div>
			<label for="amount">Amount</label>
			<input
				type="number"
				id="amount"
				v-model="expense.amount"
				class="border-2 border-green-500 rounded-md px-2 py-1"
			/>

			<label for="description">Description</label>

			<input
				type="text"
				id="description"
				v-model="expense.description"
				class="border-2 border-green-500 rounded-md px-2 py-1"
			/>

			<label for="date">Date</label>
			<input
				type="date"
				id="date"
				v-model="expense.date"
				class="border-2 border-green-500 rounded-md px-2 py-1"
			/>
		</div>

		<div>
			<button
				type="submit"
				class="bg-green-400 hover:bg-green-500 transition-all text-lg w-fit px-6 rounded-md text-black py-1"
				@click="createExpense"
			>
				Create Expense
			</button>
		</div>
	</div>
</template>
<script>
import expenseService from '../services/ExpenseService'

export default {
	data() {
		return {
			expense: {
				userId: 1,
				amount: 0,
				description: '',
				date: new Date(),
			},
		}
	},
	methods: {
		async createExpense() {
			try {
				await expenseService.createExpense(this.expense)
				this.$router.push({ name: 'Home' })
			} catch (error) {
				console.error(error)
			}
		},
	},
}
</script>
