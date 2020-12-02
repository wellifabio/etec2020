package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

public class Menu {

	static Scanner read = new Scanner(System.in);
	static ArrayList<Produto> produtos = new ArrayList<Produto>();
	static Produto produto;
	static int menu = 0, indice = 0;

	public static void main(String[] args) {
		while (menu != 5) {
			System.out.println("1.Cadastrar\n2.Listar(ler)\n3.Modificar\n4.Deletar\n5.Sair\n\n");
			menu = read.nextInt();
			if (menu == 1) {// CRUD -> CREATE
				System.out.println("Digite as informações a seguir:");
				System.out.println("Nome, peso, preço");
				produto = new Produto(read.next(), read.nextFloat(), read.nextFloat());
				produtos.add(produto); // Acrescentar
			} else if (menu == 2) {// CRUD -> READ
				System.out.println("Produto\tPeso\tPreço");
				for (Produto l : produtos) { // Listar com for each
					System.out.print(l.getNome() + "\t");
					System.out.printf("%.2f\t", l.getPeso());
					System.out.printf("R$ %.2f\n", l.getPreco());
				}
			} else if (menu == 3) {// CRUD -> UPDATE
				if (produtos.isEmpty()) {
					System.out.println("Lista vazia.");
				} else {
					System.out.println("Digite o número do item que deseja alterar:");
					indice = read.nextInt();
					if (indice > produtos.size()) {
						System.out.println("Este ítem não está na lista");
					} else {
						System.out.print(produtos.get(indice - 1).getNome() + "\t");
						System.out.printf("%.2f\t", produtos.get(indice - 1).getPeso());
						System.out.printf("R$ %.2f\n", produtos.get(indice - 1).getPreco());
						System.out.println("Digite as informações a seguir:");
						System.out.println("Nome, peso, preço");
						produto = new Produto(read.next(), read.nextFloat(), read.nextFloat());
						produtos.remove(indice - 1);
						produtos.add(produto);
					}
				}
			} else if (menu == 4) {// CRUD -> DELETE
				if (produtos.isEmpty()) {
					System.out.println("Lista vazia.");
				} else {
					System.out.println("Digite o número do item que deseja excluir:");
					indice = read.nextInt();
					if (indice > produtos.size()) {
						System.out.println("Este ítem não está na lista");
					} else {
						produtos.remove(indice - 1);
						System.out.println("Produto removido com sucesso.");
					}
				}
			} else if (menu == 4) {
				System.out.println("Bya, bye.");
			} else {
				System.out.println("Opção inválida.");
			}
		}
	}
}
