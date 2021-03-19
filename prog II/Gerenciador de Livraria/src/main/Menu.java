package main;

import java.util.List;
import java.util.Scanner;

import enums.Modelo;
import controller.GerenciaEstoque;
import enums.Tamanho;

public class Menu {

	private GerenciaEstoque gerenciaEstoque = new GerenciaEstoque();

	public void run(){
		Scanner teclado = new Scanner(System.in);
		this.mostrarMenu(teclado);
		teclado.close();
	}

	private void mostrarMenu(Scanner teclado) {
		int resposta = 0;
		do {
			try{
				System.out.println("-------- GERENCIADOR DE LIVRARIA --------");
				System.out.println("1 - Adicionar produto");
				System.out.println("2 - Vender");
				System.out.println("3 - Adicionar ao estoque");
				System.out.println("4 - Mostrar todos os movimentos");
				System.out.println("5 - Mostrar os movimentos de entrada");
				System.out.println("6 - Mostrar os movimentos de sa�da");
				System.out.println("7 - Mostrar o estoque");
				System.out.println("8 - Sair");
				resposta = Integer.parseInt(teclado.nextLine());
				opcoesMenuPrincipal(resposta, teclado);
			} catch (NumberFormatException e) {
				System.out.println("Formato de n�mero inv�lido. Tente novamente.");
			}
		} while (resposta != 8);

	}

	private void opcoesMenuPrincipal(int opcao, Scanner teclado) {
		switch (opcao) {
		case 1:
			mostrarMenuProdutos(teclado);
			break;
		case 2:
			venderProduto(teclado);
			break;
		case 3:
			adicionarEstoque(teclado);
			break;
		case 4:
			mostrarMovimentosTodos();
			break;
		case 5:
			mostrarMovimentosEntrada();
			break;
		case 6:
			mostrarMovimentosSaida();
			break;
		case 7:
			mostrarEstoque();
			break;
		case 8:
			System.out.println("Esperamos que volte!");
			break;
		default:
			System.out.println("A op��o inserida n�o est� dispon�vel.");
		}
	}

	private void opcoesMenuProdutos(int opcao, Scanner teclado) {
		switch (opcao) {
			case 1:
				adicionarLapis(teclado);
				break;
			case 2:
				adicionarPapel(teclado);
				break;
			case 3:
				adicionarBorracha(teclado);
				break;
			case 4:
				adicionarCaneta(teclado);
				break;
			case 5:
				opcoesMenuPrincipal(opcao, teclado);
				break;
			default:
				System.out.println("A op��o inserida n�o est� dispon�vel.");
		}
	}

	public void mostrarMenuProdutos(Scanner teclado) {
		int resposta = 0;
		do {
			try {
				System.out.println("-------- PRODUTOS DISPON�VEIS --------");
				System.out.println("1 - L�pis");
				System.out.println("2 - Papel");
				System.out.println("3 - Borracha");
				System.out.println("4 - Caneta");
				System.out.println("5 - Voltar");
				resposta = Integer.parseInt(teclado.nextLine());
				opcoesMenuProdutos(resposta, teclado);
			} catch (NumberFormatException e){
				System.out.println("Formato de n�mero inv�lido. Tente novamente.");
			}
		} while (resposta != 5);

	}

	private void venderProduto(Scanner teclado) {
		System.out.println("-------- VENDER ITEM --------");

		System.out.println("Informe o c�digo do item");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe o quantidade do item");
		String quantidadeParametro = teclado.nextLine();
		Integer quantidade = Integer.parseInt(quantidadeParametro);
		String mensagem = gerenciaEstoque.venderProduto(codigo, quantidade);
		System.out.println(mensagem);

		System.out.println("-----------------------------");

	}

	private void adicionarEstoque(Scanner teclado) {
		System.out.println("-------- ADICIONAR AO ESTOQUE --------");
		System.out.println("Informe o c�digo do produto:");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe o quantidade do produto:");
		String quantidadeParametro = teclado.nextLine();
		Integer quantidade = Integer.parseInt(quantidadeParametro);
		String mensagem = gerenciaEstoque.adicionarEstoque(codigo, quantidade);
		System.out.println(mensagem);

		System.out.println("--------------------------------------");

	}

	private void adicionarPapel(Scanner teclado) {
		System.out.println("-------- ADICIONAR PAPEL --------");
		System.out.println("Informe a descri��o do papel:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca do papel:");
		String marca = teclado.nextLine();
		System.out.println("Informe o pre�o do papel:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o c�digo do papel:");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe o tamanho do papel (A4, A5, A1):");
		Modelo tamanho = Modelo.valueOf(teclado.nextLine());
	
		String mensagem = gerenciaEstoque.adicionarPapel(descricao, marca, preco, codigo,
				tamanho);
		System.out.println(mensagem);

		System.out.println("---------------------------------");

	}

	private void adicionarCaneta(Scanner teclado) {
		System.out.println("-------- ADICIONAR CANETA --------");
		System.out.println("Informe a descri��o da caneta:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca da caneta:");
		String marca = teclado.nextLine();
		System.out.println("Informe o pre�o da caneta:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o c�digo da caneta:");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe a cor da caneta:");
		String cor = teclado.nextLine();
		String mensagem = gerenciaEstoque.adicionarCaneta(descricao, marca, preco, codigo,
				cor);
		System.out.println(mensagem);

		System.out.println("----------------------------------");
	}

	private void adicionarLapis(Scanner teclado) {
		System.out.println("-------- ADICIONAR L�PIS --------");
		System.out.println("Informe a descri��o do l�pis:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca do l�pis:");
		String marca = teclado.nextLine();
		System.out.println("Informe o pre�o do l�pis:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o c�digo do l�pis:");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe a cor do l�pis:");
		String cor = teclado.nextLine();
		String mensagem = gerenciaEstoque.adicionarLapis(descricao, marca, preco, codigo,
				cor);
		System.out.println(mensagem);

		System.out.println("----------------------------------");
	}

	private void adicionarBorracha(Scanner teclado) {
		System.out.println("-------- ADICIONAR BORRACHA --------");
		System.out.println("Digite a descri��o da borracha:");
		String descricao = teclado.nextLine();
		System.out.println("Digite a marca da borracha:");
		String marca = teclado.nextLine();
		System.out.println("Digite o pre�o da borracha:");
		String precoParam = teclado.nextLine();
		Float preco = Float.parseFloat(precoParam);
		System.out.println("Digite o c�digo da borracha:");
		String codigoParam = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParam);
		System.out.println("Informe o tamanho da borracha. Escolha entre os valores a seguir, certificando-se de digit�-lo da mesma maneira como est� sendo exibido (Pequeno" +
				"M�dio ou Grande):");
		String tamanho = teclado.nextLine();
		String mensagem = gerenciaEstoque.adicionarBorracha(descricao, marca, preco,
				codigo, Tamanho.valueOf(tamanho));
		System.out.println(mensagem);

		System.out.println("------------------------------------");

	}

	private void mostrarMovimentosTodos() {
		List<String> movimentos = gerenciaEstoque.formatarExibicaoMovimento();
		System.out.println("-------- TODOS OS MOVIMENTOS --------");
		for (String string : movimentos) {
			System.out.println(string);
		}
		System.out.println("-------------------------------------");
	}

	private void mostrarMovimentosEntrada() {
		List<String> movimentos = gerenciaEstoque.formatarExibicaoEntrada();

		System.out.println("-------- MOVIMENTO DE ENTRADA --------");
		for (String string : movimentos) {
			System.out.println(string);
		}
		System.out.println("--------------------------------------");
	}

	private void mostrarMovimentosSaida() {
		List<String> movimentos = gerenciaEstoque.formatarExibicaoSaida();

		System.out.println("-------- MOVIMENTO DE SA�DA --------");
		for (String string : movimentos) {
			System.out.println(string);

		}
		System.out.println("------------------------------------");
	}
	
	private void mostrarEstoque() {
		List<String> estoque = gerenciaEstoque.formatarExibicaoProduto();
		System.out.println("-------- ITENS NO ESTOQUE --------");
		for (String string : estoque) {
			System.out.println(string);
		}

		System.out.println("----------------------------------");

	}

	private Integer validarInteger(String informacao){
		try {
			return Integer.parseInt(informacao);
		} catch (NumberFormatException e){
			System.out.println("Formato de n�mero inv�lido!");
			return null;
		}
	}

}
