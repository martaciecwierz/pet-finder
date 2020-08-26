<template>
    <div>
  <div id="app"  v-if="$route.name!=='Login'">
    <nav-bar v-if="$route.name!=='Login'"/>
  <b-container fluid>
      <router-view/>

  </b-container>
    <div v-if="$route.name!=='Login'" class="footer">
      <b-row>
          <b-col cols="4">
              <span class="font-weight-bold">Sekcja 1</span><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
          </b-col>
          <b-col cols="4">
              <span class="font-weight-bold">Sekcja 2</span><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
          </b-col>
          <b-col cols="4">
              <span class="font-weight-bold">Sekcja 3</span><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#">Menu dolne 1</a><br/>
              <a href="#" @click="$router.push({name: 'About'})">Autorzy</a><br/>
          </b-col>
      </b-row>
  </div>
  </div>
        <div v-else class="login-page">
            <div class="background"></div>
            <div class="background2"></div>
            <router-view/>
        </div>
  </div>
</template>

<style lang="scss">
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        min-height: 100%;
        position: absolute;
        padding-bottom: 125px;
        padding-top: 60px;
        width: 100%;
}
    .login-page{
        height: 100vh;
    }

    .footer{
        position: absolute;
        bottom: 0;
        left: 0;
        height: 125px;
        border-top: 1px solid rgba(0,0,0,0.1);
        background-color: rgba(0,0,0,0.05);
        width:100%;
    }
</style>
<style scoped>
    .row{
        margin-right: 0;
        margin-left: 0;
    }
    .col-4{
        padding-left: 0;
        padding-right: 0;
    }

    .background {
        /* The image used */
        background-image: url("/login_background.jpg");

        /* Add the blur effect */
        filter: blur(20px);
        -webkit-filter: blur(20px);

        /* Full height */
        height: 100%;

        /* Center and scale the image nicely */
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
    .background2 {
        /* The image used */
        background-image: url("/login_background.jpg");

        position: absolute;
        top:0;

        /* Full height */
        height: 100vh;
        width: 100vw;
        /* Center and scale the image nicely */
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<script>
import NavBar from "@/components/UI/Navbar";
export default {
  components: {NavBar}
}
</script>