<script setup lang="ts"></script>
<template>
	<header>
		<nav class="flex items-center justify-between">
			<ul class="flex justify-start m-4 gap-4">
				<li class="text-2xl border-2 px-4 py-2 rounded-sm">
					<RouterLink to="/">Home</RouterLink>
				</li>
				<li class="text-2xl border-2 px-4 py-2 rounded-sm">
					<RouterLink to="/about">About</RouterLink>
				</li>
			</ul>
			<ul class="flex justify-end m-4 gap-4">
				<li class="text-2xl border-2 px-4 py-2 rounded-sm">
					<RouterLink to="/login">Login</RouterLink>
				</li>
				<li class="text-2xl border-2 px-4 py-2 rounded-sm">
					<RouterLink to="/signup">Signup</RouterLink>
				</li>
			</ul>
		</nav>
	</header>
</template>
<style></style>
