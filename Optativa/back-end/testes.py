from config import *
from modelo import Embarcacao

#teste 
if __name__ == "__main__": 
    if os.path.exists(arquivobd): 
        os.remove(arquivobd) 
        db.create_all()    

    emb1 = Embarcacao(tipo_embarcacao = "Yacht", fabricante = "azimut",
                 tamanho_pes = "88", nome = "Alda", observacao ="Abastecida G-5", ativo = True)
    
    emb2 = Embarcacao(tipo_embarcacao = "JetSky", fabricante = "SeaDoo",
                 tamanho_pes = "1", nome = "Maria", observacao ="Limpo Doca 2", ativo = True)

    emb3 = Embarcacao(tipo_embarcacao = "lancha", fabricante = "LeveFort",
                 tamanho_pes = "19", nome = "Vespasiano", observacao ="Em manutencao", ativo = False)    




    db.session.add(emb1) 
    db.session.add(emb2) 
    db.session.add(emb3)
    
    db.session.commit() 

    print(emb1)
    print(emb2)
    print(emb3)