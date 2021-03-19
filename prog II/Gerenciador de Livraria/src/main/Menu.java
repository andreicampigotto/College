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
				System.out.println("6 - Mostrar os movimentos de saída");
				System.out.println("7 - Mostrar o estoque");
				System.out.println("8 - Sair");
				resposta = Integer.parseInt(teclado.nextLine());
				opcoesMenuPrincipal(resposta, teclado);
			} catch (NumberFormatException e) {
				System.out.println("Formato de número inválido. Tente novamente.");
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
			System.out.println("A opção inserida não está disponível.");
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
				System.out.println("A opção inserida não está disponível.");
		}
	}

	public void mostrarMenuProdutos(Scanner teclado) {
		int resposta = 0;
		do {
			try {
				System.out.println("-------- PRODUTOS DISPONÍVEIS --------");
				System.out.println("1 - Lápis");
				System.out.println("2 - Papel");
				System.out.println("3 - Borracha");
				System.out.println("4 - Caneta");
				System.out.println("5 - Voltar");
				resposta = Integer.parseInt(teclado.nextLine());
				opcoesMenuProdutos(resposta, teclado);
			} catch (NumberFormatException e){
				System.out.println("Formato de número inválido. Tente novamente.");
			}
		} while (resposta != 5);

	}

	private void venderProduto(Scanner teclado) {
		System.out.println("-------- VENDER ITEM --------");

		System.out.println("Informe o código do item");
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
		System.out.println("Informe o código do produto:");
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
		System.out.println("Informe a descrição do papel:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca do papel:");
		String marca = teclado.nextLine();
		System.out.println("Informe o preço do papel:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o código do papel:");
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
		System.out.println("Informe a descrição da caneta:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca da caneta:");
		String marca = teclado.nextLine();
		System.out.println("Informe o preço da caneta:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o código da caneta:");
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
		System.out.println("-------- ADICIONAR LÁPIS --------");
		System.out.println("Informe a descrição do lápis:");
		String descricao = teclado.nextLine();
		System.out.println("Informe a marca do lápis:");
		String marca = teclado.nextLine();
		System.out.println("Informe o preço do lápis:");
		String precoParametro = teclado.nextLine();
		Float preco = Float.parseFloat(precoParametro);
		System.out.println("Informe o código do lápis:");
		String codigoParametro = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParametro);
		System.out.println("Informe a cor do lápis:");
		String cor = teclado.nextLine();
		String mensagem = gerenciaEstoque.adicionarLapis(descricao, marca, preco, codigo,
				cor);
		System.out.println(mensagem);

		System.out.println("----------------------------------");
	}

	private void adicionarBorracha(Scanner teclado) {
		System.out.println("-------- ADICIONAR BORRACHA --------");
		System.out.println("Digite a descrição da borracha:");
		String descricao = teclado.nextLine();
		System.out.println("Digite a marca da borracha:");
		String marca = teclado.nextLine();
		System.out.println("Digite o preço da borracha:");
		String precoParam = teclado.nextLine();
		Float preco = Float.parseFloat(precoParam);
		System.out.println("Digite o código da borracha:");
		String codigoParam = teclado.nextLine();
		Integer codigo = Integer.parseInt(codigoParam);
		System.out.println("Informe o tamanho da borracha. Escolha entre os valores a seguir, certificando-se de digitá-lo da mesma maneira como está sendo exibido (Pequeno" +
				"Médio ou Grande):");
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

		System.out.println("-------- MOVIMENTO DE SAÍDA --------");
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
			System.out.println("Formato de número inválido!");
			return null;
		}
	}

}
