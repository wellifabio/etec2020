package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Nota;

public class NotasDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private Nota nota;
	private String entrada = ".\\arquivos\\entrada1.txt";
	private String saida = ".\\arquivos\\saida.txt";
	
	public ArrayList<Nota> openEntrada(){
		ArrayList<Nota> notas = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(entrada));
			String linha = br.readLine();
			while(linha != null) {
				nota = new Nota();
				nota.setAluno(linha.split(",")[0]);
				nota.setNota1(Float.parseFloat(linha.split(",")[1]));
				nota.setNota2(Float.parseFloat(linha.split(",")[2]));
				nota.setNota3(Float.parseFloat(linha.split(",")[3]));
				notas.add(nota);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado "+e);
		} catch (IOException e) {
			System.out.println("Erro ao ler  o arquivo "+e);
		}
		return notas;
	}
	
	public boolean saveSaida(ArrayList<Nota> notas) {
		boolean resultado = false;
		try {
			bw = new BufferedWriter(new FileWriter(saida));
			for(Nota n: notas) {
				bw.write(n.toTXT());
			}
			bw.close();
			resultado = true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar arquivo "+e);
		}
		return resultado;
	}
}
