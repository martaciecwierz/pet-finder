<template>
    <b-modal :id="modal.id" size="xl" scrollable centered :title="modal.title" @ok.prevent="submitForm">

        <ValidationObserver ref="form">

            <ValidationProvider name="Tytuł" rules="required" v-slot="v">
                <b-form-group
                        id="name"
                        label="Tytuł artykułu"
                        label-for="title">
                    <b-input type="text" id="title" v-model="article.title" placeholder="Tytuł"></b-input>
                    <div class="validation-error">{{ v.errors[0] }}</div>
                </b-form-group>
            </ValidationProvider>

            <ValidationProvider name="Treść" rules="required" v-slot="v">
                <b-form-group
                        id="content"
                        label="Treść"
                        label-for="content">
                    <b-textarea id="content" v-model="article.content" placeholder="Proszę wprowadzić treść artykułu">
                    </b-textarea>
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
        name: 'ArticleFormModal',
        mixins: [requestHeaders],
        data: function () {
            return {
                modal: {
                    id: "articleModal",
                    title: "Nowy artykuł",
                    confirmText: "Dodaj"
                },
                article: {
                    id: null,
                    title: "",
                    date: "",
                    content: "",
                }
            }
        },
        methods: {
            show: function (article = null) {
                if (article === null) {
                    this.article = {
                        id: null,
                        title: "",
                        content: "",
                        date: "",
                    }
                    this.modal.title= "Nowy artykuł"
                    this.modal.confirmText= "Dodaj"

                } else {
                    this.article = { ...article }
                    this.modal.title = "Edycja artykułu"
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
                    let postData = {...vm.article}
                    postData.date = new Date().toISOString()
                    if(postData.id===null) {
                        postData.shelterId = 1
                        axiosInstance
                            .post(apiConfig.articlePostUrl, JSON.stringify(postData),
                                {headers: vm.headers}
                            ).then(function (response) {
                            console.log("OK", response)
                            vm.$emit('refresh')
                            vm.$bvModal.hide(vm.modal.id)
                        }).catch(function (error) {
                            console.log(error)
                        })
                    } else {
                      axiosInstance
                          .put(apiConfig.articlePostUrl + "/" + this.article.id, JSON.stringify(postData),
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

