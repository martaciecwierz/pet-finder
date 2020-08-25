<template>
  <ValidationObserver ref="form">
    <b-form class="text-center login-page-form">
      <div class="register-header">Rejestracja</div>
        <div v-if="step === 0">
            <b-form-group>
              <ValidationProvider name="Nazwa użytkownika" rules="required" v-slot="v">
                <b-form-input v-model="user.username" id="username" size="sm" placeholder="Nazwa użytkownika" ></b-form-input>
                <div class="validation-error">{{ v.errors[0] }}</div>
              </ValidationProvider>
            </b-form-group>
            <b-form-group>
              <ValidationProvider name="Adres e-mail" rules="required|email" v-slot="v">
                <b-form-input  v-model="user.email" id="email" type="email" placeholder="Adres e-mail" size="sm"></b-form-input>
                <div class="validation-error">{{ v.errors[0] }}</div>
              </ValidationProvider>
            </b-form-group>
        </div>

        <div v-else-if="step === 1">
            <b-form-group>
              <ValidationProvider name="Imię" rules="required" v-slot="v">
                <b-form-input v-model="user.firstName" id="firstName" size="sm" placeholder="Imię" ></b-form-input>
                <div class="validation-error">{{ v.errors[0] }}</div>
              </ValidationProvider>
            </b-form-group>
            <b-form-group>
              <ValidationProvider name="Nazwisko" rules="required" v-slot="v">
                <b-form-input  v-model="user.lastName" id="lastName" placeholder="Nazwisko" size="sm"></b-form-input>
                <div class="validation-error">{{ v.errors[0] }}</div>
              </ValidationProvider>
            </b-form-group>
        </div>

        <div v-else-if="step === 2">
            <b-form-group>
                <b-form-input v-model="user.password" id="password" type="password" size="sm" placeholder="Hasło" ></b-form-input>
            </b-form-group>
            <b-form-group>
                <b-form-input  v-model="user.confirmPassword" id="confirm-password" type="password" placeholder="Potwierdź hasło" size="sm"></b-form-input>
              <div class="validation-error">{{ passwordError }}</div>
            </b-form-group>
        </div>
        <b-form-group>
            <b-button size="sm" v-if="step>0" @click.prevent="step--" class="margin-right">Wstecz</b-button>
            <b-button size="sm" v-if="step<2" @click.prevent="nextStep">Dalej</b-button>
            <b-button size="sm" v-if="step === 2" @click.prevent="submit">Zarejestruj</b-button>
        </b-form-group>
    </b-form>
  </ValidationObserver>
</template>

<script>
  import apiConfig from "@/apiConfig";
  import axiosInstance from "@/tools/axiosInstance";
  import requestHeaders from "@/tools/requestHeaders";

    export default {
        name: 'RegisterForm',
      mixins: [requestHeaders],
        data: function() {
            return {
              passwordError: "",
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
      methods:{
          submit: function(){
            let vm = this
            this.$refs.form.validate().then(success => {
              if (!success) {
                return
              }
              if(this.user.password.length===0 || this.user.password!==this.user.confirmPassword){
                this.passwordError = "Nie podano hasła lub hasła się różnią"
                return
              }
              this.passwordError = ""
              let postData = {...vm.user}
              delete postData.confirmPassword
              axiosInstance
                  .post(apiConfig.registerUrl, JSON.stringify(postData), {
                    headers: {
                      'Content-Type': 'application/json;charset=UTF-8',
                      'Access-Control-Allow-Origin': '*'
                    }
                  })
            });

          },
        nextStep: function(){
          let vm = this
          this.$refs.form.validate().then(success => {
            if (!success) {
              return;
            }
            vm.step++
          });

        }
      },
        mounted: function(){
            this.step=0
          this.passwordError=""
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
