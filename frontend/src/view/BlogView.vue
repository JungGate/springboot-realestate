<template>
  <div class="hello">
    <h1>BlogView</h1>
    <br>
    <v-data-table
      :headers="headers"
      :items="items"
      hide-actions
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
        <td>{{ props.item.id }}</td>
        <td class="text-xs-left">{{ props.item.url }}</td>
        <td>{{ props.item.initUpdateDate }}</td>
        <td>{{ props.item.lastUpdateDate }}</td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
  name: 'BlogView',
  data () {
    return {
      headers: [
        { align: 'center', sortable: false, text: 'id', value: 'id' },
        { align: 'center', sortable: false, text: 'Blog URL', value: 'url' },
        { align: 'center', sortable: false, text: 'Create Date', value: 'initUpdateDate' },
        { align: 'center', sortable: false, text: 'Update Date', value: 'lastUpdateDate' }
      ],
      items: [
        {
          'id': 1,
          'url': 'https://rss.blog.naver.com/mltmkr.xml',
          'initUpdateDate': '2018-03-20 13:33:08.008',
          'lastUpdateDate': null
        }
      ]
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
</style>
