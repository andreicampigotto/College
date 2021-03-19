from config import *
from modelo import Embarcacao
from flask import  jsonify, request

@app.route("/")
@cross_origin()
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
#@cross_origin()
def incluir_embarcacao():
    resposta = jsonify ({"resultado" : "ok", "detalhes" : "ok"})
    dados = request.get_json()
    print(dados)
    try: #tenta executar a acao e nao esta funcionando
        nova = Embarcacao(**dados) #cria um novo gabarito
        db.session.add(nova) #adiciona no bd
        db.session.commit() #efetiva a gravacao
    except Exception as e : # em caso de erro 
        resposta = jsonify({"resultado" : "error",
                            "detalhes" : str(e)})

    resposta.headers.add("Access-Control-Allow-Origin", "*")
    return resposta #responde
@app.route("/excluir_embarcacao/<id>", methods= ["delete"])
@cross_origin()
def excluir_embarcacao(id):
    resposta = jsonify({"resultado": "ok", "detalhes": "ok"}) 
    try: 
       # excluir a pessoa do ID informado 
       Embarcacao.query.filter(Embarcacao.id == id).delete() 
       db.session.commit() 
    except Exception as e: 
       # informar mensagem de erro 
       resposta = jsonify({"resultado":"erro", "detalhes":str(e)}) 
    resposta.headers.add("Access-Control-Allow-Origin", "*") 
    return resposta

app.run(debug = True)