<template>
    <b-col cols="12" md="8" lg="10" class="text-left">
        <attribute-form-modal ref="modal"/>
        <b-row>
            <b-col cols="12" md="10">
                <h4>Zarządzanie bazą atrybutów</h4>
            </b-col>
            <b-col cols="12" md="2" class="add-new-button-col">
                <b-button class="add-new-button" @click.prevent="addModal">Dodaj nowy atrybut</b-button>
            </b-col>
        </b-row>
        <b-table striped
                 hover
                 responsive
                 :items="attributes"
                 :fields="fields"
                 :columns="fields">
            <template v-slot:cell(tools)="data">
                <attribute-admin-list-tools :attribute="data.item" @edit="editModal"/>
            </template>
        </b-table>
    </b-col>
</template>

<script>
    import AttributeAdminListTools from "./AttributeAdminListTools.vue";
    import AttributeFormModal from "./AttributeFormModal.vue";
    import axiosInstance from "../../tools/axiosInstance";
    import apiConfig from "@/apiConfig";
    import requestHeaders from "../../tools/requestHeaders";

    export default {
        name: 'AttributeAdminList',
        components: {
            AttributeFormModal,
            AttributeAdminListTools
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
                attributes: []
            }
        },
        methods: {
            addModal: function(){
                this.$refs.modal.show()
            },
            editModal: function(attribute){
                this.$refs.modal.show(attribute)
            },
            get: function(){
                let vm = this
                axiosInstance
                    .get(apiConfig.attributeGetUrl,
                        {headers: vm.headers}
                    ).then(function (response) {
                        vm.attributes = response.data.attributes
                }).catch(function (error) {
                    console.log(error)
                })
            }
        },
        mounted: function(){
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
