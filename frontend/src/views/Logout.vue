<template>
  <div class="logout">
    <nav-bar/>
    <h4>Zostałeś wylogowany</h4>
  </div>
</template>

<script>
    import NavBar from "../components/UI/Navbar.vue";

    export default {
        components: {NavBar},
        name: 'Logout',
        data: function(){
            return {
            }
        }
    }
</script>