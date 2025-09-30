package livraria.model;

public class Terror extends Livros {

	private int nivelMedo;

	public Terror(String titulo, int ano, String autoria, float preco, int qnt, int genero, int nivelMedo) {
		super(titulo, preco, qnt, genero);
		this.nivelMedo = nivelMedo;
	}

	public int getNivelMedo() {
		return nivelMedo;
	}

	public void setNivelMedo(int nivelMedo) {
		this.nivelMedo = nivelMedo;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf("\nNível de Medo: %d%n", this.nivelMedo);
	}
	
}

