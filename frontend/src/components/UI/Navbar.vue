<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <b-navbar class="nav" toggleable="lg" type="dark" variant="success">
        <b-navbar-brand href="#">NavBar</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
            <b-navbar-nav>
                <b-nav-item href="#" @click.prevent="$router.push({name: 'PetList'})">Zwierzęta</b-nav-item>
                <b-nav-item href="#">Zapotrzebowanie</b-nav-item>
            </b-navbar-nav>

            <b-navbar-nav class="ml-auto">

                <b-nav-item-dropdown text="Schroniska" right>
                    <b-dropdown-item v-for="shelter in shelters" v-bind:key="shelter.id" href="#">{{shelter.name}}</b-dropdown-item>
                </b-nav-item-dropdown>

                <b-nav-item-dropdown right v-if="isLogged()">
                    <template v-slot:button-content>
                        <b-icon-person></b-icon-person>
                        <em>{{ getUsername() }}</em>
                    </template>
                    <b-dropdown-item href="#" @click.prevent="$router.push({name: 'UserProfile'})">Profil użytkownika</b-dropdown-item>
                    <b-dropdown-item href="#" @click.prevent="$router.push({name: 'PetAdmin'})">Administracja</b-dropdown-item>
                    <b-dropdown-item href="#" @click.prevent="logout">Wyloguj</b-dropdown-item>
                </b-nav-item-dropdown>
                <b-nav-item href="#" v-else @click.prevent="$router.push({name: 'Login'})">Logowanie / Rejestracja</b-nav-item>

            </b-navbar-nav>


        </b-collapse>
    </b-navbar>
</template>


<script>
    export default {
        name: 'NavBar',
        data: function(){
            return {
                shelters: [
                    {
                        id: 1,
                        name: "Schronisko 1"
                    },
                    {
                        id: 2,
                        name: "Schronisko 2"
                    },
                    {
                        id: 3,
                        name: "Schronisko 3"
                    }
                ]
            }
        },
        methods: {
            isLogged: function(){
                if(localStorage.getItem("token")){
                    return true;
                }
                return false;
            },
            logout: function(){
                localStorage.removeItem("token")
                localStorage.removeItem("username")
                this.$router.push({name: 'Logout'})
            },
            getUsername: function(){
                return localStorage.getItem("username")
            }
        }
    }
</script>
<style scoped>
    .nav{
        margin-bottom: 5px;
        position: fixed;
        top: 0;
        width: 100%;
        z-index: 100;
    }
</style>