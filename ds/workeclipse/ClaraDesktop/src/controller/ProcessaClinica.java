package controller;

import java.util.ArrayList;

import model.Consulta;
import model.Funcionario;
import model.Paciente;

public class ProcessaClinica {
	
	private static ArrayList<Paciente> pacientes;
	private static ArrayList<Funcionario> funcionarios;
	private static ArrayList<Consulta> consultas;
	private static String[] tratamentos;
	private static int id = 0;
	
	public static void start() {
		pacientes = new ArrayList<>();
		funcionarios = new ArrayList<>();
		consultas = new ArrayList<>();
		tratamentos = "Limpeza,Restauração,Canal,Prótese,Extração".split(",");
	}
	
	public static ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	public static void setPacientes(ArrayList<Paciente> pacientes) {
		ProcessaClinica.pacientes = pacientes;
	}
	public static ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		ProcessaClinica.funcionarios = funcionarios;
	}
	public static ArrayList<Consulta> getConsultas() {
		return consultas;
	}
	public static void setConsultas(ArrayList<Consulta> consultas) {
		ProcessaClinica.consultas = consultas;
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
