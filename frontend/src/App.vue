<template>
  <v-app dark>
  <HeaderView></HeaderView>
  <SideBar></SideBar>
  <v-toolbar app></v-toolbar>
  <v-content>
    <v-container fluid>
      <router-view></router-view>
    </v-container>
  </v-content>
  <!-- <v-footer app></v-footer> -->
</v-app>
</template>

<script>
import HeaderView from './components/HeaderView.vue'
import SideBar from './components/SideBar.vue'

export default{
  components: {
    SideBar,
    HeaderView
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
