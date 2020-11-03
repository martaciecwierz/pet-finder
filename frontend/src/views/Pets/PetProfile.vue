<template>
  <b-row cols="12" class="admin">
    <user-menu/>
    <b-col cols="12" md="8" lg="10" class="text-left">
      <pet-profile-summary :pet="pet"/>
      <pet-profile-images v-if="pet.images && pet.images.length>0" :images="pet.images" class="mt-3"/>
      <shelter-summary class="mt-3 mb-4" :shelter="pet.shelter"/>
    </b-col>
  </b-row>
</template>

<script>
import UserMenu from "@/components/UI/UserMenu";
import PetProfileSummary from "@/components/Pet/PetProfileSummary";
import ShelterSummary from "@/components/Shelter/ShelterSummary";
import PetProfileImages from "@/components/Pet/PetProfileImages";

export default {
  name: "PetProfile",
  components: {PetProfileImages, ShelterSummary, PetProfileSummary, UserMenu},
  data(){
    return {

      pet:
          {
            name: "Burek",
            petType: "Pies",
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
            attributes: [
              {id: 0, name: "Wiek", value: "3 miesiące", type: "string"},
              {id: 1, name: "Szczepiony", value: true, type: "boolean"}
            ],
            images: [
              { id: 0, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 1, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 2, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 3, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 4, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 5, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 6, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 7, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 8, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
              { id: 9, location: "https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp" },
            ]
          }
    }
  }
}
</script>

<style scoped>

</style>