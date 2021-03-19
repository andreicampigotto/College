package model;

import model.interfaces.ProdutoInterface;

public class Produto implements ProdutoInterface {

	private String descricao;
	private Integer quantidade = 0;
	private String marca;
	private Float preco = 0.0F;
	private Integer codigo;

	public Produto(String descricao, Integer quantidade, String marca, Float preco, Integer codigo) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.marca = marca;
		this.preco = preco;
		this.codigo = codigo;
	}

	public Produto(String descricao, String marca, Float preco, Integer codigo) {
		super();
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
		this.codigo = codigo;
	}

	public Produto(String descricao, String marca, Integer codigo) {
		super();
		this.descricao = descricao;
		this.marca = marca;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "; Descrição: " + descricao + "; Marca: " + marca + "; Quantidade: " + quantidade
				+ "; Preço: " + preco + "; ";
	}

}
