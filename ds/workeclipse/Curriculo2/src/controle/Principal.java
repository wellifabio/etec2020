package controle;

public class Principal {

	public static void main(String[] args) {
		
		//Classe instânciada normalmente
		Curriculo c = new Curriculo();
		c.setNome("Ana");
		c.setTelefone("(19)3456-4859");
		c.setEmail("ana@ana.com");
		c.setIdade(35);
		c.setCapacidade("Liderança", 75, 85, 45);
		c.setCapacidade("Comunicação", 50, 85, 50);
		c.setCapacidade("Condução", 80, 85, 75);
		c.setCapacidade("Resolução de conflitos", 45, 38, 27);
		
		System.out.println("CURRICULO");
		System.out.println("----------------------------------------------------");
		System.out.println("Nome: "+c.getNome());
		System.out.println("Telefone: "+c.getTelefone());
		System.out.println("E-mail: "+c.getEmail());
		System.out.println("Idade: "+c.getIdade());
		System.out.println();
		System.out.println("Capacidades");
		System.out.println("----------------------------------------------------");
		System.out.println("Título, Conhecimento, Habilidade, Atitude:");
		for(int i = 0; i < c.getCapacidade().length; i++) {
			System.out.println(c.getCapacidade()[i].getTitulo()+", "+
					c.getCapacidade()[i].getNivelConhecimento()+", "+
					c.getCapacidade()[i].getNivelHabilidade()+", "+
					c.getCapacidade()[i].getNivelAtitude()+";");
		}
		System.out.println("----------------------------------------------------");
	}
}
