<template>
    <div>
        <v-app-bar color="#084d6e">
            <v-app-bar-nav-icon @click="drawer = true" color="white"></v-app-bar-nav-icon>
            <v-toolbar-title class="title-text">Embarcações</v-toolbar-title>
        </v-app-bar>

        <v-navigation-drawer
          v-model="drawer"
          absolute
          temporary>

          <v-list
            nav
            dense>

            <v-list-item-group
              v-model="group"
              active-class="deep-purple--text text--accent-4">
          
            <router-link to="/" class="link">
              <v-list-item>
                <v-list-item-title>
                 Home
                </v-list-item-title>
              </v-list-item>
            </router-link>

            <router-link to="listar_embarcacoes" class="link">
              <v-list-item>
                <v-list-item-title>
                    Embarcações
                </v-list-item-title>
              </v-list-item>
            </router-link>

             <router-link to="incluir_embarcacao" class="link">
              <v-list-item>
                <v-list-item-title>
                  Inserir Embarcação
                </v-list-item-title>
              </v-list-item>
            </router-link>

            </v-list-item-group>
          </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
export default {
  name: 'Navigation',
  data: () => ({
      drawer: false,
      group: null,
    }),
}
</script>

<style>
    .title-text {
        color: white;
    }
    
</style>
