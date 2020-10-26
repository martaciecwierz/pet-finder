<template>
  <b-card class="w-100">
    <b-card-body class="w-100">
      <ValidationObserver ref="form">

        <ValidationProvider name="Aktualne hasło" rules="required" v-slot="v">
          <b-form-group
              id="currentPassword"
              label="Aktualne hasło"
              label-for="currentPassword">
            <b-input type="password" id="currentPassword" v-model="user.currentPassword" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>

        <ValidationProvider name="Nowe hasło" rules="required" v-slot="v">
          <b-form-group
              id="newPassword"
              label="Nowe hasło"
              label-for="newPassword">
            <b-input type="password" id="newPassword" v-model="user.newPassword" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>

        <ValidationProvider name="Nowe hasło (powtórz)" rules="required" v-slot="v">
          <b-form-group
              id="newPasswordConfirm"
              label="Nowe hasło (powtórz)"
              label-for="newPasswordConfirm">
            <b-input type="password" id="newPasswordConfirm" v-model="user.newPasswordConfirm" placeholder=""></b-input>
            <div class="validation-error">{{ v.errors[0] }}</div>
          </b-form-group>
        </ValidationProvider>
      </ValidationObserver>
      <div class="w-100 text-right">
        <b-button @click="submitData">Zmień hasło</b-button>
      </div>
    </b-card-body>
  </b-card>
</template>

<script>
import axiosInstance from "@/tools/axiosInstance";
import apiConfig from "@/apiConfig";
import requestHeaders from "../../tools/requestHeaders";

export default {
  name: "ChangePasswordForm",
  data(){
    return {
      user: {
        currentPassword: "",
        newPassword: "",
        newPasswordConfirm: ""
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
        let postData = {...vm.shelter}
          axiosInstance
              .put(apiConfig.passwordChangePutUrl, JSON.stringify(postData),
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