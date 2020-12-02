package recreio;
/*https://github.com/rsnog/fila_do_recreio*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N, M, P, v, aux;

		ArrayList<Integer> vetor3 = new ArrayList<Integer>();
		N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			M = scan.nextInt();
			int vetor[] = new int[M];
			int vetor2[] = new int[M];
			for (int j = 0; j < M; j++) {
				P = scan.nextInt();
				vetor[j] = P;
				vetor2[j] = P;
			}
			v = 0;
			for (int l = vetor.length - 1; l >= 1; l--) {
				for (int k = 0; k < l; k++) {
					if (vetor[k] < vetor[k + 1]) {
						aux = vetor[k];
						vetor[k] = vetor[k + 1];
						vetor[k + 1] = aux;
					}
				}

			}
			for (int j = 0; j < vetor2.length; j++) {
				if (vetor[j] != vetor2[j]) {
					v++;
				}
			}
			v = vetor.length - v;
			vetor3.add(v);
		}
		for (int i = 0; i < vetor3.size(); i++) {
			System.out.println(vetor3.get(i));
		}
		scan.close();
	}
}
