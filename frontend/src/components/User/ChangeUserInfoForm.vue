<template>
  <b-card class="w-100">
    <b-card-body class="w-100">
      <ValidationObserver ref="form">

        <ValidationProvider name="Imię" rules="required" v-slot="v">
          <b-form-group
              id="firstName"
              label="Imię"
              label-for="firstName">
            <b-input type="text" id="firstName" v-model="user.firstName" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>

        <ValidationProvider name="Nazwisko" rules="required" v-slot="v">
          <b-form-group
              id="lastName"
              label="Nazwisko"
              label-for="lastName">
            <b-input type="text" id="lastName" v-model="user.lastName" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>

        <ValidationProvider name="Adres e-mail" rules="required" v-slot="v">
          <b-form-group
              id="email"
              label="Adres e-mail"
              label-for="email">
            <b-input type="email" id="email" v-model="user.email" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>
      </ValidationObserver>
      <div class="w-100 text-right">
        <b-button @click="submitData()">Zapisz</b-button>
      </div>
    </b-card-body>
  </b-card>
</template>

<script>
import axiosInstance from "@/tools/axiosInstance";
import apiConfig from "@/apiConfig";
import requestHeaders from "../../tools/requestHeaders";

export default {
  name: "ChangeUserInfoForm",
  data(){
    return {
      user: {
        firstName: "",
        lastName: "",
        email: ""
      }
    }
  },
  mixins: [requestHeaders],
  methods: {
    submitData() {
      let vm = this
      this.$refs.form.validate().then(success => {
        if (!success) {
          return
        }
        let postData = {...vm.user}
          axiosInstance
              .put(apiConfig.userPutUrl, JSON.stringify(postData),
                  {headers: vm.headers}
              ).then(function () {
            vm.$router.push({name: 'UserProfile'})
          }).catch(function (error) {
            console.log(error)
            vm.$router.push({name: 'UserProfile'})//todo Usunąć jak będzie działać
          })

      })
    }
  }
}
</script>

<style scoped>

</style>