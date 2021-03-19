package model;

public class Lapis extends Produto {

	private String cor;

	public Lapis(String descricao, Integer quantidade, String marca, Float preco, Integer codigo, String cor) {
		super(descricao, quantidade, marca, preco, codigo);
		this.cor = cor;
	}

	public Lapis(String descricao, String marca, Integer codigo, String cor) {
		super(descricao, marca, codigo);
		this.cor = cor;
	}

	public Lapis(String descricao, String marca, Float preco, Integer codigo, String cor) {
		super(descricao, marca, preco, codigo);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Cor: " + cor + ";";
	}
}
