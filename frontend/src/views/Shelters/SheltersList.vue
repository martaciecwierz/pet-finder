<template>
  <div class="pets">
    <nav-bar/>
    <shelter-select-panel v-bind:key="shelter.id" v-bind:shelter="shelter"
                          v-for="shelter in shelters"></shelter-select-panel>
  </div>
</template>

<script>
import NavBar from "../../components/UI/Navbar.vue";
import ShelterSelectPanel from "../../components/Shelter/ShelterSelectPanel";

export default {
  components: {
    ShelterSelectPanel,
    NavBar
  },
  name: 'PetList',
  data: function () {
    return {
      pets:
          [{
            id: 1,
            name: "Nazwa Schroniska",
            description: "Opis schroniska",
            age: "Uliczna 10, Miasto",
            pets: "100",
            volonteers: "20"
          }, {
            id: 2,
            name: "Nazwa Schroniska",
            description: "Opis schroniska",
            age: "Uliczna 10, Miasto",
            pets: "100",
            volonteers: "20"
          }]
    }
  }
}
</script>