<template>
	<form
		class="border-2 w-1/2 m-auto"
		@submit.prevent="register"
	>
		<div class="flex flex-col m-4">
			<label for="username">Username</label>
			<input
				type="text"
				id="username"
				v-model="username"
			/>
		</div>

		<div class="flex flex-col m-4">
			<label for="password">Password</label>
			<input
				type="password"
				id="password"
				v-model="password"
			/>
		</div>

		<!-- submit button -->
		<div class="flex justify-center m-4">
			<button type="submit">Signup</button>
		</div>
	</form>
</template>

<script setup lang="ts">
import { AuthService } from '../services/AuthService'
import { useRouter } from 'vue-router'

const username = ''
const password = ''

const router = useRouter()

async function register(event: Event) {
	event.preventDefault()

	const username = (event.target as HTMLFormElement).username.value
	const password = (event.target as HTMLFormElement).password.value

	try {
		const response = await AuthService.register(username, password)
		console.log(response)
		router.push('/dashboard')
	} catch (error) {
		console.error(error)
	}
}
</script>
