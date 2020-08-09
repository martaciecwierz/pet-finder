<template>
    <b-row>
        <b-col class="login">
            <div class="panel">
                <div class="login-panel">
          <span class="login-form-background">
            <img class="login-logo" src="../assets/logo.png">
            <login-form v-if="mode === 0"/>
            <register-form v-if="mode === 1"/>
            <password-form v-if="mode === 2"/>
              <div class="login-footer">
                  <a href="#" v-if="mode === 0 || mode === 2" @click.prevent="selectMode(1)">Zarejestruj się</a>
                  <a href="#" v-if="mode === 1" @click.prevent="selectMode(0)">Zaloguj się</a>
                  |
                  <a v-if="mode===0 || mode===1" href="#" @click.prevent="selectMode(2)">Zapomniałem hasła</a>
                  <a href="#" v-if="mode === 2"  @click.prevent="selectMode(0)">Zaloguj się</a>
              </div>
          </span>
                    <img src="../assets/dog.jpg">
                </div>
            </div>
        </b-col>
    </b-row>
</template>

<script>

    import LoginForm from "../components/Login/LoginForm.vue";
    import PasswordForm from "../components/Login/PasswordForm.vue";
    import RegisterForm from "../components/Login/RegisterForm.vue";

    export default {
        name: 'Home',
        components: {
            RegisterForm,
            PasswordForm,
            LoginForm},
        data: function () {
            return {
                mode: 0, //0=login, 1=rejestracja, 2= przypomnienie hasła
        }
        },
        methods:{
            selectMode(mode){
                this.mode = mode
            }
        }
    }
</script>
<style>
    .login {
        margin-top: 15%;
    }

    .login-footer{
        font-size: 0.5em;
        position: relative;
        bottom: 10px;
    }

    .login input {
        margin-left: 10%;
        width: 80%;
        background-color: rgba(255, 255, 255, 0.4);
    }

    .login-logo {
        width: 30%;
        height: auto;
        margin-bottom: 10%;
        margin-top: 5%;
    }

    .login-panel {
        text-align: center;
        position: absolute;
        width: 50vw;
    }

    .login-form-background {
        position: absolute;
        left: 0;
        width: 40%;
        height: 100%;
        background-color: rgba(255, 255, 255, 0.7);
    }

    .panel {
        margin-left: 25vw;
    }

    img {
        height: 100%;
        width: 50vw;
    }
</style>
<style scoped>
    .row{
        margin-right: 0;
        margin-left: 0;
    }
</style>