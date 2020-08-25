<template>
  <b-col cols="12" md="8" lg="10" class="text-left">
    <h4>Zarządzanie rodzajami aktywności</h4>
    <b-table striped
             hover
             :items="types"
             :fields="fields"
             :columns="fields">
      <template v-slot:cell(tools)="data">
        <user-admin-list-tools :type="data.item"/>
      </template>
      <template v-slot:cell(isAdmin)="data">
        <span v-if="data.item.isAdmin"><b-icon-check/></span>
        <span v-else><b-icon-x/></span>
      </template>
    </b-table>
  </b-col>
</template>

<script>
import UserAdminListTools from "@/components/User/UserAdminListTools";

export default {
  name: 'UserAdminList',
  components: {UserAdminListTools},
  data: function () {
    return {
      fields: [
        {
          key: 'username',
          label: 'Nazwa Użytkownika',
          sortable: false
        },
        {
          key: 'firstName',
          label: 'Imię',
          sortable: false
        },
        {
          key: 'lastName',
          label: 'Nazwisko',
          sortable: false
        },
        {
          key: 'email',
          label: 'E-mail',
          sortable: false
        },
        {
          key: 'points',
          label: 'Punkty',
          sortable: false
        },
        {
          key: 'isAdmin',
          label: 'Administrator',
          sortable: false,
          class: 'text-center'
        },
        {
          key: 'tools',
          label: '',
          sortable: false
        },
      ],
      types: [{
        id: 1,
        username: "siuchninski.t",
        firstName: "Tomasz",
        lastName: "Siuchniński",
        email: "siuchninski.t@gmail.com",
        points: 10000,
        isAdmin: true,
      },{
        id: 2,
        username: "pierzecki1616",
        firstName: "Marek",
        lastName: "Pierzecki",
        email: "pierzecki1616@gmail.com",
        points: 10,
        isAdmin: false,
      }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h4 {
  margin: 30px 0 0;
}

a {
  color: #42b983;
}
</style>
