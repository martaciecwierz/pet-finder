<template>
  <b-col cols="12" md="4" lg="2" class="margin-top">
    <span class="font-weight-bold">Profil użytkownika</span><br/>
    <router-link active-class="active" :to="{name: 'UserProfile'}">Podsumowanie</router-link><br/>
    <router-link active-class="active" :to="{name: 'ChangePassword'}">Zmień hasło</router-link><br/>
    <router-link active-class="active" :to="{name: 'ChangeUserInfo'}">Edytuj dane</router-link><br/>
  </b-col>
</template>

<script>
export default {
  name: 'UserMenu',
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
