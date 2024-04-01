<template>
	<div>
		<h2>Expenses</h2>
		<ul>
			<li
				v-for="expense in expenses"
				:key="expense.id"
			>
				{{ expense.title }} - ${{ expense.amount }}
			</li>
		</ul>
	</div>
</template>

<style></style>

<script setup lang="ts" src="./Expenses.ts"></script>
