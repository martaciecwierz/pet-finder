<template>
  <b-card class="w-100">
    <b-modal id="image-modal" size="lg" title="Zdjęcie">
      <img :src="selectedImage">
    </b-modal>
    <b-card-body class="w-100">
      <h3>Zdjęcia</h3>
      <b-row cols="6">
        <span class="img-thumbnail" @click="showBigImage(image.location)" :key="image.id" v-for="image in $props.images">
        <img :src="image.location"/>
          </span>
      </b-row>
    </b-card-body>
  </b-card>
</template>

<script>
export default {
name: "PetProfileImages",
  props: {
  images: Array
  },
  data(){
  return {
    selectedImage: ""
  }
  },
  methods: {
    showBigImage(location) {
      this.selectedImage = location
      this.$bvModal.show('image-modal')
    }
  }
}
</script>

<style scoped>
  img{
    width: 100%
  }
</style>