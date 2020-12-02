package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Funcionario;

public class MainMenu {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	static FuncionarioCRUD fc = new FuncionarioCRUD();
	static int menu, id;	
	
	public static void main(String[] args) {
		menu = 0;
		while (menu != 3) {
			System.out.println("1.Cadastrar\n2.Listar\n3.Sair\n\n");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				id = funcionarios.size()+1;
				funcionarios.add(fc.create(id));
				break;
			case 2:
				fc.read(funcionarios);
				break;
			case 3:
				System.out.println("Tchaw.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
