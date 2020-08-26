<template>
  <ValidationObserver :key="'registerObserver'" ref="form">
    <b-form class="text-center login-page-form">
      <div class="register-header">Rejestracja</div>
      <ValidationObserver :key="0" v-if="step === 0">
        <b-form-group>
          <ValidationProvider name="Nazwa użytkownika" rules="required" v-slot="v">
            <b-form-input v-model="user.username" id="username" size="sm"
                          placeholder="Nazwa użytkownika" v-on:keyup.enter="nextStep"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </ValidationProvider>
        </b-form-group>
        <b-form-group>
          <ValidationProvider name="Adres e-mail" rules="required|email" v-slot="v">
            <b-form-input v-model="user.email" id="email" type="email" placeholder="Adres e-mail"
                          size="sm" v-on:keyup.enter="nextStep"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </ValidationProvider>
        </b-form-group>
      </ValidationObserver>

      <ValidationObserver :key="1" v-else-if="step === 1">
        <b-form-group>
          <ValidationProvider name="Imię" rules="required|min:3" v-slot="v">
            <b-form-input v-model="user.firstName" id="firstName" size="sm" placeholder="Imię" ref="firstName" v-on:keyup.enter="nextStep"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </ValidationProvider>
        </b-form-group>
        <b-form-group>
          <ValidationProvider name="Nazwisko" rules="required" v-slot="v">
            <b-form-input v-model="user.lastName" id="lastName" placeholder="Nazwisko" size="sm"  v-on:keyup.enter="nextStep"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </ValidationProvider>
        </b-form-group>
      </ValidationObserver>

      <ValidationObserver :key="2" v-else-if="step === 2">
        <b-form-group>
          <ValidationProvider name="hasło" rules="required|min:8" v-slot="v">
            <b-form-input v-model="user.password" id="password" type="password" size="sm"
                          placeholder="Hasło" v-on:keyup.enter="submit"  ref="password"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </ValidationProvider>
        </b-form-group>
        <b-form-group>
          <ValidationProvider name="potwierdź hasło" rules="required|min:8" v-slot="v">
            <b-form-input v-model="user.confirmPassword" id="confirm-password" type="password"
                          placeholder="Potwierdź hasło" size="sm" v-on:keyup.enter="submit"></b-form-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
            <div class="validation-error" >{{ passwordError }}</div>
          </ValidationProvider>
        </b-form-group>

      </ValidationObserver>
      <div v-else-if="step === 3 && apiError === null">
        <p class="font-weight-light">Użytkownik {{ user.username }} został dodany.</p>
        <b-button size="sm" @click.prevent="$emit('registered', user.username)">Zaloguj się</b-button>
      </div>
      <div v-else-if="step === 3 && apiError !== null">
        <p class="font-weight-light">Wystąpił błąd!</p>
        <p class="font-weight-light" v-if="apiError===409">Istnieje użytkownik o podanej nazwie użytkownika lub adresie email</p>
      </div>
      <b-form-group>
        <b-button size="sm" v-if="step>0 && (step<3 || apiError!==null)" @click.prevent="prevStep" class="margin-right">
          Wstecz
        </b-button>
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
  data: function () {
    return {
      apiError: null,
      passwordError: "",
      focus: false,
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
  methods: {
    submit: function () {
      let vm = this
      this.$refs.form.validate().then(success => {
        if (!success) {
          return
        }
        if (this.user.password.length === 0 || this.user.password !== this.user.confirmPassword) {
          this.passwordError = "Podane hasła nie są identyczne"
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
            }).then(function () {
          vm.step = 3
        }).catch(function (error) {
          vm.apiError = error.response.status
          vm.step = 3
        })
      });

    },
    nextStep: function () {
      let vm = this
      this.$refs.form.validate().then(success => {
        if (!success) {
          return;
        }
        vm.step++
        vm.focus = true;
        vm.$refs.form.reset()
      });

    },
    prevStep: function () {
      let vm = this
      vm.step--
      vm.apiError = null
    }
  },
  mounted: function () {
    this.step = 0
    this.passwordError = ""
  },
  updated: function(){
    if(this.focus){
      this.focus = false
      if(this.$refs.firstName) {
        this.$refs.firstName.focus()
      }
      if(this.$refs.password) {
        this.$refs.password.focus()
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.login-page-form {
  height: 60%;
}

.margin-right {
  margin-right: 5px;
}
</style>
