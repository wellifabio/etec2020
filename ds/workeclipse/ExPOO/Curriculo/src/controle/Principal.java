package controle;

public class Principal {

	public static void main(String[] args) {
		
		//Classe instânciada normalmente
		Curriculo c = new Curriculo();
		c.setNome("Ana");
		System.out.println("Nome: "+c.getNome());
		c.setTelefone("(19)3456-4859");
		System.out.println("Telefone: "+c.getTelefone());
		c.setEmail("ana@ana.com");
		System.out.println("E-mail: "+c.getEmail());
		c.setIdade(35);
		System.out.println("Idade: "+c.getIdade());
		
		//Classe instanciada como vetor
		Capacidade[] cap = new Capacidade[4];
		cap[0] = new Capacidade();
		cap[0].setTitulo("Liderança");
		cap[0].setNivelHabilidade(75);
		cap[0].setNivelConhecimento(85);
		cap[0].setNivelAtitude(45);
		
		cap[1] = new Capacidade();
		cap[1].setTitulo("Comunicação");
		cap[1].setNivelHabilidade(50);
		cap[1].setNivelConhecimento(85);
		cap[1].setNivelAtitude(5);
		
		cap[2] = new Capacidade();
		cap[2].setTitulo("Dirigir");
		cap[2].setNivelHabilidade(100);
		cap[2].setNivelConhecimento(100);
		cap[2].setNivelAtitude(100);
	
		cap[3] = new Capacidade();
		cap[3].setTitulo("Resolução de Conflitos");
		cap[3].setNivelHabilidade(10);
		cap[3].setNivelConhecimento(100);
		cap[3].setNivelAtitude(20);
		
		System.out.println("Capacidades");
		System.out.println("Título, Habilidade, Conhecimento, Atitude:");
		for(int i = 0; i < 4; i++) {
			System.out.println(cap[i].getTitulo()+", "+cap[i].getNivelHabilidade()+", "+
					cap[i].getNivelConhecimento()+", "+cap[i].getNivelAtitude()+";");
		}
	}
}
