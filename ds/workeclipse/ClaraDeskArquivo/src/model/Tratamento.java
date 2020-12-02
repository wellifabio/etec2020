package model;

public class Tratamento {

	// Atributos
	private int idPaciente;
	private String nome, descricao;

	// Construtores
	public Tratamento() {
	}

	public Tratamento(int idPaciente, String nome, String descricao) {
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.descricao = descricao;
	}

	// Métodos GETs && SETs
	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCSV() {
		return this.idPaciente + ";" + this.nome + ";" + this.descricao + "\r\n";
	}
}
