package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Paciente;
import model.Tratamento;

public class TratamentoDAO {
	private BufferedWriter bw;
	private BufferedReader br;
	private String file = System.getProperty("user.dir") + "\\files\\tratamentos.csv";
	private String[] campos;
	private ArrayList<Tratamento> tratamentos = null;
	private Tratamento tratamento = null;

	public boolean write(ArrayList<Tratamento> ts, boolean append) {
		try {
			bw = new BufferedWriter(new FileWriter(file, append));
			for (Tratamento t : ts) {
				bw.write(t.getCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Tratamento> read() {
		this.tratamentos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				this.tratamento = new Tratamento(Integer.parseInt(campos[0]), campos[1], campos[2]);
				this.tratamentos.add(this.tratamento);
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.tratamentos;
	}

	public ArrayList<Tratamento> read(Paciente p) {
		this.tratamentos = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				if (Integer.parseInt(campos[0]) == p.getId()) {
					this.tratamento = new Tratamento(Integer.parseInt(campos[0]), campos[1], campos[2]);
					this.tratamentos.add(this.tratamento);
				}
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.tratamentos;
	}
}
