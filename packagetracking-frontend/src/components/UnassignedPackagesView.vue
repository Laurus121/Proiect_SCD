<template>
  <v-container>
    <h2 class="text-h5">Unassigned Packages</h2>
    <v-btn text="Refresh" @click="fetchUnassignedPackages">Refresh</v-btn>

    <v-data-table
        :items="unassignedPackages"
        :headers="headers"
        item-key="id"
    >
      <template v-slot:[`item.actions`]="{ item }">
        <v-btn color="red" @click="openDeleteDialog(item)">
          X
        </v-btn>
      </template>
    </v-data-table>

    <!-- Confirmation Dialog -->
    <v-dialog v-model="showDeleteDialog" max-width="400px">
      <v-card>
        <v-card-title class="headline">Confirm Deletion</v-card-title>
        <v-card-text>
          Are you sure you want to delete this package?
        </v-card-text>
        <v-card-actions>
          <v-btn color="green" @click="deletePackage">Yes, Delete</v-btn>
          <v-btn color="red" @click="closeDeleteDialog">Cancel</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  name: 'UnassignedPackagesView',
  data() {
    return {
      unassignedPackages: [],
      headers: [
        { text: "ID", value: "id" },
        { text: "Delivery Address", value: "deliveryAddress" },
        { text: "Actions", value: "actions", sortable: false }, // Add "Actions" column
      ],
      showDeleteDialog: false,
      packageToDelete: null, // Store the package to delete
    };
  },
  methods: {
    async fetchUnassignedPackages() {
      try {
        const response = await axios.get('http://localhost:8083/package/unassigned');
        this.unassignedPackages = response.data;
      } catch (error) {
        console.error("Error fetching unassigned packages:", error);
      }
    },
    openDeleteDialog(item) {
      this.packageToDelete = item;
      this.showDeleteDialog = true;
    },
    closeDeleteDialog() {
      this.showDeleteDialog = false;
      this.packageToDelete = null;
    },
    async deletePackage() {
      try {
        await axios.delete(`http://localhost:8083/package/${this.packageToDelete.id}`);
        this.unassignedPackages = this.unassignedPackages.filter(pkg => pkg.id !== this.packageToDelete.id);
        this.showDeleteDialog = false;
        this.packageToDelete = null;
        console.log("Package deleted successfully.");
      } catch (error) {
        console.error("Error deleting package:", error);
      }
    },
  },
};
</script>

<style scoped>
.dialogClass {
  padding: 20px;
  background-color: white;
}
</style>
