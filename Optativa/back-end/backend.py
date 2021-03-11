from config import *
from modelo import Embarcacao

@app.route("/")
def padrao():
    return "backend operante"

@app.route("/listar_embarcacoes", methods= ["get"])
def listar_embarcacao():
    embarcacoes = db.session.query(Embarcacao).all()
    retorno = []
    for e in embarcacoes:
        retorno.append(e.json())
    resposta = jsonify(retorno)
    resposta.headers.add("Access-Control-Allow-Origin", "*")
    return resposta

@app.route("/incluir_embarcacao", methods= ["post"])
def incluir_embarcacao():
    resposta = jsonify ({"resultado" : "ok", "detalhes" : "ok"})
    dados = request.get_json()
    try: #tenta executar a acao e nao esta funcionando
        nova = Embarcacao(**dados) #cria um novo gabarito
        db.session.add(nova) #adiciona no bd
        db.session.commit() #efetiva a gravacao
    except Exception as e : # em caso de erro 
        resposta = jsonify({"resultado" : "error", 
                            "detalhes" : str(e)})

    resposta.headers.add("Access-Control-Allow-Origin", "*")
    return resposta #responde


app.run(debug = True)