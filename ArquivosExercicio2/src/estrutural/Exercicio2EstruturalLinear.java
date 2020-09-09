package estrutural;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
A partir das entradas do arquivo "entrada2.txt", faça um programa que calcule o tempo de viagem entre as cidades de origem e destino e salve os resultados em um aquivo chamado "saida.txt"
Exemplo:
Origem: Americana Destino: Jaguariúna tempo ???
Origem: Jaguariúna Destino: Pirassununga tempo ???
Origem: Pirassununga Destino: São Paulo tempo ???
Origem: PosoAlegre Destino: Jaguariúna tempo ???
 */

public class Exercicio2EstruturalLinear {

	public static void main(String[] args) throws IOException { //Trata os erros
		String filein = ".\\arquivos\\entrada2.txt";//Aponta para o endereço do arquivo de entrada
		String fileout = ".\\arquivos\\saida2.txt";//Aponta para o endereço do arquivo de saida
		String[] cols; //Vetor para  as colunas
		BufferedReader br = new BufferedReader(new FileReader(filein)); //Abre o arquivo para leitura
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileout)); //Abre o arquivo para escrita e sobrescreve
		String line = br.readLine(); //Lê a primeira linha
		while (line != null) { //Repete lendo todas as outras linhas
			cols =line.split(";"); //Separa a linha em colunas utilizando um caracter separador
			int distancia = Integer.parseInt(cols[1]); //Converte de String para Inteiro
			int velocidade = Integer.parseInt(cols[3]); //Converte de String para Inteiro
			float tempo = (float) distancia / velocidade; //Calculo do tempo		
			bw.write("Origem: "+cols[0]+" Destino: "+cols[2]+" tempo "+ String.format("%.2f",tempo)+"\r\n");
			line = br.readLine(); // Lê a próxima linha.
		}
		br.close(); // Fecha o arquivo de leitura
		bw.close(); // Fecha o arquivo de gravação
	}

}
