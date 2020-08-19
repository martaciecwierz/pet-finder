<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <user-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import UserAdminList from "@/components/User/UserAdminList";

export default {
  components: {
    UserAdminList,
    AdminMenu
  },
  name: 'UserAdmin',
  data: function () {
    return {}
  }
}
</script>