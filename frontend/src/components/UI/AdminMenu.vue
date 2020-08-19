<template>
  <b-col cols="12" md="4" lg="2" class="margin-top">
    <span class="font-weight-bold">Administracja</span><br/>
    <a href="" @click.prevent="$router.push({name: 'PetAdmin'})" :class="{active: $route.name==='PetAdmin'}">Zwierzęta</a><br/>
    <a href="" @click.prevent="$router.push({name: 'PetTypesAdmin'})" :class="{active: $route.name==='PetTypesAdmin'}">Typy zwierząt</a><br/>
    <a href="" @click.prevent="$router.push({name: 'ActionTypesAdmin'})" :class="{active: $route.name==='ActionTypesAdmin'}">Typy aktywności</a><br/>
    <a href="">Schroniska</a><br/>
    <a href="" @click.prevent="$router.push({name: 'ArticleAdmin'})" :class="{active: $route.name==='ArticleAdmin'}">Aktualności</a><br/>
    <a href="" @click.prevent="$router.push({name: 'UserAdmin'})" :class="{active: $route.name==='UserAdmin'}">Użytkownicy</a><br/>
  </b-col>
</template>

<script>
export default {
  name: 'AdminMenu',
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
