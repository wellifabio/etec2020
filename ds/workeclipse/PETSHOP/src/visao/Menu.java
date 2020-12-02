package visao;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Animal;

public class Menu {
	static Scanner leia = new Scanner(System.in);
	static Animal animal; //Instancia a classe animal para ler os dados
	//Criar uma lista de animais para cadastro
	static ArrayList<Animal> animais = new ArrayList<Animal>();
	static int menu = 0; //Variável para a leitura dos dados do menú
	public static void main(String[] args) {
		while (menu != 3) {
			System.out.println("1.Cadastrar\n2.Listar\n3.Fim\n");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o nome, o peso e a altura do animal:");
				animal = new Animal(); //Cria um objeto do tipo Animal.
				animal.setNome(leia.next()); //Lê e configura o nome
				animal.setPeso(leia.nextFloat());//Lê e configura o peso
				animal.setAltura(leia.nextFloat());//Lê e configura o altura
				animais.add(animal);//Adiciona o animal a lista de animais
				break;
			case 2:
				//Utiliza o laço for it para listar os dados
				System.out.println("Nome, Peso, Altura:");
				for(Animal a: animais) {
					System.out.println(a.formatarDados());
				}
				break;
			case 3:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
