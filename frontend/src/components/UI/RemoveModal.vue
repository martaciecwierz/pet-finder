<template>
  <b-modal :id="modal.id" size="xl" scrollable centered title="Usuwanie" @ok.prevent="remove">

    Czy na pewno chcesz usunąć {{ item.type }} {{ item.name }}?
    <template v-slot:modal-footer="{ ok, cancel }">

      <b-button size="sm" variant="outline-secondary" @click="cancel()">
        Anuluj
      </b-button>

      <b-button size="sm" variant="danger" @click.prevent="remove">
        Usuń
      </b-button>
    </template>
  </b-modal>
</template>

<script>
import axiosInstance from "@/tools/axiosInstance";
import requestHeaders from "../../tools/requestHeaders";


export default {
  name: 'RemoveModal',
  mixins: [requestHeaders],
  data: function () {
    return {
      modal: {
        id: "removeModal"
      },
      item: {
        name: "",
        type: "",
        endpoint: ""
      }
    }
  },
  methods: {
    show: function (item) {

      this.item = {...item}
      this.$bvModal.show(this.modal.id)
    },
    remove: function () {
      let vm = this
      axiosInstance
          .delete(this.item.endpoint,
              {headers: vm.headers}
          ).then(function () {
        vm.$emit('refresh')
        vm.$bvModal.hide(vm.modal.id)
      }).catch(function (error) {
        console.log(error)
      })
    }
  }
}
</script>

