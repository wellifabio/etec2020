package controle;

public class Curriculo {
	// Atrubutos encapsulados
	private String nome;
	private String telefone;
	private String email;
	private int idade;
	private Capacidade[] capacidade = new Capacidade[4];
	private int contCapacidades = 0;

	// Metodos de acesso (GETs && SETs)
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return this.idade;
	}

	public Capacidade[] getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String titulo, int conh, int habi, int atit) {
		this.capacidade[contCapacidades] = new Capacidade();
		this.capacidade[contCapacidades].setTitulo(titulo);
		this.capacidade[contCapacidades].setNivelConhecimento(conh);
		this.capacidade[contCapacidades].setNivelHabilidade(habi);
		this.capacidade[contCapacidades].setNivelAtitude(atit);
		contCapacidades++;
	}
}
