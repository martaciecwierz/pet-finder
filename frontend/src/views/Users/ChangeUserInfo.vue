<template>
  <b-row cols="12" class="admin">
    <user-menu/>
    <b-col cols="12" md="8" lg="10" class="text-left">
      <change-user-info-form/>
    </b-col>
  </b-row>
</template>

<script>
import UserMenu from "@/components/UI/UserMenu";
import ChangeUserInfoForm from "@/components/User/ChangeUserInfoForm";

export default {
  name: "ChangeUserInfo",
  components: {ChangeUserInfoForm, UserMenu}
}
</script>

<style scoped>

</style>