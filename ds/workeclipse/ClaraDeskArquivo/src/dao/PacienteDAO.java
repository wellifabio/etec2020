package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Paciente;

public class PacienteDAO {
	private BufferedWriter bw;
	private BufferedReader br;
	private String file = System.getProperty("user.dir") + "\\files\\pacientes.csv";
	private String[] campos;
	private ArrayList<Paciente> pacientes = null;
	private Paciente paciente = null;
	private TratamentoDAO td = new TratamentoDAO();

	public boolean write(ArrayList<Paciente> ps) {
		td.write(new ArrayList<>(),false);
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
			for (Paciente p : ps) {
				bw.write(p.getCSV());
				if(!p.getProntuario().isEmpty())
					td.write(p.getProntuario(), true);
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Paciente> read() {
		this.pacientes = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				this.paciente = new Paciente(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3],
						campos[4], campos[5]);
				paciente.setProntuario(td.read(paciente));
				this.pacientes.add(this.paciente);
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.pacientes;
	}

	public Paciente read(int id) {
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				if (Integer.parseInt(campos[0]) == id) {
					this.paciente = new Paciente(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3],
							campos[4], campos[5]);
				}
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paciente;
	}
}
