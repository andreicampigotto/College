import Embarcacoes from "../src/components/listar_embarcacoes.vue";
import Home from "./components/home.vue";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/embarcacoes",
    name: "embarcacoes",
    component: Embarcacoes,
  },
  {
    path: "/",
    name: "home",
    component: Home,
  },
];
const router = new VueRouter({ mode: "history", base: __dirname, routes });

export default router;
