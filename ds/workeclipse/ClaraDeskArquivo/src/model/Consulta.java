package model;

public class Consulta {

	// Atributos
	private String data;
	private String hora;
	private Paciente paciente; // Associação entre Consulta e Paciente do tipo Composição
	private Funcionario atendente; // Associação entre Consulta e Funcionário
	private Funcionario dentista; // Associação entre Consulta e Funcionário
	private String tratamento;
	private boolean status;

	// Construtores
	public Consulta() {
	}
	
	public Consulta(String data, String hora, Paciente paciente, Funcionario dentista, Funcionario atendente,
			String tratamento, boolean status) {
		this.data = data;
		this.hora = hora;
		this.paciente = paciente;
		this.atendente = atendente;
		this.dentista = dentista;
		this.tratamento = tratamento;
		this.status = status;
	}

	// Métodos GETs && SETss
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
	
	public String getCSV(){
		return this.data+";"+this.hora+";"+this.paciente.getId()+";"+this.dentista.getId()+
				";"+this.atendente.getId()+";"+this.tratamento+";"+this.status+"\r\n";
	}
}
