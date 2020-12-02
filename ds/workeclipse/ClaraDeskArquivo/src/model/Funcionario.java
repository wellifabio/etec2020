package model;

public class Funcionario extends Pessoa {
	
	//Atributos
	private String cargo;
	
	public Funcionario() {
	}

	public Funcionario(int id, String nome, String nascimento, String telefone, String dataCadastro, String cargo) {
		super(id, nome, nascimento, telefone, dataCadastro);
		this.cargo = cargo;
	}

	//Métodos GETs && SETs
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCSV() {
		return super.getId()+";"+super.getNome()+";"+super.getNascimento()+
				";"+super.getTelefone()+";"+super.getDataCadastro()+
				";"+this.cargo+"\r\n";
	}

}
