<template>
  <b-row cols="12" class="admin">
    <user-menu/>
    <b-col cols="12" md="8" lg="10" class="text-left">
      <user-profile-summary/>
    </b-col>
  </b-row>
</template>

<script>
import UserMenu from "@/components/UI/UserMenu";
import UserProfileSummary from "@/components/User/UserProfileSummary";
export default {
name: "UserProfile",
  components: {UserProfileSummary, UserMenu}
}
</script>

<style scoped>

</style>