import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugings/vuetify.js";
import router from "./routes.js";

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  vuetify,
  router,
}).$mount("#app");
