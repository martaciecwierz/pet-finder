<template>
  <b-modal :id="modal.id" size="xl" scrollable centered :title="modal.title" @ok.prevent="submitForm">

    <ValidationObserver ref="form">

      <ValidationProvider name="Nazwa" rules="required" v-slot="v">
        <b-form-group
            id="name"
            label="Nazwa schroniska"
            label-for="name">
          <b-input type="text" id="name" v-model="shelter.name" placeholder="Nazwa"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="Ulica" rules="required" v-slot="v">
        <b-form-group
            id="addressStreet"
            label="Ulica"
            label-for="addressStreet">
          <b-input type="text" id="addressStreet" v-model="shelter.addressStreet" placeholder="Ulica"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="Numer budynku" rules="required" v-slot="v">
        <b-form-group
            id="addressBuilding"
            label="Numer"
            label-for="addressBuilding">
          <b-input type="text" id="addressBuilding" v-model="shelter.addressBuilding" placeholder="Numer"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="Miasto" rules="required" v-slot="v">
        <b-form-group
            id="addressCity"
            label="Miasto"
            label-for="addressCity">
          <b-input type="text" id="addressCity" v-model="shelter.addressCity" placeholder="Miasto"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="Kod pocztowy" rules="required" v-slot="v">
        <b-form-group
            id="addressPostCode"
            label="Kod Pocztowy"
            label-for="addressPostCode">
          <b-input type="text" id="addressPostCode" v-model="shelter.addressPostCode"
                   placeholder="Kod Pocztowy"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="E-mail" rules="required|email" v-slot="v">
        <b-form-group
            id="email"
            label="Adres e-mail"
            label-for="addressPostCode">
          <b-input type="email" id="email" v-model="shelter.email" placeholder="E-mail"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="Numer telefonu" rules="" v-slot="v">
        <b-form-group
            id="phone"
            label="Numer telefonu"
            label-for="addressPostCode">
          <b-input type="text" id="phone" v-model="shelter.phone" placeholder="Numer telefonu"></b-input>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>

      <ValidationProvider name="opis" rules="" v-slot="v">
        <b-form-group
            id="description"
            label="Opis"
            label-for="description">
          <b-textarea id="description" v-model="shelter.description" placeholder="Opis..."></b-textarea>
          <div class="validation-error">{{ v.errors[0] }}</div>
        </b-form-group>
      </ValidationProvider>


    </ValidationObserver>
    <template v-slot:modal-footer="{ ok, cancel }">

      <b-button size="sm" variant="outline-secondary" @click="cancel()">
        Anuluj
      </b-button>

      <b-button size="sm" variant="success" @click.prevent="submitForm()">
        {{ modal.confirmText }}
      </b-button>
    </template>
  </b-modal>
</template>

<script>
import axiosInstance from "@/tools/axiosInstance";
import apiConfig from "@/apiConfig";
import requestHeaders from "../../tools/requestHeaders";


export default {
  name: 'ShelterFormModal',
  mixins: [requestHeaders],
  data: function () {
    return {
      modal: {
        id: "shelterForm",
        title: "Nowe schronisko",
        confirmText: "Dodaj"
      },
      shelter: {
        id: "",
        name: "",
        addressStreet: "",
        addressBuilding: "",
        addressCity: "",
        addressPostCode: "",
        email: "",
        phone: "",
        description: ""
      }
    }
  },
  methods: {
    show: function (shelter = null) {
      if (shelter === null) {
        this.shelter = {
          id: null,
          name: "",
          addressStreet: "",
          addressBuilding: "",
          addressCity: "",
          addressPostCode: "",
          email: "",
          phone: "",
          description: ""
        }
        this.modal.title = "Nowe schronisko"
        this.modal.confirmText = "Dodaj"

      } else {
        this.attribute = {...shelter}
        this.modal.title = "Edycja schroniska"
        this.modal.confirmText = "Zmień"

      }
      this.$bvModal.show(this.modal.id)
    },
    submitForm: function () {
      let vm = this
      this.$refs.form.validate().then(success => {
        if (!success) {
          return
        }
        let postData = {...vm.shelter}
        if (postData.id === null) {
          axiosInstance
              .post(apiConfig.shelterPostUrl, JSON.stringify(postData),
                  {headers: vm.headers}
              ).then(function () {
            vm.$emit('refresh')
            vm.$bvModal.hide(vm.modal.id)
          }).catch(function (error) {
            console.log(error)
          })
        } else {
          axiosInstance
              .put(apiConfig.shelterPostUrl + "/" + this.shelter.id, JSON.stringify(postData),
                  {headers: vm.headers}
              ).then(function () {
            vm.$emit('refresh')
            vm.$bvModal.hide(vm.modal.id)
          }).catch(function (error) {
            console.log(error)
          })
        }
      });
    }
  }
}
</script>

