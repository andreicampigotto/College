package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import enums.Modelo;
import enums.Tamanho;
import model.Borracha;
import model.Caneta;
import model.Historico;
import model.interfaces.ProdutoInterface;
import model.Lapis;
import model.Papel;
import enums.TipoMovimento;

public class GerenciaEstoque {

	private ArrayList<ProdutoInterface> estoque;
	private ArrayList<Historico> movimentos;

	public GerenciaEstoque() {
		super();
		this.estoque = new ArrayList<>();
		this.movimentos = new ArrayList<>();
	}

	public String venderProduto(Integer codigo, Integer quantidade) {
		ProdutoInterface produtoInterface = buscarProduto(codigo);

		if (quantidade > produtoInterface.getQuantidade()) {
			return "A quantidade no estoque é insuficiente.";
		}

		this.validarObjetoNulo(produtoInterface, "O produto não existe.");
		this.validarInformacaoComMensagem(quantidade, "A quantidade informada é inválida.");

		produtoInterface.setQuantidade(produtoInterface.getQuantidade() - quantidade);

		Historico movimento = new Historico(produtoInterface, quantidade, TipoMovimento.SAIDA);

		movimentos.add(movimento);

		return "Venda do " + produtoInterface.getDescricao() + " realizada com sucesso.";
	}

	public String adicionarEstoque(Integer codigo, Integer quantidade) {
		ProdutoInterface produtoInterface = buscarProduto(codigo);

		this.validarObjetoNulo(produtoInterface, "Produto inexistente.");

		this.validarInformacaoComMensagem(quantidade, "A quantidade informada é inválida.");

		produtoInterface.setQuantidade(produtoInterface.getQuantidade() + quantidade);
		Historico movimento = new Historico(produtoInterface, quantidade, TipoMovimento.ENTRADA);
		movimentos.add(movimento);

		return "O estoque foi atualizado com sucesso.";
	}

	public String adicionarBorracha(String descricao, String marca, Float preco, Integer codigo, Tamanho tamanho) {

		Borracha borracha = new Borracha(descricao, marca, preco, codigo, tamanho);

		estoque.add(borracha);
		return "A borracha foi adicionada com sucesso.";
	}

	public String adicionarLapis(String descricao, String marca, Float preco, Integer codigo, String cor) {
		this.validarInformacaoComMensagem(codigo, "O produto com o código informado já existe.");
		this.validarInformacaoComMensagem(preco, "Não é possível colocar preço de valor negativo no produto.");

		ProdutoInterface lapis = new Lapis(descricao, marca, preco, codigo, cor);

		estoque.add(lapis);
		return "O lápis foi adicionado com sucesso.";
	}

	public String adicionarCaneta(String descricao, String marca, Float preco, Integer codigo, String cor) {

		this.validarInformacaoComMensagem(codigo, "O produto com o código informado já existe.");
		this.validarInformacaoComMensagem(preco, "Não é possível colocar preço de valor negativo no produto.");

		Caneta caneta = new Caneta(descricao, marca, preco, codigo, cor);
		estoque.add(caneta);
		return "A caneta foi adicionada com sucesso.";
	}

	public String adicionarPapel(String descricao, String marca, Float preco, Integer codigo, Modelo tamanho) {

		this.validarInformacaoComMensagem(codigo, "O produto com o código informado já existe.");
		this.validarInformacaoComMensagem(preco, "Não é possível colocar preço de valor negativo no produto.");

		Papel papel = new Papel(descricao, 0, marca, preco, codigo, tamanho);
		estoque.add(papel);
		return "O papel foi adicionado com sucesso.";

	}

	public List<String> formatarExibicaoProduto() {
		List<String> exibicao = new ArrayList<>();
		for (ProdutoInterface produtoInterface : estoque) {
			exibicao.add(produtoInterface.toString());
		}

		return exibicao;
	}

	public List<String> formatarExibicaoMovimento() {
		List<String> exibicao = new ArrayList<>();
		for (Historico historico : movimentos) {
			exibicao.add(historico.toString());
		}
		return exibicao;
	}

	public List<String> formatarExibicaoEntrada() {
		List<String> exibicao = new ArrayList<>();
		for (Historico historico : movimentos) {
			if (historico.getTipo().equals(TipoMovimento.ENTRADA)) {
				exibicao.add(historico.toString());
			}
		}
		return exibicao;
	}

	public List<String> formatarExibicaoSaida() {
		List<String> exibicao = new ArrayList<>();
		for (Historico historico : movimentos) {
			if (historico.getTipo().equals(TipoMovimento.SAIDA)) {
				exibicao.add(historico.toString());
			}
		}
		return exibicao;
	}

	private Boolean verificarValorNegativo(Float valor) {
		return valor < 0 ? true : false;
	}

	private String validarObjetoNulo(Object objeto, String mensagem){
		if(Objects.isNull(objeto)){
			return mensagem;
		}
		return null;
	}

	private Boolean verificarProdutoJaCadastrado(Integer codigo) {
		for (ProdutoInterface produtoInterface : estoque) {
			if (produtoInterface.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}

	public String validarInformacaoComMensagem(Integer informacao, String mensagem){
		if(verificarProdutoJaCadastrado(informacao)){
			return mensagem;
		}
		return null;
	}

	public String validarInformacaoComMensagem(Float informacao, String mensagem){
		if(verificarValorNegativo(informacao)){
			return mensagem;
		}
		return null;
	}

	private ProdutoInterface buscarProduto(Integer codigo) {
		for (ProdutoInterface produtoInterface : estoque) {
			if (produtoInterface.getCodigo().equals(codigo)) {
				return produtoInterface;
			}
		}
		return null;
	}
}
