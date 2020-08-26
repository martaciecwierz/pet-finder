<template>
    <div class="login">

                <div class="login-panel">
          <span class="login-form-background">
            <img class="login-logo" src="../assets/logo.png">
            <login-form ref="loginForm" :username="user.username" v-if="mode === 0"/>
            <register-form v-if="mode === 1" @registered="registered"/>
            <password-form v-if="mode === 2"/>
              <div class="login-footer">
                  <a href="#" v-if="mode === 0 || mode === 2" @click.prevent="selectMode(1)">Zarejestruj się</a>
                  <a href="#" v-if="mode === 1" @click.prevent="selectMode(0)">Zaloguj się</a>
                  |
                  <a v-if="mode===0 || mode===1" href="#" @click.prevent="selectMode(2)">Zapomniałem hasła</a>
                  <a href="#" v-if="mode === 2" @click.prevent="selectMode(0)">Zaloguj się</a>
              </div>
          </span>
                    <img class="bg-image" src="../assets/dog.jpg" >
                </div>

    </div>
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
            LoginForm
        },
        data: function () {
            return {
                mode: 0, //0=login, 1=rejestracja, 2= przypomnienie hasła
                user: {
                    username: null,
                }
            }
        },
        methods: {
            selectMode(mode) {
                this.mode = mode
            },
            registered: function (username) {
                this.user.username = username
                this.mode = 0;
            }
        }
    }
</script>
<style>

    * {
        box-sizing: border-box;
    }

    .login-footer {
        font-size: 0.5em;
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
        margin-bottom: 5%;
        margin-top: 5%;
    }

    .login-panel {
        text-align: center;
        width: 100%;
    }

    .login-form-background {
        position: absolute;
        width: 40%;
        height: 100%;
        background-color: rgba(255, 255, 255, 0.7);
    }

    img {
        height: 100%;
        width: 100%;
    }

    .bg-image{
    }

    .login {
        font-weight: bold;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 2;
        width: 80%;
        text-align: center;
    }
</style>
<style scoped>
    .row {
        margin-right: 0;
        margin-left: 0;
    }
</style>