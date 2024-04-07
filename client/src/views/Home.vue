<template>
	<div>
		<div v-if="isLoading">
			<Loader />
		</div>
		<div v-else>
			<h1>Welcome, {{ username }}</h1>
		</div>
	</div>
</template>

<script>
import Loader from '../components/Loader.vue'

export default {
	components: {
		Loader,
	},

	data() {
		return {
			username: localStorage.getItem('username'),
		}
	},
}
</script>
<style scoped></style>
