package br.com.estacio.modelo;

public class Estoque {
	
	private int id;
	private Produto produto;
	private String vencimento;
	private int quantidade;
	private int idLoja;
	
	public Estoque(Produto p, String vencimento, int quantidade, int idLoja) {
		// TODO Auto-generated constructor stub
		this.produto = p;
		this.vencimento = vencimento;
		this.quantidade = quantidade;
		this.idLoja = idLoja;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public String getVencimento() {
		return vencimento;
	}


	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}


	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

}
