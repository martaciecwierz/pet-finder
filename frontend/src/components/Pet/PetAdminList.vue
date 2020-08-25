<template>
  <b-col  cols="12" md="8" lg="10"  class="text-left">
    <h4>Zarządzanie zwierzętami</h4>
    <b-table striped
             hover
             :items="pets"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(name)="data">
        <span v-b-tooltip.hover :title="data.item.description">{{ data.item.name }}</span>
      </template>
      <template v-slot:cell(type)="data">
          {{ data.item.type.name }}
      </template>
      <template v-slot:cell(shelter)="data">
        {{ data.item.shelter.name }}
      </template>
      <template v-slot:cell(tools)="data">
        <pet-admin-list-tools :pet="data.item"/>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import PetAdminListTools from "@/components/Pet/PetAdminListTools";
export default {
  name: 'PetAdminList',
  components: {PetAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'name',
          label: 'Nazwa',
          sortable: true
        },
        {
          key: 'shelter',
          label: 'Schronisko',
          sortable: false
        },
        {
          key: 'age',
          label: 'Wiek',
          sortable: false
        },
        {
          key: 'type',
          label: 'Gatunek/Rasa',
          sortable: false
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        }
      ],
      pets: [{
        id: 1,
        name: "Azor",
        description: "Opis zwierzęcia",
        age: "3 miesiące",
        type: {
          name: "Pies"
        },
        shelter: {
          name: "Schronisko w Gorzowie"
        }
      }, {
        id: 2,
        name: "Simba",
        description: "Opis zwierzęcia",
        age: "3 miesiące",
        adopted: true,
        type: {
          name: "Pies"
        },
        shelter: {
          name: "Schronisko w Poznaniu"
        }
      }, {
        id: 3,
        name: "Burek",
        description: "Opis zwierzęcia",
        age: "3 miesiące",
        type: {
          name: "Pies"
        },
        shelter: {
          name: "Schronisko w Gorzowie"
        }
      }, {
        id: 3,
        name: "Szarik",
        description: "Duże pies",
        age: "5 lat",
        type: {
          name: "Pies"
        },
        shelter: {
          name: "Schronisko w Poznaniu"
        }
      }, {
        id: 3,
        name: "Lord",
        description: "Ogromny pies",
        age: "3 lata",
        type: {
          name: "Pies"
        },
        shelter: {
          name: "Schronisko w Poznaniu"
        }
      }]
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
