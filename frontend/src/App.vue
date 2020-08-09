<template>
  <div id="app">
  <b-container fluid>
      <router-view/>
      <div class="footer">
          <b-row>
              <b-col cols="4">
                  <span class="font-weight-bold">Sekcja 1</span><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
              </b-col>
              <b-col cols="4">
                  <span class="font-weight-bold">Sekcja 1</span><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
              </b-col>
              <b-col cols="4">
                  <span class="font-weight-bold">Sekcja 1</span><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#">Menu dolne 1</a><br/>
                  <a href="#" @click="router.push({name: 'About'})">Autorzy</a><br/>
              </b-col>
          </b-row>
      </div>
  </b-container>
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
}
    .footer{
        position: absolute;
        bottom: 10px;
        left: 0;
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
</style>