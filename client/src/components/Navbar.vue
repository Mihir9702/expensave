<template>
  <header>
    <nav class="flex items-center w-full">
      <ul class="flex justify-start m-4 gap-4">
        <router-link :to="{ name: 'Home' }">
          <li
            class="text-xl border-2 border-green-500 hover:bg-green-300 transition-all px-4 py-2 rounded-sm"
          >
            Home
          </li>
        </router-link>

        <router-link :to="{ name: 'Login' }">
          <li
            class="text-xl border-2 border-green-500 hover:bg-green-300 transition-all px-4 py-2 rounded-sm"
          >
            Login
          </li>
        </router-link>

        <router-link :to="{ name: 'Signup' }">
          <li
            class="text-xl border-2 border-green-500 hover:bg-green-300 transition-all px-4 py-2 rounded-sm"
          >
            Signup
          </li>
        </router-link>
      </ul>
    </nav>
  </header>
</template>
