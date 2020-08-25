<template>
<div class="tools">
        <span class="tools-button">
            <a v-if="!pet.adopted" @click="console.log('Adopt')" v-b-tooltip.hover :title="'Status adopcji - nieadoptowany'"><b-icon-x/></a>
            <a v-else @click="console.log('Adopt')" v-b-tooltip.hover :title="'Status adopcji - adoptopwany'"><b-icon-check/></a>
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
  name: 'PetAdminListTools',
  props: {
    pet: Object
  },
  data: function () {
    return {
    }
  }
}
</script>

