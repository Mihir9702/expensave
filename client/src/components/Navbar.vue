<template>
  <header>
    <nav class="flex items-center w-full">
      <ul class="flex justify-start m-4 gap-4">
        <router-link :to="{ name: 'Home' }">
          <li
            class="text-xl bg-white shadow-md hover:bg-gray-100 transition-all px-4 py-2 rounded-md"
          >
            Home
          </li>
        </router-link>

        <router-link :to="{ name: 'Login' }">
          <li
            class="text-xl bg-white shadow-md hover:bg-gray-100 transition-all px-4 py-2 rounded-md"
          >
            Login
          </li>
        </router-link>

        <router-link :to="{ name: 'Signup' }">
          <li
            class="text-xl bg-white shadow-md hover:bg-gray-100 transition-all px-4 py-2 rounded-md"
          >
            Signup
          </li>
        </router-link>
      </ul>
    </nav>
  </header>
</template>
