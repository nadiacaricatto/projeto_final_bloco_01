package livraria.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.LivrariaController;
import livraria.util.Cores;
import livraria.model.Infantil;
import livraria.model.Livros;
import livraria.model.Terror;

public class Menu {

	private  static Scanner leia = new Scanner(System.in);
	private static LivrariaController controller = new LivrariaController();
	

	public static void main(String[] args) {

		int opcao;

		criarLivrosTeste();
		
		while (true) {

			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_GREEN_BACKGROUND
					+ "*******************************************************");
			System.out.println("                                                       ");
			System.out.println("              🧙 LIVRARIA DO BECO HORIZONTAL 🐦‍🔥        ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("                1 - CADASTRAR LIVRO  🪄                ");
			System.out.println("                2 - LISTAR TODOS OS LIVROS 🧚          ");
			System.out.println("                3 - BUSCAR LIVRO POR GÊNERO 🧙‍♂️         ");
			System.out.println("                4 - BUSCAR LIVRO POR ID 🐦‍⬛             ");
			System.out.println("                5 - RECOMENDAR UM LIVRO ALEATÓRIO 🔮   ");
			System.out.println("                6 - APAGAR LIVRO CADASTRADO 🐉         ");
			System.out.println("                0 - SAIR 🧙‍♂️                            ");
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
				System.out.println("\nDigite um número inteiro entre 0 e 6!");
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
				System.out.println(Cores.TEXT_WHITE_BOLD + "CADASTRAR LIVRO\n");
				cadastrarLivro();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "LISTAR TODOS OS LIVROS\n");

				listarTodos();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "BUSCAR LIVRO POR GÊNERO\n");
				buscaGen();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "BUSCAR LIVRO POR ID\n");
				buscaId();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "RECOMENDAR UM LIVRO ALEATÓRIO\n");
				recomenda();
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "APAGAR LIVRO CADASTRADO\n");

				deletarLivro();

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

	private static void listarTodos() {
		controller.listarTodos();
	
	}
	
	private static void cadastrarLivro() {
	        System.out.print("Título: ");
	        String titulo = leia.nextLine();
	        
	        System.out.print("Ano de Lançamento: ");
	        int ano = leia.nextInt();
	        
	        System.out.print("Autoria: ");
	        String autoria = leia.nextLine();
	       
	        System.out.print("Preço: r$");
	        float preco = leia.nextFloat();
	        leia.nextLine();
	        
	        System.out.print("Quantidade em estoque: ");
	        int qnt = leia.nextInt();
	        leia.nextLine();
	       
	        System.out.print("Para gênero, digite: \n"
	        		+ "1-Terror\n"
	        		+ "2-Infantil\n");
	         int genero = leia.nextInt();
	        leia.nextLine();

	        Livros livro;
	        
	        
	        if (genero == 1) {
	            System.out.print("Nível de medo: ");
	            int nivelMedo = leia.nextInt();
	            leia.nextLine();
	            livro = new Terror(titulo, ano, autoria, preco, qnt, genero, nivelMedo);
	        } else {
	            System.out.print("Tema abordado: ");
	            String tema = leia.nextLine();
	            livro = new Infantil(titulo, ano, autoria, preco, qnt, genero, tema);
	        }

	        controller.cadastrarLivro(livro);
	    }
	    
	    private static void buscaGen() {
	        System.out.print("Digite: \n"
	        		+ "1 para Terror\n"
	        		+ "2 para Infantil");
	        int genero = leia.nextInt();
	        leia.nextLine();
	        controller.buscaGen(genero);
	    }

	    private static void buscaId() {
	        System.out.print("Digite o ID do livro: ");
	        int id = leia.nextInt();
	        leia.nextLine();
	        controller.buscaId(id);
	    }

	    private static void recomenda() {
	        Livros livroAleatorio = controller.recomendaAleatorio();
	        if (livroAleatorio != null) {
	            livroAleatorio.visualizar();
	        } else {
	            System.out.println("Nenhum livro cadastrado para recomendar!");
	        }
	    }

	    private static void deletarLivro() {
	        System.out.print("Digite o ID do livro que deseja deletar: ");
	        int id = leia.nextInt();
	        leia.nextLine();
	        controller.deletar(id);
	    }

	    private static void keyPress() {
	        System.out.println("\nPressione ENTER para continuar!");
	        leia.nextLine();
	    }

	    private static void criarLivrosTeste() {
	     
	    controller.cadastrarLivro(new Terror("Infinity Pool", 2006, "Mark Down", 25.0f, 10, 1, 7));
        controller.cadastrarLivro(new Infantil("Harry Potter e a Pedra Filosofal", 2001, "JK Rowling", 40.0f, 5, 2, "Magia"));
        controller.cadastrarLivro(new Terror("Casas Estranhas", 2017, "Kutsu", 25.0f, 10, 1, 6));
        controller.cadastrarLivro(new Terror("Desenhos Estranhos", 2018, "Kutsu", 25.0f, 5, 1, 6));
        controller.cadastrarLivro(new Infantil("Demi e o Pote Vazio", 2003, "Inu Yasha", 25.0f, 10, 2, "Moral"));
        controller.cadastrarLivro(new Infantil("Levada, eu?", 2021, "Ruth Rocha", 65.0f, 5, 2, "Cotidiano Divertido"));
	        
	   
	}
}

