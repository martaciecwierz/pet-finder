<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <h4>Zarządzanie Aktualnościami</h4>
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

export default {
  name: 'ArticleAdminList',
  components: {ArticleAdminListTools},
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
