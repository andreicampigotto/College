import listar_embarcacoes from "./embarcacoes/listar_embarcacoes.vue";
import form_embarcacoes from "./embarcacoes/form_embarcacoes.vue";
import Home from "./home/home";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/incluir_embarcacao",
    name: "form_embarcacoes",
    component: form_embarcacoes,
  },
  
  {
    path: "/listar_embarcacoes",
    name: "embarcacoes",
    component: listar_embarcacoes,
  },
  {
    path: "/",
    name: "home",
    component: Home,
  },
];
const router = new VueRouter({ mode: "history", base: __dirname, routes });

export default router;
