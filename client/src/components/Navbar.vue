<script></script>
<template>
  <header>
    <nav class="flex items-center justify-end w-full">
      <ul class="flex justify-start m-4 gap-4">
        <li class="text-2xl border-2 px-4 py-2 rounded-sm">
          <router-link :to="{ name: 'Home' }">Home</router-link>
        </li>
        <li class="text-2xl border-2 px-4 py-2 rounded-sm">
          <router-link :to="{ name: 'Login' }">Login</router-link>
        </li>
        <li class="text-2xl border-2 px-4 py-2 rounded-sm">
          <router-link :to="{ name: 'Signup' }">Signup</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>
