import java.util.Scanner;
public class Alo{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite dois números inteiros:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = a + b;
		System.out.println("A soma de A + B = "+c);
	}
}