package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Professor;

public class ProfessorDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\professores.csv";
	private String [] campos;
	private Professor professor;
	
	public ArrayList<Professor> open() {
		ArrayList<Professor> professores = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = br.readLine();
			while(linha != null) {
				campos = linha.split(";");
				professor = new Professor();
				professor.setId(Integer.parseInt(campos[0]));
				professor.setNome(campos[1]);
				professor.setNascimento(campos[2]);
				professor.setTelefone(campos[3]);
				professores.add(professor);
				linha = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: "+e);
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: "+e);
		}
		return professores;
	}
	
	public boolean save(ArrayList<Professor> professores) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			for(Professor p: professores) {
				bw.write(p.getCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar arquivo: "+e);
		}
		return false;
	}
			
}
