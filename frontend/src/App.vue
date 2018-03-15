<template>
  <v-app dark>
  <HeaderView></HeaderView>
  <SideBar
  :parentData="parentData"
  @selectMenu="selectMenu"></SideBar>
  <v-toolbar app></v-toolbar>
  <v-content>
    <v-container fluid>
      <transition name="fade" mode="out-in">
        <keep-alive>
          <component :is="contentView"></component>
        </keep-alive>
      </transition>
    </v-container>
  </v-content>
  <!-- <v-footer app></v-footer> -->
</v-app>
</template>

<script>
import Vue from 'vue'
import HeaderView from './components/HeaderView.vue'
import SideBar from './components/SideBar.vue'
import RssView from './view/RssView'
import BlogView from './view/BlogView'
import PostView from './view/PostView'

export default{
  components: {
    SideBar,
    HeaderView
  },
  data () {
    return {
      parentData: 'init data',
      contentView: 'rss-view'
    }
  },
  methods: {
    selectMenu (event) {
      if (event === 'menu_rss') {
        this.contentView = 'rss-view'
      } else if (event === 'menu_blog') {
        this.contentView = 'blog-view'
      } else if (event === 'menu_post') {
        this.contentView = 'post-view'
      }
    }
  }
}

Vue.component('rss-view', {
  components: {
    RssView
  },
  template: '<RssView></RssView>'
})

Vue.component('blog-view', {
  components: {
    BlogView
  },
  template: '<BlogView></BlogView>'
})

Vue.component('post-view', {
  components: {
    PostView
  },
  template: '<PostView></PostView>'
})

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
