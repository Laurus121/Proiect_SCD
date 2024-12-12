<template>
  <v-container>
    <h2 class="text-h5">Deliver Package</h2>
    <v-text-field
        label="Package ID"
        v-model="packageId"
        outlined
    ></v-text-field>
    <v-btn color="success" @click="deliverPackage">Deliver</v-btn>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  name: 'DeliverPackage',
  data() {
    return {
      packageId: "",
    };
  },
  methods: {
    async deliverPackage() {
      try {
        await axios.put(`http://localhost:8083/package/deliver/${this.packageId}`);
        alert("Package delivered successfully!");
        this.packageId = ""; // Clear the input
      } catch (error) {
        console.error("Error delivering package:", error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  margin-top: 20px;
}
</style>
