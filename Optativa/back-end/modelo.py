from config import *

class Embarcacao(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    tipo_embarcacao = db.Column(db.String(254))
    fabricante = db.Column(db.String(254))
    tamanho_pes = db.Column(db.Integer) #para jet nao se aplica
    nome = db.Column(db.String(254))
    observacao = db.Column(db.String(500))
    ativo = db.Column(db.Boolean)

    def __str__(self):
        return str(self.id) + "," + self.tipo_embarcacao + ", " + self.fabricante + ", " + \
               ", " + str(self.tamanho_pes) + self.nome + ", " + self.observacao + ", " + str(self.ativo)

    def json(self):
        return {
            "id" : self.id,
            "tipo_embarcacao" : self.tipo_embarcacao,
            "fabricante" : self.fabricante,
            "tamanho_pes" : self.tamanho_pes,
            "nome" : self.nome,
            "observacao" : self.observacao,
            "ativo" : self.ativo
        }

if __name__ == "__main__":
    if os.path.exists(arquivobd):
        os.remove(arquivobd)


db.create_all()

##nova = Embarcacao(tipo_embarcacao = "yacht", fabricante = "azimut",
##                tamanho_pes = "64", nome = "Alda", observacao ="Abastecida G-5", ativo = True)

##db.session.add(nova)
##db.session.commit()
todas = db.session.query(Embarcacao).all()

for e in todas:
    print(e)
    print(e.json())
