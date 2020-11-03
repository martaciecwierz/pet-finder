<template>
  <b-row cols="12" class="admin">
    <pet-menu/>
    <b-col cols="12" md="8" lg="10" class="text-left">
      <b-card class="w-100">
        <b-card-body class="w-100">
          <h3 class="mb-3">Oceny spacerów</h3>
          <pet-rate :key="rate.id" v-for="rate in rates" :rate="rate"/>
        </b-card-body>
      </b-card>
    </b-col>
  </b-row>
</template>

<script>
import PetRate from "@/components/Pet/PetRate";
import PetMenu from "@/components/UI/PetMenu";

export default {
  name: "PetRates",
  components: {PetMenu, PetRate},
  data(){
    return {

      rates:
          [
            {
              id: 0,
              rate: 5,
              date: "20.10.2020",
              author: "Tomasz Siuchniński",
              comment: "Spacer przebiegł bez przeszkód"
            },
            {
              id: 1,
              rate: 2,
              date: "28.10.2020",
              author: "Adam Złośliwy",
              comment: "Pies wyrywał się przez cały czas trwania spaceru"
            },
            {
              id: 2,
              rate: 4,
              date: "28.10.2020",
              author: "Piotr Leniwy",
              comment: ""
            }
          ]


    }
  }
}
</script>

<style scoped>

</style>