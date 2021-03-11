<template>
<v-container class="v-container-true" v-if="embarcacoes.length > 0">
  <v-card
    class="mx-auto my-12"
    max-width="374"
    v-for="embarcacao of embarcacoes" :key="embarcacao.id"
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
        • Observações
      </div>

      <div>{{embarcacao.observacao}}</div>
    </v-card-text>
  </v-card>
 </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Embarcacoes',
  data: () => {
      return {
        embarcacoes: null
      }
  },
  mounted() {
      axios.get("http://localhost:5000/listar_embarcacoes").then(response => {
        console.log(response)
        this.embarcacoes = response.data;
        })
      .catch((error) => {
        console.log(error)
      });
  }
}
</script>
