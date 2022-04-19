<template>
  <div id="app">
    <!-- <navBar /> -->
       <router-view />

  </div>
</template>

<script>
// import navBar from './components/navBar.vue'

export default {
  name: 'App',
  components: {
    // navBar
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  
  
}

body{
  margin: 0;
  background-color: #f5f5f5;
}
</style>
