<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <article-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import ArticleAdminList from "@/components/Article/ArticleAdminList";

export default {
  components: {
    ArticleAdminList,
    AdminMenu
  },
  name: 'ArticleAdmin',
  data: function () {
    return {}
  }
}
</script>