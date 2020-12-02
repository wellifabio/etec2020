package views;

import javax.swing.JOptionPane;

import dao.NotasDAO;

public class Exercicio1 {

	private static NotasDAO nd = new NotasDAO();

	public static void main(String[] args) {
		if (nd.saveSaida(nd.openEntrada())) {
			JOptionPane.showMessageDialog(null, "Aquivo de saída criado com sucesso.");
		}
	}
}
