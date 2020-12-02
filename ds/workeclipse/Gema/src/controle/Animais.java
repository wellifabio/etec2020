package controle;

public class Animais {

	protected String nome;
	private String cor;
	private String raca;
	private char sexo;

	public Animais() {}
		
	public Animais(String nome, String cor, String raca, char sexo) {
		this.nome = nome;
		this.cor = cor;
		this.raca = raca;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
