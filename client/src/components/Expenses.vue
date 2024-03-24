<template>
	<main class="flex gap-6 min-w-full border-blue-600 border-b-2 border-t-2 p-8 my-8">
		<ul
			v-for="(value, key) in expenses"
			:key="key"
			class="flex flex-col min-w-[200px] max-h-[500px] w-1/6 mx-auto border-2 p-4 gap-2"
		>
			<h2 class="text-center text-2xl font-semibold my-2">{{ getMonthAndDay(key.toString()) }}</h2>
			<div class="flex flex-col h-full justify-between">
				<div>
					<li v-for="expense in value" :key="expense.id" class="flex justify-between items-center">
						<h2>{{ expense.title }}</h2>
						<p>${{ expense.amount }}</p>
					</li>
				</div>
				<li class="flex justify-between">
					<h2>Total</h2>
					<p>${{ value.reduce((acc, expense) => acc + expense.amount, 0) }}</p>
				</li>
			</div>
		</ul>
	</main>
</template>

<style>
ul {
	list-style-type: none;
}

</style>

<script setup lang="ts">
import expenses from '../data'

function getMonthAndDay(date: string) {
	const dateArr = date.split('-')
	const month = dateArr[1]
	const day = dateArr[2]
	return `${month} / ${day}`
}

const groupExpensesByWeek = expenses => {
	const weeklyExpenses: Expense[][] = []
	let currentWeek: Expense[] = []
	let daysInCurrentWeek = 0

	for (const expense of expenses) {
		// If current week is full (7 days), push it to weeklyExpenses and start a new week
		if (daysInCurrentWeek === 7) {
			weeklyExpenses.push(currentWeek)
			currentWeek = []
			daysInCurrentWeek = 0
		}

		// Add expense to current week
		currentWeek.push(expense)
		daysInCurrentWeek++
	}

	// Push the last week if it's not empty
	if (currentWeek.length > 0) {
		weeklyExpenses.push(currentWeek)
	}

	return weeklyExpenses
}

console.log(groupExpensesByWeek(expenses.value))
</script>
