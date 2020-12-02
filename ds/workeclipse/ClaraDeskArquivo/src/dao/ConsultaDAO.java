package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Consulta;
import model.Funcionario;
import model.Paciente;

public class ConsultaDAO {
	private BufferedWriter bw;
	private BufferedReader br;
	private String file = System.getProperty("user.dir") + "\\files\\consultas.csv";
	private String[] campos;
	private ArrayList<Consulta> consultas = null;
	private Consulta consulta = null;
	private Paciente paciente = null;
	private Funcionario dentista = null;
	private Funcionario atendente = null;
	private PacienteDAO pd = new PacienteDAO();
	private FuncionarioDAO fd = new FuncionarioDAO();
	private boolean status;
	
	public boolean write(ArrayList<Consulta> cs) {
		try {
			bw = new BufferedWriter(new FileWriter(file, false));
			for (Consulta c : cs) {
				bw.write(c.getCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Consulta> read() {
		this.consultas = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			String linha = br.readLine();
			while (linha != null) {
				campos = linha.split(";");
				paciente = pd.read(Integer.parseInt(campos[2]));
				dentista = fd.read(Integer.parseInt(campos[3]));
				atendente = fd.read(Integer.parseInt(campos[4]));
				if(campos[6].contentEquals("true"))
					status = true;
				else
					status = false;
				this.consulta = new Consulta(campos[0], campos[1], paciente, dentista, atendente,
				campos[5], status);
				this.consultas.add(this.consulta);
				linha = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.consultas;
	}
}
