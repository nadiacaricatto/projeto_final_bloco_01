package livraria.model;

public class Intantil extends Livros {

	private String tema;

	public Intantil(int id, String titulo, float preco, int qnt, int genero, String tema) {
		super(id, titulo, preco, qnt, genero);
		this.tema = tema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void visualizar () {
		super.visualizar();
		System.out.printf("Tema Abordado: %d%n", this.tema);
	}
	
	
	
}
