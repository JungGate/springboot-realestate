<template>
  <div class="hello">
    <h1>RssView</h1>
    <br>
    <v-data-table
      :headers="headers"
      :items="items"
      hide-actions
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
        <td>{{ props.item.id }}</td>
        <td class="text-xs-left">
          <a v-bind:href='props.item.url' target="_blank"> {{ props.item.url }} </a>
        </td>
        <td>{{ props.item.initUpdateDate }}</td>
        <td>{{ props.item.lastUpdateDate }}</td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
  name: 'RssView',
  data () {
    return {
      headers: [
        { align: 'center', sortable: false, text: 'id', value: 'id' },
        { align: 'center', sortable: false, text: 'Blog URL', value: 'url' },
        { align: 'center', sortable: false, text: 'Create Date', value: 'subscribeDate' },
        { align: 'center', sortable: false, text: 'Update Date', value: 'updateDate' }
      ],
      items: []
    }
  },
  activated () {
    this.loadData()
  },
  methods: {
    loadData: function () {
      this.$http.get(`${this.$baseURI}/rss/data`)
        .then((result) => {
          console.log(result)
          this.items = result.data
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
  color: #42b983;
}
a {
  font-weight: bold;
  color: #42b983;
}
</style>
