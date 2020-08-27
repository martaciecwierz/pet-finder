<template>
  <ValidationObserver :key="'loginObserver'" ref="form">
    <div class="register-header">Logowanie</div>
    <b-form class="text-center login-page-form">
      <span v-if="!isSubmitted">
      <ValidationProvider  name="Nazwa użytkownika" rules="required" v-slot="v">
        <b-form-group>
          <b-form-input v-model="user.username" id="username" size="sm" placeholder="Nazwa użytkownika" v-on:keyup.enter="submit"></b-form-input>
        </b-form-group>
        <div class="validation-error">{{ v.errors[0] }}</div>
      </ValidationProvider>
      <ValidationProvider name="Hasło" rules="required|min:8" v-slot="v">
        <b-form-group>
          <b-form-input v-model="user.password" id="password" type="password" placeholder="Hasło"
                        size="sm" v-on:keyup.enter="submit"></b-form-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>
        <b-form-group>
          <b-button size="sm" @click.prevent="submit">Zaloguj</b-button>
        </b-form-group>
      </span>
      <div v-else-if="apiError!==null">
        <p class="font-weight-light">Wystąpił błąd!</p>
        <p class="font-weight-light" v-if="apiError===401">Podano błędną nazwę uyżytkownika lub hasło</p>
        <b-button size="sm" @click.prevent="prevStep">Wstecz</b-button>
      </div>
      <div v-else>
        <p class="font-weight-light">Zalogowano</p>
        <p class="font-weight-light">Za chwilę nastąpi przekierowanie</p>
      </div>
    </b-form>
  </ValidationObserver>
</template>

<script>
import axiosInstance from "@/tools/axiosInstance";
import apiConfig from "@/apiConfig";
import requestHeaders from "@/tools/requestHeaders";

export default {
  name: 'LoginForm',
  props: {
    username: String
  },
    mixins: [
        requestHeaders
    ],
  data: function () {
    return {
      isSubmitted: false,
      apiError: null,
      user: {
        username: "",
        password: ""
      }
    }
  },
  methods: {
    setUsername: function () {
      console.log(this.$props.username)
      this.user.username = this.$props.username
    },
    prevStep: function(){
      this.isSubmitted = false
      this.apiError = null
    },
    submit: function () {
      let vm = this
      this.$refs.form.validate().then(success => {
        if (!success) {
          return
        }
        let postData = {...vm.user}
        axiosInstance
            .post(apiConfig.loginUrl, JSON.stringify(postData), {
              headers: {
                'Content-Type': 'application/json;charset=UTF-8',
                'Access-Control-Allow-Origin': '*'
              }
            }).then(function (response) {
          vm.isSubmitted = true;
          localStorage.setItem('token', response.data.token)
          localStorage.setItem('username', response.data.username)
          setTimeout(function(){ vm.$router.push({name: 'Home'}) }, 3000);
        }).catch(function (error) {
          vm.apiError = error.response.status
          vm.isSubmitted = true;
        })
      });

    },
  },
  mounted: function () {
    console.log('mounted')
    this.setUsername()
  }
}
</script>
