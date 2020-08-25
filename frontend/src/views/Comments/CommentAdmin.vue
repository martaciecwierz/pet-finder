<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <comment-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import CommentAdminList from "@/components/Comment/CommentAdminList";

export default {
  components: {
    CommentAdminList,
    AdminMenu
  },
  name: 'ArticleAdmin',
  data: function () {
    return {}
  }
}
</script>