<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-form ref="form">
        <v-text-field label="Enter Link to Shorten" v-model="originalLink"></v-text-field>
        <v-btn elevation="2" @click="convert" :loading="loading">Convert</v-btn>
        </v-form>
        <v-text-field :value="convertedLink" :readonly="true" label="Converted Link"></v-text-field>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

  import axios from "axios";

  export default {
    name: 'UrlShortener',
    data(){
      return {
        originalLink: null,
        convertedLink:null,
        loading: false
      }
    },
    methods:{
      convert(){
        this.loading = true
        if(this.originalLink != "")
        {
          axios.post('http://localhost:3306/add?' + new URLSearchParams({link: this.originalLink}).toString())
              .then(res => {
                if(res.status === 200) {
                  this.convertedLink = "http://localhost:3306/"+ res.data
                }
              })
        }
        this.loading = false
      }
    }
  }
</script>
