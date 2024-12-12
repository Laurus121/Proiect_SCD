<template>
  <v-dialog v-model="showDialog" max-width="400px" class="bg-transparent">
    <div class="dialogClass">
      Welcome, {{currentUser}}! Let's create a new package!
      <v-textarea
          label="Delivery Address"
          v-model="currentPackage.deliveryAddress"
          :rules="[v => !!v || 'Delivery address is required']"
      >
      </v-textarea>
      <!-- TODO: Add package details here -->

      <v-btn
          color="green"
          @click="createPackage"
          :disabled="!currentPackage.deliveryAddress"
      >
      Create
      </v-btn>
      <v-btn color="red" @click="closeDialog">Cancel</v-btn>
    </div>
  </v-dialog>
</template>

<script>
import axios from 'axios';

export default {
  name: 'AddPackage',
  props: {
    currentUser: String
  },
  data() {
    return {
      showDialog: false, // Initially set to false to keep dialog closed
      currentPackage: {
        deliveryAddress: ""
      }
    };
  },
  methods: {
    async createPackage() {
      try {
        const response = await axios.post('http://localhost:8083/package', this.currentPackage);
        console.log("Package created successfully:", response.data);
        this.showDialog = false; // Close dialog after creating the package
        this.currentPackage = { deliveryAddress: "" }; // Reset package data
      } catch (error) {
        console.error("Error creating package:", error);
      }
    },
    closeDialog() {
      this.showDialog = false;
      this.currentPackage = { deliveryAddress: "" }; // Reset the delivery address
    },
  }
};
</script>

<style scoped>
.dialogClass {
  padding: 20px;
  background-color: white;
}
</style>
