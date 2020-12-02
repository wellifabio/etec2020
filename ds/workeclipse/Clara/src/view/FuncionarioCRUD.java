package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Funcionario;

public class FuncionarioCRUD {
	
	Scanner read = new Scanner(System.in);
	SimpleDateFormat dataSistema = new SimpleDateFormat("dd/MM/yyyy");
	Date data = new Date();
	
	public Funcionario create(int id) {
		Funcionario funcionario = new Funcionario();
		System.out.println("Digite (Nome, Data de nascimento, Telefone, Cargo): ");
		funcionario.setId(id);
		funcionario.setNome(read.next());
		funcionario.setNascimento(read.next());
		funcionario.setTelefone(read.next());
		funcionario.setCargo(read.next());
		funcionario.setDataCadastro(dataSistema.format(data));
		return funcionario;
	}
	
	public void read(ArrayList<Funcionario> funcionarios) {
		System.out.println("Id\tNome\tNascimento\tTelefone\tCargo\tDataCad");
		for(Funcionario f: funcionarios) {
			System.out.print(f.getId()+"\t");
			System.out.print(f.getNome()+"\t");
			System.out.print(f.getNascimento()+"\t");
			System.out.print(f.getTelefone()+"\t");
			System.out.print(f.getCargo()+"\t");
			System.out.print(f.getDataCadastro()+"\n");
		}
	}
}
