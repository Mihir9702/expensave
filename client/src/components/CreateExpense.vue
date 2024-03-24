<template>
	<section class="border-2 rounded-md bg-[#1a1c1a] w-1/4 mx-auto my-6">
		<div class="border-2 flex justify-between">
			<button class="border-2 rounded-full">
				<img class="" src="../assets/chevron-left.svg" alt="" />
			</button>
			<h2 class="text-2xl font-bold text-center my-4">{{ month }} / {{ day }}</h2>
			<button class="border-2 rounded-full">
				<img class="" src="../assets/chevron-right.svg" alt="" />
			</button>
		</div>
		<form class="flex flex-col items-center gap-4 my-8 w-fit mx-auto" @submit.prevent="createExpense">
			<label for="title">
				<input
					type="text"
					id="title"
					name="title"
					v-model="title"
					class="w-full p-2 bg-transparent border-2 rounded-md mx-auto focus:outline-none"
					placeholder="Title"
				/>
			</label>
			<label for="amount">
				<input
					type="number"
					id="amount"
					name="amount"
					v-model="amount"
					class="w-full p-2 bg-transparent border-2 rounded-md mx-auto focus:outline-none"
					placeholder="Amount ($)"
				/>
			</label>
			<button
				class="w-full p-2 px-8 bg-blue-500 hover:bg-blue-600 transition-all text-white font-bold rounded-md"
				type="submit"
			>
				Add Expense
			</button>
		</form>
	</section>
</template>

<script setup lang="ts">
const date = new Date()
const day = date.getDate()
const month = date.getMonth() + 1
import { ref } from 'vue'

const title = ref('')
const amount = ref(0)

function createExpense() {
	console.log(title.value, amount.value)

	title.value = ''
	amount.value = 0
}
</script>
