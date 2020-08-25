<template>
<div class="tools">
        <span class="tools-button">
            <a v-if="!comment.isPublic" @click="console.log('Hide')" v-b-tooltip.hover :title="'Status wyświetlania - Ukryty'"><b-icon-x/></a>
            <a v-else @click="console.log('Hide')" v-b-tooltip.hover :title="'Status wyświetlania - Widoczny'"><b-icon-check/></a>
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
  name: 'CommentAdminListTools',
  props: {
    comment: Object
  },
  data: function () {
    return {
    }
  }
}
</script>

