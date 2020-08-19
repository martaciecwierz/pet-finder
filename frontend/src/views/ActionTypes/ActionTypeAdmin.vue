<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <action-type-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import ActionTypeAdminList from "@/components/ActionType/ActionTypeAdminList";

export default {
  components: {
    ActionTypeAdminList,
    AdminMenu
  },
  name: 'PetTypeAdmin',
  data: function () {
    return {}
  }
}
</script>