<template>
  <form
    v-on:submit.prevent="login"
    class="border-2 border-green-500 rounded-md w-fit m-auto p-6"
  >
    <h1 class="text-2xl text-center">Please Sign In</h1>

    <div role="alert" v-if="invalidCredentials">
      Invalid username and password!
    </div>

    <div role="alert" v-if="this.$route.query.registration">
      Thank you for registering, please sign in.
    </div>

    <div class="flex gap-4 mt-4">
      <label for="username">Username:</label>
      <input
        class="border-2 border-green-500 outline-none bg-transparent"
        type="text"
        id="username"
        v-model="user.username"
        required
        autofocus
      />
    </div>

    <div class="flex gap-5 mt-4">
      <label for="password">Password:</label>
      <input
        class="border-2 border-green-500 outline-none bg-transparent"
        type="password"
        id="password"
        v-model="user.password"
        required
      />
    </div>

    <div class="flex justify-center mt-6">
      <button
        type="submit"
        class="bg-green-400 hover:bg-green-500 transition-all text-lg w-fit px-6 rounded-md text-black py-1"
      >
        Sign in
      </button>
    </div>

    <p>
      <router-link v-bind:to="{ name: 'Signup' }">
        <p class="text-blue-400 mt-4 hover:underline">
          Need an account? Sign up.
        </p>
      </router-link>
    </p>
  </form>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
