<template>
<v-app>
  <div id="app">
    <Navigation />
    <v-main>
      <router-view></router-view>
    </v-main>
  </div>
</v-app>
</template>
<script>
import Navigation from './navigation/index.vue'
export default {
  name: 'App',
  components: {
    Navigation
  }
}
</script>

<style>
    .link {
      text-decoration: none;
    }
</style>
