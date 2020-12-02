package controle;

public class Principal {

	public static void main(String[] args) {
		
		Restaurante rest = new Restaurante();
		rest.setNome("Restaurante da Fazenda");
		rest.setTipo("Self-service");
		rest.setTotalLugares(44);
		
		Pratos[] pratos = new Pratos[4];
		
		pratos[0] = new Pratos();
		pratos[0].setNome("Parmegiana");
		pratos[0].setDescricao("Filé de frango a Parmegiana");
		pratos[0].setPreco((float)19.90);
		
		pratos[1] = new Pratos();
		pratos[1].setNome("Bife Acebolado");
		pratos[1].setDescricao("Contra filé acebolado");
		pratos[1].setPreco((float)18.90);
		
		pratos[2] = new Pratos();
		pratos[2].setNome("Bife a cavalo");
		pratos[2].setDescricao("Filé com um ovo em cima");
		pratos[2].setPreco((float)17.90);

		pratos[3] = new Pratos();
		pratos[3].setNome("Milanesa");
		pratos[3].setDescricao("Filé a Milanesa");
		pratos[3].setPreco((float)17.90);
		
		System.out.println("Nome: "+rest.getNome());
		System.out.println("Tipo: "+rest.getTipo());
		System.out.println("Total Lugares: "+rest.getTotalLugares());
		System.out.println("Prato, Descrição, Preço:");
		for(int i = 0; i < 4; i++) {
			System.out.print(pratos[i].getNome());
			System.out.print(pratos[i].getDescricao());
			System.out.println(pratos[i].getPreco());
		}
	
	}

}
