package acme;

public class EspacoDisco {

	private String nome;
	private double espaco;
	
	/*Gets && Sets*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getEspaco() {
		return espaco;
	}

	public void setEspaco(double espaco) {
		this.espaco = espaco;
	}
	
	/*Cálculos MB, Porcentagem e Formatação*/
	public double getEspacoMB() {
		return espaco / (1024 * 1024);
	}

	public String getEspacoFormatado() {
		return String.format("%.2f MB", getEspacoMB());
	}
	
	public String getPorcentagem(double total) {
		return String.format("%.2f", (getEspacoMB() / total * 100));
	}
}
