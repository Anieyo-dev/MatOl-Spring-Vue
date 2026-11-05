<template>
  <div class="container">
    <div>

    </div>
    <div class="dataTable">
      <StatisticsTable />
    </div>
  </div>
</template>

<script>
import StatisticsTable from "@/components/dataTables/statisticsTable.vue";
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';

export default {
  name: "DashBoardView",
  components: {
    StatisticsTable,
    DataTable,
    Column,
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }
  }
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: [first]1fr [second]8fr [end] 1fr;
}

.dataTable {
  margin-top: 10px;
}
</style>