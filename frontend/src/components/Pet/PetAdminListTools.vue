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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
  .tools-button{
    margin-left: 3px!important;
    text-align: center;
    padding-top: 3px;
    height: 2em;
    display: inline-grid;
    font-size: 1em;
    background-color: lightgrey;
    width: 2em;
    border-radius: 50%;
  }

  .tools-button:hover{
    cursor: pointer;
  }

  .tools{
    text-align: right;

  }
</style>
