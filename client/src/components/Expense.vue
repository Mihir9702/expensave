<template>
	<ul class="border-2 mx-auto max-w-fit p-4 rounded-md">
		<li v-for="expense in expenses" :key="expense.id"></li>

		<!-- <h2 class="text-2xl font-bold text-center mb-4">{{ month }} / {{ day }}</h2> 
		 <li class="flex justify-between items-center w-32 my-2">
			<h3>{{ props.expense.title }}</h3>
			<p class="">${{ props.expense.amount }}</p>
		</li> -->

		<!-- <li class="flex justify-between items-center w-32">
			<h3>Total</h3>
			<p>${{ total }}</p>
		</li>  -->
	</ul>
</template>

<script setup lang="ts">
import { defineProps } from 'vue'

interface Expense {
	id: number
	title: string
	amount: number
	date: string
}

// const props = defineProps({
//   title: {
//     type: String,
//   }
// })
const props = defineProps<{ expense: Expense }>()

// console.log(props.expense)
// const day = date[0]
// const month = date[1]
</script>
