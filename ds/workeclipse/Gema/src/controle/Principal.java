package controle;

public class Principal {

	public static void main(String[] args) {
		Gatos[] g = new Gatos[3];
		
		g[0] = new Gatos(2);
		g[0].setNome("Mini");
		
		g[1] = new Gatos();
		g[1].setNumRatos(3);
		g[1].setNome("Pipo");
		
		g[2] = new Gatos("Mimi","Preto","Angorá",'f',8);
		
		System.out.println(g[0].getNome()+", "+g[0].getNumRatos());
		System.out.println(g[1].getNome()+", "+g[1].getNumRatos());
		System.out.println(g[2].getNome()+", "+g[2].getNumRatos());
	}
}
