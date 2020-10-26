<template>
  <b-row cols="12" class="admin">
    <user-menu/>
    <b-col cols="12" md="8" lg="10" class="text-left">
      <change-password-form/>
    </b-col>
  </b-row>
</template>

<script>
import UserMenu from "@/components/UI/UserMenu";
import ChangePasswordForm from "@/components/User/ChangePasswordForm";

export default {
  name: "ChangePassword",
  components: {ChangePasswordForm, UserMenu}
}
</script>

<style scoped>

</style>