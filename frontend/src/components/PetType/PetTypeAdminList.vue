<template>
  <b-col  cols="12" md="8" lg="10"  class="text-left">
    <h4>Zarządzanie rodzajami zwierząt</h4>
    <b-table striped
             hover
             responsive
             :items="types"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(name)="data">
        <span v-b-tooltip.hover :title="data.item.description">{{ data.item.name }}</span>
      </template>
      <template v-slot:cell(tools)="data">
        <pet-type-admin-list-tools :type="data.item"/>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import PetTypeAdminListTools from "@/components/PetType/PetTypeAdminListTools";
export default {
  name: 'PetTypeAdminList',
  components: {PetTypeAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'name',
          label: 'Nazwa',
          sortable: false
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        }
      ],
      types: [{
        id: 1,
        name: "Pies",
        description: "Czworonożne stworzenie szczekające"
      },{
        id: 2,
        name: "Kot",
        description: "Czworonożne stworzenie miałczące"
      },{
        id: 3,
        name: "Ptak",
        description: "Skrzydlate stworzenie latające"
      },]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h4 {
  margin: 30px 0 0;
}
a {
  color: #42b983;
}
</style>
