import Vue from "vue";
import Vuetify from "vuetify";
import "vuetify/dist/vuetify.min.css"; // Add this line

Vue.use(Vuetify);
const opts = {
  theme: {
    dark: true
  },
  options: {
    customProperties: true
  },
};

export default new Vuetify(opts);
