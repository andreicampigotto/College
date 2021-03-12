<template>
  <form>
      <v-container>
      <v-row>
      <v-col
          cols="12"
          sm="6"
        >
    <v-text-field
        v-model="nome_embarcacao"
        outlined
        clearable
        label="Name da Embarcação"
        @input="$embarcacao.nome.$touch()"
    ></v-text-field>
    </v-col>

    <v-col
          cols="12"
          sm="6"
        >
    <v-text-field
        v-model="fabricante"
        outlined    
        clearable
        label="Fabricante"
        @input="embarcacao.fabricante.$touch()"
    ></v-text-field>
    </v-col>
    
    <v-col
          cols="12"
          sm="6"
        >
    <v-text-field
        v-model="tipo_embarcacao"
        outlined
        clearable
        label="Tipo da Embarcação"
        @input="embarcacao.tipo_embarcacao.$touch()"
    ></v-text-field>
    </v-col>

    <v-col
          cols="12"
          sm="3"
        >
    <v-text-field
        v-model="tamanho_pes"
        outlined
        clearable
        label="Tamanho da Embarcação"
        @input="embarcacao.tamanho_pes.$touch()"
    ></v-text-field>
    </v-col>

    <v-col
          cols="12"
          sm="12"
        >
    <v-textarea
        v-model="observacao"
        outlined
        clearable
        label="Observaçōes"
        @input="embarcacao.observacao.$touch()"
    ></v-textarea>

    <v-btn
      class="success mx-0 mt-3"
      @click="submit"
    >
      submit
    </v-btn>
    <v-btn color="error mt-3 mx-15"
      @click="clear">
      reset
    </v-btn>
    </v-col>
    </v-row>
    </v-container>
  </form>
</template>

<script>
    import axios from 'axios'
        export default {
        name: '/incluir_embarcacao',
        data: () => {
      return {
       nome_embarcacao: '',
       fabricante: '',
       tipo_embarcacao: '',
       tamanho_pes: '',
       observacao: ''
      }
  },
  methods: {
      submit(){
        console.log(this.nome_embarcacao,this.fabricante, this.tipo_embarcacao, this.tamanho_pes, this.observacao)
      },
      clear(){
        this.nome_embarcacao = '',
        this.fabricante = '', 
        this.tipo_embarcacao = '', 
        this.tamanho_pes = '', 
        this.observacao = ''
      }
  },
  mounted() {
      axios.get("http://localhost:5000/incluir_embarcacaos").then(response => {
        console.log(response)
        this.incluir_embarcacao = response.data;
        })
      .catch((error) => {
        console.log(error)
      });
  }
}
</script>
