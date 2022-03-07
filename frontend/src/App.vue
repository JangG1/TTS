<template>
<div id="app">
    <!-- asdf -->
    <!-- <router-link to="/">Home</router-link> |
    <router-link to="/Login">Login</router-link> -->
    <router-view />
    <informDiv />
    
</div>
</template>

<script>
import informDiv from '@/views/informDiv.vue'
export default {
    name: 'Main',
    components: {
        informDiv
    },
}
</script>

<style>
html {
    overflow-y: scroll;
}

#app {
    max-width: 80%;
    margin-left: 10%;

}
</style>
