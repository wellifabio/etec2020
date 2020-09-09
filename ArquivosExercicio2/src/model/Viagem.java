package model;

public class Viagem {

	//Atributos
	private String origem, destino;
	private int distancia, velocidade;

	//Métodos
	public float getTempo() {
		return (float) distancia / velocidade;
	}
	
	public String toTXT() {
		return "Origem: " + origem + " Destino: " + destino + " tempo " + String.format("%.2f", getTempo()) + "\r\n";
	}
	
	//GETs && SETs
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

}
