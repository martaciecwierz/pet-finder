<template>
    <b-form class="text-center login-page-form">
        <div v-if="step === 0">
            <b-form-group>
                <b-form-input v-model="user.username" id="username" size="sm" placeholder="Nazwa użytkownika" ></b-form-input>
            </b-form-group>
            <b-form-group>
                <b-form-input  v-model="user.email" id="email" type="email" placeholder="Adres e-mail" size="sm"></b-form-input>
            </b-form-group>
        </div>
        <div v-else-if="step === 1">
            <b-form-group>
                <b-form-input v-model="user.firstName" id="firstName" size="sm" placeholder="Imię" ></b-form-input>
            </b-form-group>
            <b-form-group>
                <b-form-input  v-model="user.lastName" id="lastName" placeholder="Nazwisko" size="sm"></b-form-input>
            </b-form-group>
        </div>
        <div v-else-if="step === 2">
            <b-form-group>
                <b-form-input v-model="user.password" id="password" type="password" size="sm" placeholder="Hasło" ></b-form-input>
            </b-form-group>
            <b-form-group>
                <b-form-input  v-model="user.confirmPassword" id="confirm-password" type="password" placeholder="Potwierdź hasło" size="sm"></b-form-input>
            </b-form-group>
        </div>
        <b-form-group>
            <b-button size="sm" v-if="step>0" @click.prevent="step--" class="margin-right">Wstecz</b-button>
            <b-button size="sm" v-if="step<2" @click.prevent="step++">Dalej</b-button>
            <b-button size="sm" v-if="step === 2">Zarejestruj</b-button>
        </b-form-group>
    </b-form>
</template>

<script>
    export default {
        name: 'RegisterForm',
        data: function() {
            return {
                user: {
                    username: "",
                    firstName: "",
                    lastName: "",
                    email: "",
                    password: "",
                    confirmPassword: ""
                },
                step: 0
            }
        },
        mounted: function(){
            this.step=0
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .login-page-form{
        height:60%;
    }
    .margin-right{
        margin-right: 5px;
    }
</style>
