<template>
  <b-row cols="12" class="shelter">
    <shelter-menu :shelter="shelter"></shelter-menu>

    <b-col cols="12" md="8" lg="10" class="text-left">
      <shelter-summary :shelter="shelter"/>
    </b-col>
  </b-row>
</template>

<script>
import ShelterMenu from "@/components/UI/ShelterMenu";
import ShelterSummary from "@/components/Shelter/ShelterSummary";

export default {
  components: {
    ShelterSummary,
    ShelterMenu
  },
  name: 'ShelterInfo',
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
          }
    }
  }
}
</script>