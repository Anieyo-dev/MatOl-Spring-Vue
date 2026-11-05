<template>
  <div class="box">
    <div class="dataTable">
      <DataTable 
                  id="data"
                  :value="statsItems.stats"
                  stripedRows
                  class="p-datatable-sm"
                  showGridlines
                  >
        <template #header>
          Platform Game Stats
        </template>
          <Column field="userId" header="userId"></Column>
          <Column field="name" header="name"></Column>
          <Column field="deaths" header="deaths"></Column>
          <Column field="time" header="time"></Column>
        
      </DataTable>
    </div>
    <div>
    </div>
  </div>
</template>

<script>
import stats from '@/data/statistics';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';

export default {
  name: "StatisticsTable",
  components: {
    DataTable,
    Column,
  },
  data () {
    return {
      statsItems: stats,
      
    }
  },
}

</script>

<style scoped>
.box {
  display: grid;
  grid-template-columns: [first]6fr [end] 6fr;
}

:deep(.p-datatable) {
  border: purple 2px solid;
}
.p-datatable:deep(.p-datatable-header) {
  color: purple;
}
:deep(.p-column-title) {
  color: purple;
}
:deep(.p-datatable-thead) {
  border-top: purple 2px solid;
  border-bottom: purple 2px solid;
}

</style>