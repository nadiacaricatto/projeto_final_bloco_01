package livraria.repository;

import livraria.model.Livros;

public interface LivrosReposit {

	public void cadastrarLivro(Livros livro);

	public void listarTodos();

	public void buscaGen(int gen);

	public void buscaId(int id);

	public void recomenda();

	public void deletar(int id);

}
