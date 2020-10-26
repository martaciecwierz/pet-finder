<template>
  <b-row cols="12" class="shelter">
    <shelter-menu :shelter="shelter"></shelter-menu>

    <b-col cols="12" md="8" lg="10" class="text-left">
    <pet-select-panel v-bind:key="pet.id" v-bind:pet="pet" :shelter-mode="true" v-for="pet in pets"></pet-select-panel>
    </b-col>
  </b-row>
</template>

<script>
import PetSelectPanel from "../../components/Pet/PetSelectPanel.vue";
import ShelterMenu from "@/components/UI/ShelterMenu";

export default {
  components: {
    ShelterMenu,
    PetSelectPanel
  },
  name: 'ShelterPetsList',
  data: function () {
    return {
      shelter:
          {
            id: 1,
            name: "Nazwa Schroniska",
            description: "Opis schroniska",
            address: "Uliczna 10, Miasto",
            pets: "100",
            volonteers: "20",
            logo: "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png"
          },
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