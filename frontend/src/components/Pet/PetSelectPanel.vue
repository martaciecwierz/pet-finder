<template>
    <b-card class="pet">
        <b-row>
            <b-col col md="3" cols="12"><b-img class="pet-image" rounded src="https://i.insider.com/5df126b679d7570ad2044f3e?width=1100&format=jpeg&auto=webp"></b-img>
            </b-col>
            <b-col>
                <h2>{{ pet.name }}</h2>
                <div>{{ pet.description }}</div>
                <h4>Rasa</h4>
                <div>{{ pet.type.name }}</div>
                <h4>Wiek</h4>
                <div>{{ pet.age }}</div>
                <b-row>
                    <b-col>
                        <h4>Schronisko</h4>
                        {{ pet.shelter.name }}
                    </b-col>
                    <b-button v-if="!$props.shelterMode">Przejdź  do schroniska</b-button>
                </b-row>
            </b-col>
        </b-row>

    </b-card>
</template>

<script>
    export default {
        name: 'PetSelectPanel',
        props: {
            pet: Object,
            msg: String,
            shelterMode: Boolean
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
    .pet-image{
        width:100%;
        height: auto;
    }

    .pet{
        text-align: left;
        margin-bottom:7px;
    }

    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
