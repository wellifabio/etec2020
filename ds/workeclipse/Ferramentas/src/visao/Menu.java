package visao;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Ferramenta;

public class Menu {

	private static Scanner read = new Scanner(System.in);
	private static ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
	private static Ferramenta ferramenta;
	private static int menu;

	public static void main(String[] args) {
		menu = 0;
		while (menu != 4) {
			System.out.println("1. Retirar ferramenta\r\n" + "2. Listar ferramentas retiradas\r\n"
					+ "3. Devolver ferramenta\r\n" + "4. Sair\r\n" + "");
			menu = read.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite os nomes do mecânico e da ferramenta:");
				ferramenta = new Ferramenta();
				ferramenta.setFuncionario(read.next());
				ferramenta.setFerramenta(read.next());
				ferramentas.add(ferramenta);
				break;
			case 2:
				System.out.println("Mecânico, Ferramenta:");
				for (Ferramenta f : ferramentas) {
					System.out.println(f.getFuncionario() + ", " + f.getFerramenta());
				}
				break;
			case 3:
				System.out.println("Digite o nome do mecânico e da ferramenta:");
				ferramenta = new Ferramenta();
				ferramenta.setFuncionario(read.next());
				ferramenta.setFerramenta(read.next());
				boolean excluido = false;
				for (Ferramenta f : ferramentas) {
					if (f.getFuncionario().equals(ferramenta.getFuncionario())
							&& f.getFerramenta().equals(ferramenta.getFerramenta())) {
						ferramentas.remove(f);
						excluido = true;
					}
				}
				if(excluido) {
					System.out.println("Ferramenta devolvida");
				}else {
					System.out.println("Esta retirada não foi registrada");
				}
				break;
			case 4:
				System.out.println("Valews, falows, até...");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
