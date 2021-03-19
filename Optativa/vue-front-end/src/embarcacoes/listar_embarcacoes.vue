<template>
<v-container class="v-container-true" v-if="listar_embarcacoes.length > 0">
  <v-card
    class="mx-auto my-12"
    max-width="400"
    v-for="embarcacao of listar_embarcacoes" :key="embarcacao.ativo === True"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-card-title>{{embarcacao.nome}}</v-card-title>
    <v-card-subtitle>{{embarcacao.tipo_embarcacao + " " + embarcacao.fabricante + " " + embarcacao.tamanho_pes + "ft"}}</v-card-subtitle>

    <v-card-text>

      <div class="my-4 subtitle-1">
        • Observações:
      </div>

      <div>{{embarcacao.observacao}}</div>
    </v-card-text>
    <v-btn
        class="ma-1"
        color="error"
        solo
        @click="remove(embarcacao.id)"
      >
        Deletar
      </v-btn>
  </v-card>
 </v-container>
</template>

<script>
import axios from 'axios'
axios.defaults.headers.post['Access-Control-Allow-Headers'] ='*';
axios.defaults.headers.post['Access-Control-Allow-Origin'] ='*';
export default {
  name: 'listar_embarcacoes',
  data: () => {
      return {
       listar_embarcacoes: null
      }
  },
  mounted() {
      axios.get("http://localhost:5000/listar_embarcacoes").then(response => {
        console.log(response)
        this.listar_embarcacoes = response.data;
        })
      .catch((error) => {
        console.log(error)
      });
  },
  methods: {
    remove(id){ 
      axios.delete(`http://localhost:5000/excluir_embarcacao/${id}`,{ crossdomain: true }).then(response => {
        console.log(response)})
      .catch((error) => {
        console.log(error)
      });
    }
  },
}
</script>
