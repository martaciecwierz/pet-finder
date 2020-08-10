<template>
  <div class="shelters">
    <shelter-select-panel v-bind:key="shelter.id" v-bind:shelter="shelter"
                          v-for="shelter in shelters"></shelter-select-panel>
  </div>
</template>

<script>
import ShelterSelectPanel from "../../components/Shelter/ShelterSelectPanel";

export default {
  components: {
    ShelterSelectPanel
  },
  name: 'PetList',
  data: function () {
    return {
      shelters:
          [{
            id: 1,
            name: "Nazwa Schroniska",
            description: "Opis schroniska",
            address: "Uliczna 10, Miasto",
            pets: "100",
            volonteers: "20"
          }, {
            id: 2,
            name: "Nazwa Schroniska",
            description: "Opis schroniska",
            address: "Uliczna 10, Miasto",
            pets: "100",
            volonteers: "20"
          }]
    }
  }
}
</script>