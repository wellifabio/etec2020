package model;

import java.util.ArrayList;

public class Paciente extends Pessoa {

	// Atributos
	private String tipo;
	private ArrayList<Tratamento> prontuario = new ArrayList<>();
	// Esta lista acima existe porque um paciente pode fazer vários tratamentos
	// Assim recebe o nome de prontuário
	// Este é um relacionamento de Associação entre Paciente e Tratamento

	// Métodos Construtores
	public Paciente() {
	}

	public Paciente(int id, String nome, String nascimento, String telefone, String dataCadastro, String tipo) {
		super(id, nome, nascimento, telefone, dataCadastro);
		this.tipo = tipo;
	}

	// Métodos GETs && SETs
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Tratamento> getProntuario() {
		return prontuario;
	}

	public void setProntuario(ArrayList<Tratamento> prontuario) {
		this.prontuario = prontuario;
	}

	public String getCSV() {
		return super.getId() + ";" + super.getNome() + ";" + super.getNascimento() + ";" + super.getTelefone() + ";"
				+ super.getDataCadastro() + ";" + this.tipo + "\r\n";
	}
}
