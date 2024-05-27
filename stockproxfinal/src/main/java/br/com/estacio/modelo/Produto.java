package br.com.estacio.modelo;

public class Produto {
	
	private int id;
	private String nome;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Produto(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
