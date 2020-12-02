package modelo;

public class Animal {
	private String nome;
	private float peso;
	private float altura;
	//Construtores
	public Animal() {} //Construtor vazio	
	public Animal(String nome, float peso, float altura) {
		//Construtor completo
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}
	//GETs And SETs
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
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	//Método formatar dados
	public String formatarDados() {
		return String.format("%s, %.2f, %.2f", this.nome, this.peso, this.altura);
	}
}
