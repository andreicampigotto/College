/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



@ManagedBean
public class BeanSaudacao {
   private String nome;
   private String sobrenome;
   private String nomeCompleto;
  
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

   public void gerarNomeCompleto(){
       //representa a view que chamou o bean
       FacesContext context = FacesContext.getCurrentInstance();
       //escreve na view a mensagem gerada
       FacesMessage msgView = null;
       
       if(this.nome.equals("")){
           msgView = new FacesMessage(FacesMessage.SEVERITY_INFO,"Informe nome", "");
           context.addMessage(null, msgView);           
       }
       
       if(this.nome.equals("")){
           msgView = new FacesMessage(FacesMessage.SEVERITY_INFO,"Informe sobrenome", "");
           context.addMessage(null, msgView);           
       }
       
        
       this.nomeCompleto = this.nome.concat(" ").concat(this.sobrenome);
   }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

  }
