package controllers;

import java.util.ArrayList;

import models.Aluno;

public class ProcessaAluno {

	private static ArrayList<Aluno> alunos = new ArrayList<>();

	public static ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public static void setAlunos(ArrayList<Aluno> alunos) {
		ProcessaAluno.alunos = alunos;
	}
}
