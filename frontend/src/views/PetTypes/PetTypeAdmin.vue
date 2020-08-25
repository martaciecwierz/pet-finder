<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <pet-type-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import PetTypeAdminList from "@/components/PetType/PetTypeAdminList";

export default {
  components: {
    PetTypeAdminList,
    AdminMenu
  },
  name: 'PetTypeAdmin',
  data: function () {
    return {}
  }
}
</script>