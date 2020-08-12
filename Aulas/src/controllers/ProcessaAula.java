package controllers;

import java.util.ArrayList;

import models.Aula;

public class ProcessaAula {

	private static ArrayList<Aula> aulas = new ArrayList<>();

	public static ArrayList<Aula> getAulas() {
		return aulas;
	}

	public static void setAulas(ArrayList<Aula> aulas) {
		ProcessaAula.aulas = aulas;
	}

}
