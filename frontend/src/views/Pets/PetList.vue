<template>
  <div class="pets">
    <pet-select-panel v-bind:key="pet.id" v-bind:pet="pet" v-for="pet in pets"></pet-select-panel>
  </div>
</template>

<script>
import PetSelectPanel from "../../components/Pet/PetSelectPanel.vue";

export default {
  components: {
    PetSelectPanel
  },
  name: 'PetList',
  data: function () {
    return {
      pets:
          [{
            id: 1,
            name: "Nazwa zwierzęcia",
            description: "Opis zwierzęcia",
            age: "3 miesiące",
            type: {
              name: "Pies"
            },
            shelter: {
              name: "Schronisko w Poznaniu"
            }
          }, {
            id: 2,
            name: "Nazwa zwierzęcia",
            description: "Opis zwierzęcia",
            age: "3 miesiące",
            type: {
              name: "Pies"
            },
            shelter: {
              name: "Schronisko w Poznaniu"
            }
          }, {
            id: 3,
            name: "Nazwa zwierzęcia",
            description: "Opis zwierzęcia",
            age: "3 miesiące",
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