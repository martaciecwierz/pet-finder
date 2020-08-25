<template>
<div class="tools">
        <span class="tools-button">
            <a v-if="!article.isPublished" @click="console.log('Publish')" v-b-tooltip.hover :title="'Status publikacji - Nieopublikowany'"><b-icon-x/></a>
            <a v-else @click="console.log('Publish')" v-b-tooltip.hover :title="'Status publikacji - Opublikowany'"><b-icon-check/></a>
        </span><span class="tools-button">
            <a @click="$router.push({name: 'CommentAdmin', params: {articleId: article.id}})" v-b-tooltip.hover :title="'Komentarze'"><b-icon-reply-all/></a>
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
  name: 'ArticleAdminListTools',
  props: {
    article: Object
  },
  data: function () {
    return {
    }
  }
}
</script>

