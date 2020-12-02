package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Texto;

public class TextoDAO {
	//DAO (Data Access Object) Objeto de acesso a dados;
	private Texto texto = new Texto();
	private String arquivo = ".\\arquivos\\texto.txt";
	private BufferedReader br;
	private BufferedWriter bw;
	
	public String open() {
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = br.readLine();
			texto.setDados("");
			while(linha != null) {
				texto.setDados(texto.getDados()+linha+"\n");
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}		
		return texto.getDados();
	}
	
	public boolean save(String dados) {
		texto.setDados(dados);
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			bw.write(texto.getDados());
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}
}
