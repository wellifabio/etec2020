package models;

public class Professor extends Pessoa {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCSV() {
		return getId()+";"+super.getNome()+";"+super.getNascimento()+";"+super.getTelefone()+"\r\n";
	}

}
