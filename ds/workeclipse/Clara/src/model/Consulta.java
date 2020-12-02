package model;

public class Consulta {

	//Atributos
	private String data;
	private String hora;
	private Paciente paciente; //Associação entre Consulta e Paciente do tipo Composição
	private Funcionario atendente; //Associação entre Consulta e Funcionário
	private Funcionario dentista; //Associação entre Consulta e Funcionário
	private String tratamento;
	private boolean status;
	
	//Métodos GETs && SETss
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Funcionario getAtendente() {
		return atendente;
	}
	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}
	public Funcionario getDentista() {
		return dentista;
	}
	public void setDentista(Funcionario dentista) {
		this.dentista = dentista;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
