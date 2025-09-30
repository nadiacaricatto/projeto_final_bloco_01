package livraria.application;

import java.util.InputMismatchException;
import java.util.Scanner;
import livraria.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {

		int opcao;

		criarLivrosTeste();

		while (true) {

			System.out.println(Cores.TEXT_BLACK_BOLD_BRIGHT + Cores.ANSI_CYAN_BACKGROUND_BRIGHT
					+ "*******************************************************");
			System.out.println("                                                       ");
			System.out.println("               LIVRARIA DO BECO HORIZONTAL             ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("                1 - CADASTRAR LIVRO                    ");
			System.out.println("                2 - LISTAR TODOS OS LIVROS             ");
			System.out.println("                3 - BUSCAR LIVRO POR GÊNERO            ");
			System.out.println("                4 - RECOMENDAR UM LIVRO                ");
			System.out.println("                5 - APAGAR LIVRO CADASTRADO            ");
			System.out.println("                0 - SAIR                               ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("               ENTRE COM A OPÇÃO DESEJADA:             ");
			System.out.println("                                                       " + Cores.TEXT_RESET);

			try {

				opcao = leia.nextInt();
				leia.nextLine();

			} catch (InputMismatchException e) {
				opcao = -1; // opção = -1
				System.out.println("\nDigite um número inteiro entre 0 e 5!");
				leia.nextLine();

			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nLIVRARIA DO BECO HORIZONTAL\n"
						+ "OBRIGADO POR UTILIZAR NOSSO SISTEMA. ATÉ A PRÓXIMA!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "CADASTRAR LIVRO\n\n");
				cadastrarProdutos();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "LISTAR TODOS OS LIVROS\n\n");

				listarProdutos();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "BUSCAR LIVRO POR GÊNERO\n\n");
				procurarPorId();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "RECOMENDAR UM LIVRO\n\n");
				atualizarProdutos();

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "APAGAR LIVRO CADASTRADO\n\n");

				deletarProdutos();

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOPÇÃO INVÁLIDA!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_CYAN_BOLD + "\n*************************************************");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Projeto Dsenvolvido por: ");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Nádia Piccinin Caricatto");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "nadia.caricatto@outlook.com");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "https://github.com/nadiacaricatto");
		System.out.println(Cores.TEXT_CYAN_BOLD + "\n*************************************************");

	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para continuar!");
		leia.nextLine();
	}

	private static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));

	}

	private static void listarContas() {
		contaController.listarTodas();
	}

	private static void cadastrarConta() {

		System.out.println("Digite o número da Agência: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do Produto: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o tipo da produto:\n" + "1 - produto Corrente\n" + "2 - produto Poupança \n");
		int tipo = leia.nextInt();

		System.out.println("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {

		case 1 -> {
			System.out.println("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));

		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da produto: ");
			int aniversario = leia.nextInt();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de produto inválido!" + Cores.TEXT_RESET);

		}

	}

	private static void procurarContaPorNumero() {

		System.out.println("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(id);

	}

	private static void deletarConta() {

		System.out.println("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produto produto = contaController.buscarNaCollection(id);

		if (produto != null) {

			System.out.println("Tem certeza que deseja excluir esta produto?\n" + "Digite 1 para SIM\n"
					+ "Digite 2 para VOLTAR\n");
			int confirma = leia.nextInt();

			if (confirma == 1) {
				contaController.deletar(id);
			} else {
				System.out.println("Que bom que você mudou de ideia! A operação foi cancelada.");
			}

		} else {
			System.out.printf("\nA produto número %d não foi encontrada! Verifique os dados e tente novamente.", id);
		}
	}

	private static void atualizarConta() {
		System.out.print("Digite o número da produto: ");
		int id = leia.nextInt();
		leia.nextLine();

		produto produto = contaController.buscarNaCollection(id);

		if (produto != null) {

			String titular = produto.getTitular();
			int tipo = produto.getTipo();
			float saldo = produto.getSaldo();

			// a ? é chamada de if ternário ou operador ternário
			/*
			 * é a mesma coisa que fazer um if else, sendo: if (entrada.isEmpty()) { agencia
			 * = agencia }else { System.out.println("Digite a nova agência:)
			 */

			System.out.printf("Agência Atual: %d.\n Pressione ENTER para manter a Agência atual"
					+ "\nOU\nInsira a Nova Agência: ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);// a ? nesse caso é condição: se entrada
																				// for vazia, mantenha agência, senão ->
																				// converta para inteiro

			System.out.printf(
					"Titular Atual: %s.\n Pressione ENTER para manter o Titular atual" + "\nOU\nInsira Novo Titular: ",
					titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;

			System.out.printf(
					"Saldo Atual: %.2f\nPressione ENTER para manter o Saldo atual" + "\nOU\nInsira Novo Saldo: ",
					saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);

		}

		leia.close();

	}

}
