/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author vilso
 */
@ManagedBean
public class beanContato {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String validaIdade(){
        //representa a view que chamou o bean
       FacesContext context = FacesContext.getCurrentInstance();
       //escreve na view a mensagem gerada
       FacesMessage msgView = null;
       
       if(this.nome.equals("")){
           msgView = new FacesMessage(FacesMessage.SEVERITY_INFO,"Informe nome", "");
           context.addMessage(null, msgView);    
           return "";
       }
       
       if(this.idade < 1){
           msgView = new FacesMessage(FacesMessage.SEVERITY_INFO,"Informe idade", "");
           context.addMessage(null, msgView);    
           return "";
       }
       
       String msg = "maior de idade";
       if (this.idade < 17){
          msg = "menor de idade.";
       }
       
       String info = this.nome + " com " + this.idade + " você é " + msg;
       msgView = new FacesMessage(FacesMessage.SEVERITY_INFO, info, "");
       context.addMessage(null, msgView);
       
       return "mostraDadosContato.jsf";
    }
}
