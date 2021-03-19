package model;

import enums.TipoMovimento;
import model.interfaces.ProdutoInterface;

public class Historico {
	private ProdutoInterface item;
	private Integer quantidade;
	private TipoMovimento tipo;

	public Historico(ProdutoInterface item, Integer quantidade, TipoMovimento tipo) {
		super();
		this.item = item;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}

	public ProdutoInterface getItem() {
		return item;
	}

	public void setItem(ProdutoInterface item) {
		this.item = item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Código: " + item.getCodigo() + "; Descrição: " + item.getDescricao() + "; Quantidade: " + quantidade
				+ "; Tipo: " + tipo + ";";
	}

}
