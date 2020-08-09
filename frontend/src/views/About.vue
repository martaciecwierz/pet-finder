<template>
  <div class="about">
    <nav-bar/>
    <h1>This is an about page</h1>
  </div>
</template>

<script>
    import NavBar from "../components/UI/Navbar.vue";

    export default {
        components: {NavBar},
        name: 'About',
        data: function(){
            return {
                user: {
                    email: ""
                }
            }
        }
    }
</script>