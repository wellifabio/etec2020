package acme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CalculosEstrutural {

	static private BufferedReader br;
	static private BufferedWriter bw;

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		List<Double> listMB =  new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("usuarios.txt"));
			String linha = br.readLine();
			double total = 0;
			while(linha != null){
				String [] vetor = linha.split("\t");
				double bytes = Double.parseDouble(vetor[1]);
				double mb = bytes / (1024 * 1024);
				nomes.add(vetor[0]);
				listMB.add(mb);
				total += mb;
				linha = br.readLine();
			}
			br.close();
			
			bw = new BufferedWriter(new FileWriter("relatorio.txt",false));
			String mbForm, ptForm;
			bw.write("ACME Inc.               Uso do espaço em disco pelos usuários\n");
			bw.write("-------------------------------------------------------------\n");
			bw.write("Nr.  Usuário        Espaço utilizado     % do uso\n\n");
			for(int i = 0; i < nomes.size(); i++){
				mbForm = String.format("%.2f", listMB.get(i));
				double ptgem = listMB.get(i) / total * 100;
				ptForm = String.format("%.2f", ptgem);
				linha = (i+1) + "\t" + nomes.get(i) +"\t"+ mbForm +"MB\t"+ptForm+"%\n";
				bw.write(linha);
			}
			bw.write("\nEspaço total ocupado: "+String.format("%.2f", total)+"\n");
			bw.write("Espaço médio ocupado: "+String.format("%.2f", total/nomes.size())+"\n");
			bw.close();
		} catch (Exception e) {
			System.out.println("Erro " + e);
		}
	}
}
