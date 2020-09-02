<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <shelter-form-modal ref="modal" @refresh="get"/>
    <remove-modal ref="remove" @refresh="get"/>
    <b-row>
      <b-col cols="12" md="10">
        <h4>Zarządzanie schroniskami</h4>
      </b-col>
      <b-col cols="12" md="2" class="add-new-button-col">
        <b-button class="add-new-button" @click.prevent="addModal">Dodaj nowe schronisko</b-button>
      </b-col>
    </b-row>
    <b-table striped
             hover
             responsive
             :items="shelters"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(tools)="data">
        <shelter-admin-list-tools :attribute="data.item" @edit="editModal" @remove="removeModal"/>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import axiosInstance from "../../tools/axiosInstance";
import apiConfig from "@/apiConfig";
import requestHeaders from "../../tools/requestHeaders";
import RemoveModal from "@/components/UI/RemoveModal";
import ShelterFormModal from "@/components/Shelter/ShelterFormModal";
import ShelterAdminListTools from "@/components/Shelter/ShelterAdminListTools";

export default {
  name: 'ShelterAdminList',
  components: {
    ShelterAdminListTools,
    ShelterFormModal,
    RemoveModal,
  },
  mixins: [
    requestHeaders
  ],
  data: function () {
    return {
      fields: [
        {
          key: 'name',
          label: 'Nazwa',
          sortable: false
        },
        {
          key: 'type',
          label: 'Typ',
          sortable: false
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        },
      ],
      shelters: []
    }
  },
  methods: {
    addModal: function () {
      this.$refs.modal.show()
    },
    editModal: function (attribute) {
      this.$refs.modal.show(attribute)
    },
    get: function () {
      let vm = this
      axiosInstance
          .get(apiConfig.shelterGetUrl,
              {headers: vm.headers}
          ).then(function (response) {
        vm.attributes = response.data.attributes
      }).catch(function (error) {
        console.log(error)
      })
    },
    removeModal: function (shelter) {
      this.$refs.remove.show({
        name: shelter.name,
        type: "schronisko",
        endpoint: apiConfig.shelterPostUrl + "/" + shelter.id
      })
    }
  },
  mounted: function () {
    this.get()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
a {
  color: #42b983;
}
</style>
