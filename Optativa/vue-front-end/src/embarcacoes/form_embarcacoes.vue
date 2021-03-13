<template>
  <form>
    <h2>Cadastro: </h2>
      <v-container>
      <v-row>
      <v-col
          cols="12"
          sm="6"
        >
    <v-text-field
        v-model="nome"
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
        Submit
      </v-btn>
      <v-btn color="error mt-3 mx-15"
        @click="clear">
        Reset
      </v-btn>
    </v-col>
    </v-row>
    </v-container>
  </form>
</template>

<script>
    import axios from 'axios'
        export default {
          data(){
        return {
          nome: '',
          fabricante: '',
          tipo_embarcacao: '',
          tamanho_pes: '',
          observacao: '',
          ativo: "True",
      }
  },
  methods: {
      submit(){
          axios({
          method: 'post', // verbo http
          url: 'http://localhost:5000/incluir_embarcacaos', // url
          data: {
            nome: this.nome,
            fabricante: this.fabricante, 
            tipo_embarcacao: this.tipo_embarcacao, 
            tamanho_pes: this.tamanho_pes, 
            observacao: this.observacao, 
            ativo: this.ativo
          }
          })
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error)
            })
            
          this.nome= '',
          this.fabricante= '',
          this.tipo_embarcacao= '',
          this.tamanho_pes= '',
          this.observacao= ''
        },
      clear(){
        this.nome= '',
        this.fabricante= '',
        this.tipo_embarcacao= '',
        this.tamanho_pes= '',
        this.observacao= ''
      },
      deletarEmbarcacao(){
        this.ativo = false
      }
  }
}
</script>
