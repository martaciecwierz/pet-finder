<template>
  <b-col cols="12" md="4" lg="2" class="margin-top">
    <span class="font-weight-bold">Profil użytkownika</span><br/>
    <router-link active-class="active" :to="{name: 'PetProfile'}">Podsumowanie</router-link><br/>
    <router-link active-class="active" :to="{name: 'PetRates'}">Opinie</router-link><br/>
    <router-link active-class="active" :to="{name: 'PetMeeting'}">Umów się na spacer</router-link><br/>
  </b-col>
</template>

<script>
export default {
  name: 'PetMenu',
  data: function () {
    return {

    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.margin-top {
  margin-top: 30px;
}
a {
  color: #42b983;
}

a.active{
  color: #286f4f;
}
</style>
