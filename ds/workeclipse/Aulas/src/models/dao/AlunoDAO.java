package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import models.Professor;

public class AlunoDAO {
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\alunos.csv";
	private String [] campos;
	
	public ArrayList<Professor> open() {
		return null;
	}
	
	public boolean save(ArrayList<Professor> professor) {
		return false;
	}
}
