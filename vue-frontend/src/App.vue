<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <h1>
        URL Shortener Assignment
      </h1>
    </v-app-bar>

    <v-main>
      <Shortener/>
    </v-main>
  </v-app>
</template>

<script>
import Shortener from './components/Shortener';

export default {
  name: 'App',

  components: {
    Shortener,
  },

  data: () => ({
    //
  }),
};
</script>
