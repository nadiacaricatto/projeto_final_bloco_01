package livraria.model;

public class Infantil extends Livros {

	private String tema;

	public Infantil( String titulo, float preco, int qnt, int genero, String tema) {
		super(titulo, preco, qnt, genero);
		this.tema = tema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public void visualizar () {
		super.visualizar();
		System.out.printf("Tema Abordado: %s%n", this.tema);
	}
	
	
	
}
