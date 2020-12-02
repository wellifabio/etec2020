package models;

public class Aula {

	private String data;
	private Materia materia;
	private boolean presenca;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public boolean isPresenca() {
		return presenca;
	}
	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}
	
	public void avaliarAluno(int nota) {
		materia.setNota(nota);
	}
	
}
