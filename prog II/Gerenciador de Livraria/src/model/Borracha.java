package model;

import enums.Tamanho;

public class Borracha extends Produto {

	private Tamanho tamanho;

	public Borracha(String descricao, Integer quantidade, String marca, Float preco, Integer codigo, Tamanho tamanho) {
		super(descricao, quantidade, marca, preco, codigo);
		this.tamanho = tamanho;
	}

	public Borracha(String descricao, String marca, Integer codigo, Tamanho tamanho) {
		super(descricao, marca, codigo);
		this.tamanho = tamanho;
	}

	public Borracha(String descricao, String marca, Float preco, Integer codigo, Tamanho tamanho) {
		super(descricao, marca, preco, codigo);
		this.tamanho = tamanho;
	}


	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "Tamanho: " + tamanho + ";";
	}
}
