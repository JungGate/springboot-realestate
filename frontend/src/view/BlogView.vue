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
        <td class="text-xs-left">{{ props.item.title }}</td>
        <td class="text-xs-left">{{ props.item.description }}</td>
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
        { align: 'center', sortable: false, text: 'id', value: '' },
        { align: 'center', sortable: false, text: 'Title', value: '' },
        { align: 'center', sortable: false, text: 'Description', value: '' }
      ],
      items: []
    }
  },
  activated () {
    this.loadData()
  },
  methods: {
    loadData: function () {
      this.$http.get(`${this.$baseURI}/blog/data`)
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
