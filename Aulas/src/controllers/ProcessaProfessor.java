package controllers;

import java.util.ArrayList;

import models.Professor;

public class ProcessaProfessor {

	private static ArrayList<Professor> professores = new ArrayList<>();

	public static ArrayList<Professor> getProfessores() {
		return professores;
	}

	public static void setProfessores(ArrayList<Professor> professores) {
		ProcessaProfessor.professores = professores;
	}
	
	public static Professor getProfessor(int id) {
		for(Professor p: getProfessores()) {
			if(id == p.getId()) {
				return p;
			}
		}
		return null;
	}
	
	public static int getAutoId() {
		if(getProfessores().isEmpty()) {
			return 1;
		} else {
			int indice = getProfessores().size();
			return getProfessores().get(indice - 1).getId() + 1;
		}
	}
}
