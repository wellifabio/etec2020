package estrutural;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
A partir das entradas do arquivo "entrada2.txt", faça um programa que calcule o tempo de viagem entre as cidades de origem e destino e salve os resultados em um aquivo chamado "saida.txt"
Exemplo:
Origem: Americana Destino: Jaguariúna tempo ???
Origem: Jaguariúna Destino: Pirassununga tempo ???
Origem: Pirassununga Destino: São Paulo tempo ???
Origem: PosoAlegre Destino: Jaguariúna tempo ???
 */

public class Exercicio2Objeto {

	// ATRIBUTOS
	String filein = ".\\arquivos\\entrada2.txt";// Aponta para o endereço do arquivo de entrada
	String fileout = ".\\arquivos\\saida2.txt";// Aponta para o endereço do arquivo de saida
	ArrayList<String> lines = new ArrayList<>(); // Uma nova lista para armazenas as linhas de saída
	String[] cols; // Vetor para as colunas

	public float calcularTempo(String distancia, String velocidade) {
		return (float) Integer.parseInt(distancia) / Integer.parseInt(velocidade);
	}

	public static void main(String[] args) { // Trata os erros

		Exercicio2Objeto obj = new Exercicio2Objeto();

		// LEITURA
		try {
			BufferedReader br = new BufferedReader(new FileReader(obj.filein));
			// Abre o arquivo para leitura
			String line = br.readLine(); // Lê a primeira linha
			while (line != null) { // Repete lendo todas as outras linhas
				obj.cols = line.split(";"); // Separa a linha em colunas utilizando um caracter separador
				obj.lines.add("Origem: " + obj.cols[0] + " Destino: " + obj.cols[2] + " tempo "
						+ String.format("%.2f", obj.calcularTempo(obj.cols[1], obj.cols[3])) + "\r\n");
				line = br.readLine(); // Lê a próxima linha.
			}
			br.close(); // Fecha o arquivo de leitura
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado " + e);
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo " + e);
		}

		// SAIDA
		try {
			// Abre o arquivo para escrita e sobrescreve
			BufferedWriter bw = new BufferedWriter(new FileWriter(obj.fileout));
			for (String l : obj.lines) { // Laço que percorre uma lista
				bw.write(l); // Grava linha por linha
			}
			bw.close(); // Fecha o arquivo de gravação
			System.out.println("Saída gerada com sucesso");
		} catch (IOException e) {
			System.out.println("Erro ao gravar arquivo " + e);
		}

	}

}
