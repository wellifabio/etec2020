package controllers;

import java.util.ArrayList;

import models.Professor;
import models.dao.ProfessorDAO;

public class ProcessaProfessor {

	private static ArrayList<Professor> professores = new ArrayList<>();
	private static ProfessorDAO pd = new ProfessorDAO();

	public static ArrayList<Professor> getProfessores() {
		professores = pd.open();
		return professores;
	}

	public static void setProfessores(ArrayList<Professor> professores) {
		ProcessaProfessor.professores = professores;
		pd.save(professores);
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
