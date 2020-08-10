<template>
    <b-card class="pet">
      <b-row>
        <b-col col md="3" cols="12"><b-img class="shelter-logo" rounded src="https://www.goomlandscapes.co.nz/wp-content/uploads/2018/08/logo-placeholder.png"></b-img>
        </b-col>
        <b-col>
          <h2>{{ shelter.name }}</h2>
          <div>{{ shelter.description }}</div>
          <h4>Adres</h4>
          <div>{{ shelter.address }}</div>
          <h4>Liczba wolontariuszy</h4>
          <div>{{ shelter.volonteers }}</div>
          <h4>Liczba zwierząt</h4>
          <div>{{ shelter.pets }}</div>
        </b-col>
      </b-row>


    </b-card>
</template>

<script>
    export default {
        name: 'ShelterSelectPanel',
        props: {
            shelter: Object,
            msg: String
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .pet-image{
        width:100%;
        height: auto;
    }

    .pet{
        text-align: left;
        margin-bottom:7px;
    }

    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
