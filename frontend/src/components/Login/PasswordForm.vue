<template>
    <b-form class="text-center login-page-form">
        <b-form-group>
            <b-form-input v-model="user.email" id="email" size="sm" placeholder="Adres e-mail" ></b-form-input>
        </b-form-group>
        <b-form-group>
            <b-button size="sm">Przypomnij hasło</b-button>
        </b-form-group>
    </b-form>
</template>

<script>
    export default {
        name: 'PasswordForm',
        data: function(){
            return {
                user: {
                    email: ""
                }
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .login-page-form{
        height:60%;
    }
</style>
