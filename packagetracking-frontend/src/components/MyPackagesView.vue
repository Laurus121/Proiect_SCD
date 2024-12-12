<template>
  <v-container>
    <h2 class="text-h5">My Packages</h2>
    <v-btn text="refresh" @click="fetchMyPackages">Refresh</v-btn>
    <v-data-table
        :items="myPackages"
        :headers="headers"
    >
    </v-data-table>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  name: 'MyPackagesView',
  data() {
    return {
      myPackages: [],
      headers: [
        { text: "ID", value: "id" },
        { text: "Delivery Address", value: "deliveryAddress" },
        { text: "Status", value: "status" },
      ],
    };
  },
  methods: {
    async fetchMyPackages() {
      try {
        const response = await axios.get('http://localhost:8083/package/my');
        this.myPackages = response.data;
      } catch (error) {
        console.error("Error fetching my packages:", error);
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
