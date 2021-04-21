/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author vilso
 */
@ManagedBean
public class BeanProduto {
    private List<Produto> lista = new ArrayList<>();
    
    @PostConstruct
    public void init() {
       lista.add(new Produto(1, "trigo", 1.89f, 10));
       lista.add(new Produto(2, "Soja", 7.89f, 20));
       lista.add(new Produto(3, "Açucar", 9.85f, 30));
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

}
