package controller;

import java.util.ArrayList;

import dao.ConsultaDAO;
import dao.FuncionarioDAO;
import dao.PacienteDAO;
import model.Consulta;
import model.Funcionario;
import model.Paciente;

public class ProcessaClinica {

	private static ArrayList<Paciente> pacientes;
	private static ArrayList<Funcionario> funcionarios;
	private static ArrayList<Consulta> consultas;
	private static String[] tratamentos;
	private static int id = 0;
	private static PacienteDAO pd = new PacienteDAO();
	private static FuncionarioDAO fd = new FuncionarioDAO();
	private static ConsultaDAO cd = new ConsultaDAO();

	public static void start() {
		if(!pd.read().isEmpty()) {
			pacientes = pd.read();
		} else {
			pacientes = new ArrayList<>();
		}
		if(!fd.read().isEmpty()) {
			funcionarios = fd.read();
		} else {
			funcionarios = new ArrayList<>();
		}
		if(!cd.read().isEmpty()) {
			consultas = cd.read();
		} else {
			consultas = new ArrayList<>();
		}
		tratamentos = "Limpeza,Restauração,Canal,Prótese,Extração".split(",");
	}

	public static ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public static void setPacientes(ArrayList<Paciente> pacientes) {
		ProcessaClinica.pacientes = pacientes;
		if (!pd.write(pacientes))
			System.out.println("Erro ao atualizar arquivos de pacientes e tratamentos");
	}

	public static ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		ProcessaClinica.funcionarios = funcionarios;
		if (!fd.write(funcionarios))
			System.out.println("Erro ao atualizar arquivo de funcionarios");
	}

	public static ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public static void setConsultas(ArrayList<Consulta> consultas) {
		ProcessaClinica.consultas = consultas;
		if (!cd.write(consultas))
			System.out.println("Erro ao atualizar arquivo de  consultas");

	}

	public static String[] getTratamentos() {
		return tratamentos;
	}

	public static void setTratamentos(String[] tratamentos) {
		ProcessaClinica.tratamentos = tratamentos;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		ProcessaClinica.id = id;
	}
}
