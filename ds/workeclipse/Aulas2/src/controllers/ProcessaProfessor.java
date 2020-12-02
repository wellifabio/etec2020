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

	public static int getAutoId() {
		if (ProcessaProfessor.professores.size() > 0) {
			return ProcessaProfessor.professores.size() + 1;
		} else {
			return 1;
		}
	}
	
	public static Professor getProfessor(int id) {
		for(Professor p: ProcessaProfessor.professores) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
}
