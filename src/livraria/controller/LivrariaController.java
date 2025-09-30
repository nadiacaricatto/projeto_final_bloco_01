package livraria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import livraria.model.Livros;
import livraria.repository.LivrosReposit;

public class LivrariaController implements LivrosReposit {

	private List<Livros> listaLivros = new ArrayList<Livros>();
	
	private int contadorId = 1;

	@Override
	public void listarTodos() {
		for (Livros livro : listaLivros) {
			livro.visualizar();
		}

	}

	@Override
	public void cadastrarLivro(Livros livro) {
		livro.setId(contadorId++);
		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");

	}

	@Override
	public void buscaGen(int genero) {
		List<Livros> livrosDoGen = buscarNaCollectionGenero(genero);

		if (!livrosDoGen.isEmpty()) {
			for (Livros livro : livrosDoGen) {
				livro.visualizar();
			}
		} else {
			System.out.printf("Ops...\n" + "Não foram encontrados títulos para o gênero informado!%n", genero);

		}

	}

	public void buscaId(int id) {

		var livro = buscarNaCollectionId(id);

		if (livro != null) {
			livro.visualizar();
		} else {
			System.out.printf("Ops...\n" + "O ID %d não retornou nenhum resultado!%n"
					+ "Verifique as informações e tente novamente!", id);

		}

	}

	@Override
	public void deletar(int id) {

		var livro = buscarNaCollectionId(id);

		if (livro != null) {
			if (listaLivros.remove(livro) == true) {
				System.out.printf("\n O Livro de ID %d foi descadastrado com sucesso.%n", id);
			}
		} else {
			System.out.printf("O ID %d fornecido não foi encontrado!%n" + "Verifique as informações e tente novamente.",
					id);

		}
	}

	public Livros buscarNaCollectionId(int id) {
		for (Livros livro : listaLivros) {
			if (livro.getId() == id) {
				return livro;
			}

		}

		return null;

	}



	@Override
	public void recomenda() {
		
		Livros livroAleatorio = recomendaAleatorio();
		
		if (livroAleatorio != null) {
			livroAleatorio.visualizar();
		
		} else {
			System.out.println(
					"Poxa, não temos nenhum livro cadastrado para te recomendar!\n" + "Será que estamos falindo?");
		}
	}

	public Livros recomendaAleatorio() {
		if (listaLivros.isEmpty()) {
			return null;
		}

		Random random = new Random();
		return listaLivros.get(random.nextInt(listaLivros.size()));
	}

	public List<Livros> buscarNaCollectionGenero(int genero) {
	    return listaLivros.stream()                
	                      .filter(livro -> livro.getGenero() == genero) 
	                      .collect(Collectors.toList());            
	
	}

}
