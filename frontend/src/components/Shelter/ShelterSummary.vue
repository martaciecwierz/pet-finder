<template>
  <b-card class="w-100">
    <b-card-body class="w-100">
      <h3>Informacje o schronisku</h3>
      <table class="table">
        <tr>
          <th>Nazwa schroniska</th>
          <td>{{$props.shelter.name}}</td>
        </tr>
        <tr>
          <th>Opis</th>
          <td>{{$props.shelter.description}}</td>
        </tr>
        <tr>
          <th>Adres</th>
          <td>{{$props.shelter.address}}</td>
        </tr>
        <tr>
          <th>Adres e-mail</th>
          <td>{{$props.shelter.email}}</td>
        </tr>
        <tr>
          <th>Numer telefonu</th>
          <td>{{$props.shelter.phone}}</td>
        </tr>
      </table>
    </b-card-body>
  </b-card>
</template>

<script>
export default {
name: "ShelterSummary",
  props:{
  shelter: Object
  }
}
</script>

<style scoped>

</style>