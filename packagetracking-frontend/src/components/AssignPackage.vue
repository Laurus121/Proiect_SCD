<template>
  <v-container>
    <h2 class="text-h5">Assign Package</h2>
    <v-text-field
        label="Package ID"
        v-model="packageId"
        outlined
    ></v-text-field>
    <v-btn color="primary" @click="openCourierDialog">Assign</v-btn>

    <!-- Popup pentru selectarea curierului -->
    <v-dialog v-model="showCourierDialog" max-width="600px">
      <v-card>
        <v-card-title>Select a Courier</v-card-title>
        <v-card-text>
          <v-list>
            <v-list-item
                v-for="courier in couriers"
                :key="courier.id"
                @click="selectCourier(courier)"
                class="courier-item"
            >
              <v-list-item-title>{{ courier.name }}</v-list-item-title>
              <v-list-item-subtitle>{{ courier.email }}</v-list-item-subtitle>
            </v-list-item>
          </v-list>
        </v-card-text>
        <v-card-actions>
          <v-btn text color="red" @click="closeCourierDialog">Cancel</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "AssignPackage",
  data() {
    return {
      packageId: "",
      couriers: [],
      showCourierDialog: false,
    };
  },
  methods: {
    openCourierDialog() {
      if (!this.packageId) {
        alert("Please enter a package ID first!");
        return;
      }

      axios
          .get("http://localhost:8083/couriers/without-pending-packages")
          .then((response) => {
            this.couriers = response.data;
            this.showCourierDialog = true;
          })
          .catch((error) => {
            console.error("Error fetching couriers:", error);
          });
    },
    selectCourier(courier) {
      const courierId = courier.id;

      axios
          .put(`http://localhost:8083/package/assign/${this.packageId}`, null, {
            params: { courierId },
          })
          .then(() => {
            alert("Package assigned successfully!");
            this.packageId = "";
            this.closeCourierDialog();
          })
          .catch((error) => {
            console.error("Error assigning package:", error);
            alert("Failed to assign package. Please try again.");
          });

  },
    closeCourierDialog() {
      this.showCourierDialog = false;
    },
  },
};
</script>

<style scoped>
.courier-item {
  cursor: pointer;
  transition: background-color 0.3s;
}

.courier-item:hover {
  background-color: #f0f0f0;
}
</style>
