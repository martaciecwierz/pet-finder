<template>
  <b-card class="w-100">
    <b-card-body class="w-100">
      <h3>Informacje o zwierzęciu</h3>
      <table class="table table-striped">
        <tr>
          <th>Nazwa zwierzęcia</th>
          <td>{{$props.pet.name}}</td>
        </tr>
        <tr>
          <th>Rasa</th>
          <td>{{$props.pet.petType}}</td>
        </tr>
        <tr :key="attribute.id" v-for="attribute in $props.pet.attributes">
          <th>{{attribute.name}}</th>
          <td>
            <span v-if="attribute.type==='boolean'">
              <span v-if="attribute.value">TAK</span>
              <span v-else>NIE</span>
            </span>
            <span v-else>
              {{ attribute.value }}
            </span>
          </td>
        </tr>
      </table>
    </b-card-body>
  </b-card>
</template>

<script>
export default {
  name: "PetProfileSummary",
  props: {
    pet: Object
  }
}
</script>

<style scoped>

</style>