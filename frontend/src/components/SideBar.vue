<template>
  <v-navigation-drawer
      clipped
      fixed
      app
    >
      <v-list dense>
        <v-list-tile v-for="menu in menus" v-on:click="say(menu.value)">
          <v-list-tile-action>
            <v-icon>dashboard</v-icon>
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
          title: 'RSS 리스트 조회',
          value: 1
        },
        {
          title: 'Blog 리스트 조회',
          value: 2
        },
        {
          title: 'Post 리스트 조회',
          value: 3
        }
      ]
    }
  },
  props: {
    source: String
  },
  methods: {
    say (message) {
      alert(message)
    }
  }
}
</script>
