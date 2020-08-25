<template>
<div class="tools">
        <span class="tools-button">
            <a @click="console.log('Change Password')" v-b-tooltip.hover :title="'Zmień hasło'"><b-icon-lock/></a>
        </span>
        <span class="tools-button">
            <a @click="console.log('Edit')" v-b-tooltip.hover :title="'Edytuj'"><b-icon-pencil/></a>
        </span>
        <span class="tools-button">
            <a @click="console.log('Delete')" v-b-tooltip.hover :title="'Usuń'"><b-icon-trash/></a>
        </span>
    </div>
</template>

<script>
export default {
  name: 'UserAdminListTools',
  props: {
    user: Object
  },
  data: function () {
    return {
    }
  }
}
</script>

