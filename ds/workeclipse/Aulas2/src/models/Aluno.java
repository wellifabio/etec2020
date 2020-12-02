package models;

import java.util.ArrayList;

public class Aluno extends Pessoa{
	
	private String ra;
	private ArrayList<Materia> materias = new ArrayList<>();
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
}
