package livraria.repository;

import livraria.model.Livros;

public interface LivrosReposit {

	public void cadastrarLivro();

	public void listarTodos(Livros livraria);

	public void buscaGen(int gen);

	public void buscaId(int id);

	public void recomenda();

	public void deletar(int id);

}
