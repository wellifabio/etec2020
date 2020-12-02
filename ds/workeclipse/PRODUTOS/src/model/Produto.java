package model;

public class Produto {
	
	private String nome;
	private float peso, preco;
	
	public Produto() {}
	public Produto(String nome, float peso, float preco) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
