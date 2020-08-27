<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <attribute-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import AttributeAdminList from "@/components/Attribute/AttributeAdminList";

export default {
  components: {
      AttributeAdminList,
    AdminMenu
  },
  name: 'AttributeAdmin',
  data: function () {
    return {}
  }
}
</script>