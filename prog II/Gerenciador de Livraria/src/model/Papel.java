package model;

import enums.Modelo;

public class Papel extends Produto {

	private Modelo tamanho;

	public Papel(String descricao, Integer quantidade, String marca, Float preco, Integer codigo, Modelo tamanho) {
		super(descricao, quantidade, marca, preco, codigo);
		this.tamanho = tamanho;
	}

	public Papel(String descricao, String marca, Float preco, Integer codigo, Modelo tamanho) {
		super(descricao, marca, preco, codigo);
		this.tamanho = tamanho;
	}

	public Papel(String descricao, String marca, Integer codigo, Modelo tamanho) {
		super(descricao, marca, codigo);
		this.tamanho = tamanho;
	}

	public Modelo getTamanho() {
		return tamanho;
	}

	public void setTamanho(Modelo tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return super.toString() + "Tamanho: " + tamanho.getDescricao() + ";";
	}

}
