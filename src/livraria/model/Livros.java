package livraria.model;

public abstract class Livros {

	private int id;
	private String titulo;
	private float preco;
	private int qnt;
	private int genero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}
	
	
	public Livros(int id, String titulo, float preco, int qnt, int genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.qnt = qnt;
		this.genero = genero;
	}
	
	public void visualizar() {
		
		String tipo;
		
			switch (this.genero) {
			case 1 -> tipo = "Terror";
			case 2 -> tipo = "Infantil";
			default -> tipo = "Desconhecido";
			}

		System.out.println("\n********************************************");
		System.out.println("Informações");
		System.out.println("********************************************");
		System.out.printf("Id: %d%n", this.id);
		System.out.printf("Título: %s%n", this.titulo);
		System.out.printf("Preço: %.2f%n", this.preco);
		System.out.printf("Quantidade em Estoque: %d%n", this.qnt);
		System.out.printf("Gênero: %s%n", tipo);
				
				
				}
	}
	
	
	
	
	
	
	
	
	
