package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {

	private BufferedWriter bw;
	private BufferedReader br;
	private String file = System.getProperty("user.dir") + "\\files\\funcionarios.csv";
	private String[] campos;
	private ArrayList<Funcionario> funcionarios = null;
	private Funcionario funcionario = null;

	public boolean write(ArrayList<Funcionario> fs) {
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
			for (Funcionario f : fs) {
				bw.write(f.getCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Funcionario> read() {
		this.funcionarios = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				this.funcionario = new Funcionario(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3],
						campos[4], campos[5]);
				this.funcionarios.add(this.funcionario);
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.funcionarios;
	}

	public Funcionario read(int id) {
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				if (Integer.parseInt(campos[0]) == id) {
					this.funcionario = new Funcionario(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3],
							campos[4], campos[5]);
				}
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return funcionario;
	}
}
