<template>
<div class="tools">
        <span class="tools-button">
            <a @click="edit($props.shelter)" v-b-tooltip.hover :title="'Edytuj'"><b-icon-pencil/></a>
        </span>
        <span class="tools-button">
            <a @click="remove($props.shelter)" v-b-tooltip.hover :title="'Usuń'"><b-icon-trash/></a>
        </span>
    </div>
</template>

<script>
export default {
  name: 'ShelterAdminListTools',
  props: {
    attribute: Object
  },
  data: function () {
    return {
    }
  },
    methods: {
      edit: function (shelter) {
        this.$emit('edit', shelter)
      },
      remove: function (shelter) {
        this.$emit('remove', shelter)
      }
    }
}
</script>

