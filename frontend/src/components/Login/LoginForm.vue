<template>
    <b-form class="text-center login-page-form">
        <b-form-group>
            <b-form-input v-model="user.username" id="username" size="sm" placeholder="Nazwa użytkownika" ></b-form-input>
        </b-form-group>
        <b-form-group>
            <b-form-input  v-model="user.password" id="password" type="password" placeholder="Hasło" size="sm"></b-form-input>
        </b-form-group>
        <b-form-group>
            <b-button size="sm">Zaloguj</b-button>
        </b-form-group>
    </b-form>
</template>

<script>
    export default {
        name: 'LoginForm',
        props: {
          username: String
        },
        data: function(){
            return {
                user: {
                    username: "",
                    password: ""
                }
            }
        },
      methods:{
          setUsername: function (){
            console.log(this.$props.username)
            this.user.username = this.$props.username
          }
      },
      mounted: function (){
          console.log('mounted')
          this.setUsername()
      }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .login-page-form{
        height:60%;
    }
</style>
