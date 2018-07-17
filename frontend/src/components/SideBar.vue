<template>
  <v-navigation-drawer
      clipped
      fixed
      app
    >
      <v-list dense>
        <v-list-tile v-for="menu in menus" v-on:click="say(menu.id)" :key="menu.id">
          <v-list-tile-action>
            <v-icon>featured_play_list</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{ menu.title }}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

      </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
      menus: [
        {
          title: 'Rss 리스트 조회',
          id: 'menu_rss'
        },
        {
          title: 'Blog 리스트 조회',
          id: 'menu_blog'
        },
        {
          title: 'Post 리스트 조회',
          id: 'menu_post'
        }
      ]
    }
  },
  props: {
    parentData: {
      type: String,
      default () {
        return ''
      }
    }
  },
  methods: {
    say (message) {
      console.log(message)
      this.$emit('selectMenu', message)
    }
  },
  beforeMount () {
    console.log('this.parentData : ' + this.parentData)
  }
}
</script>
