<template>
  <div class="w-100 mb-4">
      <b-row class="border-bottom pb-2">
        <b-col cols="2">*****</b-col>
        <b-col cols="10">
          <div>
            <small>{{$props.rate.author}}, {{$props.rate.date}}</small>
          </div>
          <div v-if="$props.rate.comment">
            {{$props.rate.comment}}
          </div>
          <div v-else>Brak komentarza</div>
        </b-col>
      </b-row>

  </div>
</template>

<script>
export default {
name: "PetRate",
  props: {
    rate: Object
  }
}
</script>

<style scoped>
  img{
    width: 100%
  }
</style>