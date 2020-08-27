<template>
<div class="tools">
        <span class="tools-button">
            <a @click="edit($props.attribute)" v-b-tooltip.hover :title="'Edytuj'"><b-icon-pencil/></a>
        </span>
        <span class="tools-button">
            <a @click="remove($props.attribute)" v-b-tooltip.hover :title="'Usuń'"><b-icon-trash/></a>
        </span>
    </div>
</template>

<script>
export default {
  name: 'AttributeAdminListTools',
  props: {
    attribute: Object
  },
  data: function () {
    return {
    }
  },
    methods: {
      edit: function (attribute) {
        this.$emit('edit', attribute)
      },
      remove: function (attribute) {
        this.$emit('delete', attribute)
      }
    }
}
</script>

