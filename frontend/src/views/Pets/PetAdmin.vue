<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <pet-admin-list/>
  </b-row>
</template>

<script>
import PetAdminList from "@/components/Pet/PetAdminList";
import AdminMenu from "@/components/UI/AdminMenu";

export default {
  components: {
    AdminMenu,
    PetAdminList
  },
  name: 'PetAdmin',
  data: function () {
    return {}
  }
}
</script>