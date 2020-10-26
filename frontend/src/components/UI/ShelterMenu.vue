<template>
  <b-col cols="12" md="4" lg="2" class="margin-top">
    <img :src="$props.shelter.logo" class="img-fluid"> <br/>
    <span class="font-weight-bold">{{ $props.shelter.name }}</span><br/>

    <router-link active-class="active" :to="{name: 'ShelterInfo'}">Informacje o schronisku</router-link><br/>
    <router-link active-class="active" :to="{name: 'ShelterPetsList'}">Lista zwierząt</router-link><br/>
    <router-link active-class="active" :to="{name: 'ShelterVolonteersList'}">Lista wolontariuszy</router-link><br/>
  </b-col>
</template>

<script>
export default {
  name: 'ShelterMenu',
  props: {
    shelter: Object
  },
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
