package controle;

public class Gatos extends Animais {

	int numRatos;

	public Gatos() {
		super();
	}

	public Gatos(int numRatos) {
		this.numRatos = numRatos;
	}
	
	public Gatos(String nome, String cor, String raca, char sexo) {
		super(nome, cor, raca, sexo);
	}

	public Gatos(String nome, String cor, String raca, char sexo, int numRatos) {
		super(nome, cor, raca, sexo);
		this.numRatos = numRatos;
	}

	public int getNumRatos() {
		return numRatos;
	}

	public void setNumRatos(int numRatos) {
		this.numRatos = numRatos;
	}

}
