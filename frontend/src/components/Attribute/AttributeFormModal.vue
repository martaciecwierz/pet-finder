<template>
    <b-modal :id="modal.id" size="xl" scrollable centered :title="modal.title" @ok.prevent="submitForm">

        <ValidationObserver ref="form">

            <ValidationProvider name="Nazwa" rules="required" v-slot="v">
                <b-form-group
                        id="name"
                        label="Nazwa atrybutu"
                        label-for="input-1">
                    <b-input type="text" id="name" v-model="attribute.name" placeholder="Nazwa"></b-input>
                    <div class="validation-error">{{ v.errors[0] }}</div>
                </b-form-group>
            </ValidationProvider>

            <ValidationProvider name="Typ wartości" rules="required" v-slot="v">
                <b-form-group
                        id="name"
                        label="Typ wartości"
                        label-for="type">
                    <b-select id="type" v-model="attribute.type">
                        <option>String</option>
                        <option>Integer</option>
                        <option>Float</option>
                        <option>Boolean</option>
                    </b-select>
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
        name: 'AttributeFormModal',
        mixins: [requestHeaders],
        data: function () {
            return {
                modal: {
                    id: "attributeName",
                    title: "Nowy atrybut",
                    confirmText: "Dodaj"
                },
                attribute: {
                    id: "",
                    name: "",
                    type: "",
                }
            }
        },
        methods: {
            show: function (attribute = null) {
                if (attribute === null) {
                    this.attribute = {
                        id: "",
                        name: "",
                        type: "",
                    }
                } else {
                    this.attribute = { ...attribute }
                }
                this.$bvModal.show(this.modal.id)
            },
            submitForm: function () {
                let vm = this
                this.$refs.form.validate().then(success => {
                    if (!success) {
                        return
                    }
                    let postData = {...vm.attribute}
                    if(postData.id===null) {
                        axiosInstance
                            .post(apiConfig.attributePostUrl, JSON.stringify(postData),
                                {headers: vm.headers}
                            ).then(function (response) {
                            console.log("OK", response)
                            vm.$emit('refresh')
                            vm.$bvModal.hide(vm.modal.id)
                        }).catch(function (error) {
                            console.log(error)
                        })
                    } else {
                        //TODO
                    }
                });
            }
        }
    }
</script>

