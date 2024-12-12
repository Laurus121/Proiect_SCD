<template>
  <v-app>
    <v-main>
      <v-container>
        <h1>Package Management</h1>

        <!-- Componente pentru vizualizarea pachetelor -->
        <packages-view />
        <unassigned-packages-view />

        <!-- Buton pentru crearea unui pachet nou -->
        <v-btn style="align-content: center" @click="openDialog">
          Create new package
        </v-btn>

        <!-- Componente pentru acțiuni asupra pachetelor -->
        <assign-package ref="assignPackageDialog" />
        <deliver-package ref="deliverPackageDialog" />

        <!-- Componenta pentru crearea unui pachet nou -->
        <add-package
            :curentUser="username"
            ref="addPostDialog"
        ></add-package>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import PackagesView from "@/components/PackagesView.vue";
import AddPackage from "@/components/AddPackage.vue";
import UnassignedPackagesView from "@/components/UnassignedPackagesView.vue";
import AssignPackage from "@/components/AssignPackage.vue";
import DeliverPackage from "@/components/DeliverPackage.vue";

export default {
  name: "App",

  components: {
    AddPackage,
    PackagesView,
    UnassignedPackagesView,
    AssignPackage,
    DeliverPackage,
  },

  data: () => ({
    username: "Nume utilizator",
  }),

  mounted() {
    if (this.$refs.addPostDialog) {
      this.$refs.addPostDialog.showDialog = false;
    }
    if (this.$refs.assignPackageDialog) {
      this.$refs.assignPackageDialog.showDialog = false;
    }
    if (this.$refs.deliverPackageDialog) {
      this.$refs.deliverPackageDialog.showDialog = false;
    }
  },

  methods: {
    openDialog() {
      if (this.$refs.addPostDialog) {
        this.$refs.addPostDialog.showDialog = true;
      }
    },
    openAssignDialog() {
      if (this.$refs.assignPackageDialog) {
        this.$refs.assignPackageDialog.showDialog = true;
      }
    },
    openDeliverDialog() {
      if (this.$refs.deliverPackageDialog) {
        this.$refs.deliverPackageDialog.showDialog = true;
      }
    },
  },
};
</script>
