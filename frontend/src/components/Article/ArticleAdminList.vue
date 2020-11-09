<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <article-form-modal ref="modal"/>
    <b-row>
      <b-col cols="12" md="10">
        <h4>Zarządzanie artykułami</h4>
      </b-col>
      <b-col cols="12" md="2" class="add-new-button-col">
        <b-button class="add-new-button" @click.prevent="addModal">Dodaj Artykuł</b-button>
      </b-col>
    </b-row>
    <b-table striped
             hover
             responsive
             :items="articles"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(name)="data">
        <span v-b-tooltip.hover :title="data.item.description">{{ data.item.name }}</span>
      </template>
      <template v-slot:cell(tools)="data">
        <article-admin-list-tools :article="data.item"/>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import ArticleAdminListTools from "@/components/Article/ArticleAdminListTools";
import ArticleFormModal from "@/components/Article/ArticleFormModal";
import axiosInstance from "@/tools/axiosInstance";
import apiConfig from "@/apiConfig";

export default {
  name: 'ArticleAdminList',
  components: {ArticleFormModal, ArticleAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'title',
          label: 'Tytuł',
          sortable: false
        },
        {
          key: 'date',
          label: 'Data',
          sortable: false
        },
        {
          key: 'shelter.name',
          label: 'Schronisko',
          sortable: false
        },
        {
          key: 'author.username',
          label: 'Autor',
          sortable: false
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        }
      ],
      articles: [{
        id: 1,
        title: "Pierwszy artykuł",
        isPublished: true,
        shelter:{
          name: "Schronisko w Poznaniu",
        },
        author:{
          username: "siuchninski.t"
        },
        date: "2020-04-03"
      },{
        id: 2,
        title: "Drugi artykuł",
        isPublished: true,
        shelter:{
          name: "Schronisko w Gorzowie",
        },
        author:{
          username: "pierzecki1616"
        },
        date: "2020-06-30"
      },{
        id: 3,
        title: "Nieopublikowany artykuł",
        isPublished: false,
        shelter:{
          name: "Schronisko w Gorzowie",
        },
        author:{
          username: "pierzecki1616"
        },
        date: "2020-08-30"
      },]
    }
  },
  methods: {
    addModal(){
      this.$refs.modal.show()
    },
    get: function () {
      let vm = this
      axiosInstance
          .get(apiConfig.articlesGetUrl,
              {headers: vm.headers}
          ).then(function (response) {
        vm.attributes = response.data.attributes
      }).catch(function (error) {
        console.log(error)
      })
    },
  },
  mounted() {
    this.get()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h4 {
  margin: 30px 0 0;
}

a {
  color: #42b983;
}
</style>
