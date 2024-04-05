<template>
  <form
    v-on:submit.prevent="signup"
    class="border-2 border-green-500 rounded-md w-fit m-auto p-6"
  >
    <h1 class="text-2xl text-center">Create Account</h1>

    <div role="alert" v-if="registrationErrors">
      {{ registrationErrorMsg }}
    </div>

    <div class="flex gap-4 mt-4">
      <label for="username">Username</label>
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
      <label for="password">Password</label>
      <input
        class="border-2 border-green-500 outline-none bg-transparent"
        type="password"
        id="password"
        v-model="user.password"
        required
      />
    </div>

    <div class="flex gap-5 mt-4">
      <label for="confirmPassword">Confirm Password</label>
      <input
        type="password"
        class="border-2 border-green-500 outline-none bg-transparent"
        id="confirmPassword"
        v-model="user.confirmPassword"
        required
      />
    </div>

    <div class="flex justify-center mt-6">
      <button
        type="submit"
        class="bg-green-400 hover:bg-green-500 transition-all text-lg w-fit px-6 rounded-md text-black py-1"
      >
        Create Account
      </button>
    </div>

    <p>
      <router-link v-bind:to="{ name: 'Login' }">
        <p class="text-blue-400 mt-4 hover:underline">
          Already have an account? Log in.
        </p>
      </router-link>
    </p>
  </form>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    signup() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .signup(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>
