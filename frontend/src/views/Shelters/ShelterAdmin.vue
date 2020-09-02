<template>
  <b-row cols="12" class="admin">
    <admin-menu/>
    <shelter-admin-list/>
  </b-row>
</template>

<script>
import AdminMenu from "@/components/UI/AdminMenu";
import ShelterAdminList from "@/components/Shelter/ShelterAdminList";


export default {
  components: {
    ShelterAdminList,
    AdminMenu
  },
  name: 'ShelterAdmin',
  data: function () {
    return {}
  }
}
</script>