package controllers;

import java.util.ArrayList;

import models.Aluno;
import models.Materia;

public class ProcessaAluno {

	private static ArrayList<Aluno> alunos = new ArrayList<>();

	public static ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public static void setAlunos(ArrayList<Aluno> alunos) {
		ProcessaAluno.alunos = alunos;
	}
	
	public static Aluno getAluno(String ra) {
		if(getAlunos().isEmpty()) {
			return null;
		} else {
			for(Aluno a: getAlunos()) {
				if(a.getRa().contentEquals(ra)) {
					return a;
				}
			}
			return null;
		}
	}
	public static ArrayList<Materia> getMateriasAluno(String ra) {
		if(getAlunos().isEmpty()) {
			return null;
		} else {
			for(Aluno a: getAlunos()) {
				if(a.getRa().contentEquals(ra)) {
					return a.getMaterias();
				}
			}
			return null;
		}
	}

}
