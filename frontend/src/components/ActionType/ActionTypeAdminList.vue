<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <h4>Zarządzanie rodzajami aktywności</h4>
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
        <action-type-admin-list-tools :type="data.item"/>
      </template>
      <template v-slot:cell(points)="data">
        {{ data.item.points }} <span v-if="data.item.type===1"> * ilość</span>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import ActionTypeAdminListTools from "@/components/ActionType/ActionTypeAdminListTools";

export default {
  name: 'ActionTypeAdminList',
  components: {ActionTypeAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'name',
          label: 'Nazwa',
          sortable: false
        },
        {
          key: 'points',
          label: 'Punkty',
          sortable: false
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        },
      ],
      types: [{
        id: 1,
        name: "Spacer",
        description: "Wyprowadzenie zwierzęcia na spacer",
        points: 10,
        type: 0 //typ określa jak liczone są punkty - 0=> podana liczba punktów, 1=> liniowo: ilość * podana liczba punktów
      }, {
        id: 2,
        name: "Wsparcie finansowe",
        description: "Przelanie pieniędzy na konto",
        points: 10,
        type: 1
      }, {
        id: 3,
        name: "Darowizna",
        description: "Przekazanie potrzebnych produktów",
        points: 20,
        type: 1
      }, {
        id: 4,
        name: "Adopcja",
        description: "Adopcja zwierzęcia",
        points: 1000,
        type: 0
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
