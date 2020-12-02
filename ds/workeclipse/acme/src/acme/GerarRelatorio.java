package acme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GerarRelatorio {

	static private BufferedReader br;
	static private BufferedWriter bw;
	static private List<EspacoDisco> listEd = new ArrayList<>();
	static private EspacoDisco ed;
	static private double total = 0;
	static private String erro =  null;

	public static boolean getDados(String arquivo) {
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = br.readLine();
			while (linha != null) {
				ed = new EspacoDisco();
				String[] vetor = linha.split("\t");
				ed.setNome(vetor[0]);
				ed.setEspaco(Double.parseDouble(vetor[1]));
				total += ed.getEspacoMB();
				listEd.add(ed);
				linha = br.readLine();
			}
			br.close();
			return true;
		} catch (Exception e) {
			erro = "Erro: "+ e;
			return false;
		}
	}

	public static boolean setRelatorio(String arquivo) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			bw.write("ACME Inc.               Uso do espaço em disco pelos usuários\n");
			bw.write("-------------------------------------------------------------\n");
			bw.write("Nr.  Usuário        Espaço utilizado     % do uso\n\n");
			int n = 1;
			for (EspacoDisco e : listEd) {
				bw.write(n + "\t" + e.getNome() + "\t" + e.getEspacoFormatado() + "\t" + e.getPorcentagem(total) + "%\n");
				n++;
			}
			bw.write("\nEspaço total ocupado: " + String.format("%.2f", total) + "\n");
			bw.write("Espaço médio ocupado: " + String.format("%.2f", (total / n)));
			bw.close();
			return true;
		} catch (Exception e) {
			erro = "Erro: "+ e;
			return false;
		}
	}

	public static void main(String[] args) {
		if(getDados("usuarios.txt")) System.out.println("Arquivo de entrada lido.");
		else System.out.println(erro);
		if(setRelatorio("relatorio.txt")) System.out.println("Relatório criado com sucesso.");
		else System.out.println(erro);
	}

}
