<template>
  <div>
    <div v-if="isLoading">
      <Loader />
    </div>
    <div v-else></div>
  </div>
</template>

<script>
import Loader from "../components/Loader.vue";

export default {
  components: {
    Loader,
  },
};
</script>
<style scoped></style>
