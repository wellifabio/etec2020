package view;

import dao.ViagemDAO;

public class Exercicio2ObjetoMVC {

	static ViagemDAO vd = new ViagemDAO();

	public static void main(String[] args) {
		if (vd.saveFileOut(vd.openFileIn()))
			System.out.println("Arquivo de saída gravado com sucesso");

	}

}
