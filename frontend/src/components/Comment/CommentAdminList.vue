<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <h4>Zarządzanie Komentarzami - {{article.name}}</h4>
    <b-table striped
             hover
             responsive
             :items="comments"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(tools)="data">
        <comment-admin-list-tools :comment="data.item"/>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import CommentAdminListTools from "@/components/Comment/CommentAdminListTools";

export default {
  name: 'CommentAdminList',
  components: {CommentAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'content',
          label: 'Treść',
          sortable: false
        },
        {
          key: 'date',
          label: 'Data',
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
      article:{
        name: 'Pierwszy artykuł'
      },
      comments: [{
        id: 1,
        content: "Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz Pierwszy komentarz ",
        isPublic: true,
        author:{
          username: "siuchninski.t"
        },
        date: "2020-04-03"
      },{
        id: 2,
        content: "Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz Drugi komentarz ",
        isPublic: true,
        author:{
          username: "pierzecki1616"
        },
        date: "2020-06-30"
      },{
        id: 3,
        content: "Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz Ukryty komentarz ",
        isPublic: false,
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
