<template>
  <div class="hello">
    <h1>PostView</h1>
    <br>
    <v-data-table
      :headers="headers"
      :items="items"
      hide-actions
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
        <td>{{ props.item.id }}</td>
        <td class="text-xs-left">{{ props.item.author }}</td>
        <td class="text-xs-left">{{ props.item.blog.title }}</td>
        <td class="text-xs-left">{{ props.item.title }}</td>
        <!-- <td class="text-xs-left">{{ props.item.link }}</td> -->
        <td class="text-xs-left">
          <a v-bind:href='props.item.link' target="_blank"> 보기 </a>
        </td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
  name: 'PostView',
  data () {
    return {
      headers: [
        { align: 'center', sortable: false, text: 'id', value: '' },
        { align: 'center', sortable: false, text: 'Author', value: '' },
        { align: 'center', sortable: false, text: 'Blog Title', value: '' },
        { align: 'center', sortable: false, text: 'Post Title', value: '' },
        { align: 'center', sortable: false, text: 'Link', value: '' }
      ],
      items: []
    }
  },
  activated () {
    this.loadData()
  },
  methods: {
    loadData: function () {
      this.$http.get(`${this.$baseURI}/post/data`)
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
