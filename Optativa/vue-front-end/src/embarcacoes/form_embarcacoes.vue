<template>
  <form>
      <v-container>
      <v-row>
      <v-col
          cols="12"
          sm="6"
        >
    <v-text-field
        v-model="model"
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
        v-model="model"
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
        v-model="model"
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
        v-model="model"
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
    <v-text-field
        v-model="model"
        outlined
        clearable
        label="Observaçōes"
        @input="embarcacao.tamanho_pes.$touch()"
    ></v-text-field>

    <v-btn
      class="mr-4"
      @click="submit"
    >
      submit
    </v-btn>
    <v-btn @click="clear">
      clear
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
       listar_embarcacoes: null
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

