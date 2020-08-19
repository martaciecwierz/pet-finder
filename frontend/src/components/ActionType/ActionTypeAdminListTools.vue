<template>
<div class="tools">
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
  name: 'ActionTypeAdminListTools',
  props: {
    pet: Object
  },
  data: function () {
    return {
    }
  }
}
</script>

