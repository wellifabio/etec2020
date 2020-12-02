package modelo;

import java.util.ArrayList;

public class Paciente extends Pessoa {
	
	String tipo;
	ArrayList<Tratamento> tratamentos = new ArrayList<Tratamento>();
	
	//GETs && SETs
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//Como estamos trabalhando com uma lista os métodos devem ser adequados
	//Para pegar apenas um ou todos os tratamentos da lista (Prontuário)
	public Tratamento getTratamento(int indice) {
		return tratamentos.get(indice);
	}
	public ArrayList<Tratamento> getTratamentos() {
		return tratamentos;
	}
	//Adiciona apenas um tratamento por vez a lista
	public void setTratamentos(Tratamento tratamento) {
		this.tratamentos.add(tratamento);
	}
	
}
