package visao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import modelo.Consulta;
import modelo.Funcionario;
import modelo.Paciente;
import modelo.Tratamento;

public class MenuPrincipal {

	// Classes úteis para entrada de dados
	private static Scanner scan = new Scanner(System.in);
	private static Date data = new Date();
	private static SimpleDateFormat hoje = new SimpleDateFormat("dd/MM/yyyy");

	// Classes para manipular apenas uma instância
	private static Funcionario funcionario;
	private static Paciente paciente;
	private static Tratamento tratamento;
	private static Consulta consulta;

	// Classes com as listas de pacientes, funcionários e consultas
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private static ArrayList<Consulta> consultas = new ArrayList<Consulta>();

	// Atributos de controle
	private static int menuP, subMenu, id;
	private static boolean encontrado;

	public static void main(String[] args) {
		// Montando o MENU Principal
		menuP = 0;
		while (menuP != 5) {
			System.out.println("\n1. Cadastrar Pessoas");
			System.out.println("2. Marcar Consultas");
			System.out.println("3. Listar Agenda por Dentista");
			System.out.println("4. Registrar Consulta/Tratamento");
			System.out.println("5. Sair do Sistema\n");
			menuP = scan.nextInt();
			switch (menuP) {
			case 1:
				// Cadastro de pessoas, submenu para escolher Paciente ou Funcionário
				subMenu = 0;
				while (subMenu < 1 || subMenu > 2) {
					System.out.println("1.Cadastrar Paciente \n2.Cadastrar Funcionário");
					subMenu = scan.nextInt();
					if (subMenu == 1) {
						// Cadastro de novos Pacientes
						paciente = new Paciente();
						System.out.println("Digite um código para o paciente (ID número inteiro):");
						paciente.setId(scan.nextInt());
						System.out.println("Digite o nome do paciente:");
						paciente.setNome(scan.next());
						System.out.println("Digite a data de nascimento do paciente (DD/MM/AAAA):");
						paciente.setNascimento(scan.next());
						System.out.println("Digite o telefone do paciente (99)99999-9999:");
						paciente.setTelefone(scan.next());
						System.out.println("Digite o tipo de paciente:");
						paciente.setTipo(scan.next());
						paciente.setDataCadastro(hoje.format(data));
						// Submenu para inserir tratamentos anteriores ao prontuário
						int prontuario = 0;
						while (prontuario != 2) {
							System.out.println(
									"Deseja inserir mais informações de tratamentos anteriores no Prontuário 1.Sim 2.Não");
							prontuario = scan.nextInt();
							if (prontuario == 1) {
								// Se sim adiciona um novo tratamento
								tratamento = new Tratamento();
								System.out.println("Digite o nome do tratamento:");
								tratamento.setNome(scan.next());
								System.out.println("Digite a descrição do tratamento:");
								tratamento.setDescricao(scan.next());
								paciente.setTratamentos(tratamento);
							} else if (prontuario == 2) {
								// Senão adiciona o paciente e conclui o processo
								pacientes.add(paciente);
								System.out.println("Cadastro concluído com sucesso.");
							} else {
								System.out.println("Opção inválida, digite 1 ou 2.");
							}
						}
					} else if (subMenu == 2) {
						// Cadastro de Funcionários
						funcionario = new Funcionario();
						System.out.println("Digite um código para o funcionário (ID número inteiro):");
						funcionario.setId(scan.nextInt());
						System.out.println("Digite o nome do funcionário:");
						funcionario.setNome(scan.next());
						System.out.println("Digite a data de nascimento do funcionário (DD/MM/AAAA):");
						funcionario.setNascimento(scan.next());
						System.out.println("Digite o telefone do funcionário (99)99999-9999:");
						funcionario.setTelefone(scan.next());
						System.out.println("Digite o cargo do funcionário:");
						funcionario.setCargo(scan.next());
						funcionario.setDataCadastro(hoje.format(data));
						// Adiciona o funcionário a lista
						funcionarios.add(funcionario);
						System.out.println("Funcionário adicionado com sucesso!");
					} else {
						System.out.println("Opção inválida, digite 1 ou 2.");
					}
				}
				break;
			case 2:
				// Marcar Consultas
				consulta = new Consulta();
				System.out.println("Digite o ID do paciente:");
				id = scan.nextInt();
				// Verifica se o paciente está cadastrado
				encontrado = false;
				for (int i = 0; i < pacientes.size(); i++) {
					if (pacientes.get(i).getId() == id) {
						paciente = new Paciente();
						paciente = pacientes.get(i);
						consulta.setPaciente(paciente);
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Paciente não encontrado.");
					break;
				}

				System.out.println("Digite o ID do atendente/recepcionista:");
				id = scan.nextInt();
				// Verifica se o Funcionário está cadastrado
				encontrado = false;
				for (int i = 0; i < funcionarios.size(); i++) {
					if (funcionarios.get(i).getId() == id) {
						funcionario = new Funcionario();
						funcionario = funcionarios.get(i);
						consulta.setAtendente(funcionario);
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Funcionário não encontrado.");
					break;
				}

				System.out.println("Digite o ID do Dentista");
				id = scan.nextInt();
				// Verifica se o Dentista está cadastrado
				encontrado = false;
				for (int i = 0; i < funcionarios.size(); i++) {
					if (funcionarios.get(i).getId() == id) {
						funcionario = new Funcionario();
						funcionario = funcionarios.get(i);
						consulta.setDentista(funcionario);
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Dentista não encontrado.");
					break;
				}
				// Cadastra os outros dados da consulta
				System.out.println("Digite a data da consulta (DD/MM/AAAA):");
				consulta.setData(scan.next());
				System.out.println("Digite a hora da consulta (HH:MM):");
				consulta.setHora(scan.next());
				System.out.println("Digite o nome do tratamento:");
				consulta.setTratamento(scan.next());
				consulta.setStatus(false);// Coloca este status informando que a consulta ainda não foi realizada
				consultas.add(consulta);
				break;
			case 3:
				//Listar uma tabela com as agendas dos dentistas
				System.out.println("Dentista, Data, Hora, Paciente, Tratamento, Atendente:");
				for(int i = 0; i < consultas.size(); i++) {
					if(!consultas.get(i).isStatus()) {
						System.out.print(consultas.get(i).getDentista().getNome()+", ");
						System.out.print(consultas.get(i).getData()+", ");
						System.out.print(consultas.get(i).getHora()+", ");
						System.out.print(consultas.get(i).getPaciente().getNome()+", ");
						System.out.print(consultas.get(i).getTratamento()+", ");
						System.out.println(consultas.get(i).getAtendente().getNome());
					}
				}
				break;
			case 4:
				//Registrar Consulta/Tratamento
				//Pesquisar o dentista
				System.out.println("Digite o ID do Dentista");
				id = scan.nextInt();
				// Verifica se o Dentista está cadastrado
				encontrado = false;
				for (int i = 0; i < funcionarios.size(); i++) {
					if (funcionarios.get(i).getId() == id) {
						funcionario = new Funcionario();
						funcionario = funcionarios.get(i);
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Dentista não encontrado.");
					break;
				}
				//Pesquisar o Paciente
				System.out.println("Digite o ID do paciente:");
				id = scan.nextInt();
				// Verifica se o paciente está cadastrado
				encontrado = false;
				for (int i = 0; i < pacientes.size(); i++) {
					if (pacientes.get(i).getId() == id) {
						paciente = new Paciente();
						paciente = pacientes.get(i);
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Paciente não encontrado.");
					break;
				}
				System.out.println("Digite a data da consulta:");
				String data = scan.next();
				encontrado = false;
				consulta = new Consulta();
				int indice = 0;
				for(int i = 0; i < consultas.size(); i++) {
					if(!consultas.get(i).isStatus()
							&& consultas.get(i).getDentista().equals(funcionario)
							&& consultas.get(i).getPaciente().equals(paciente)
							&& consultas.get(i).getData().equals(data)) {
						System.out.println("O tratamento desta consulta é:"+consultas.get(i).getTratamento());
						System.out.println("Prontuário:");
						System.out.println("Nome, Descrição");
						for(int j = 0; j < consultas.get(i).getPaciente().getTratamentos().size(); j++) {
							System.out.print(consultas.get(i).getPaciente().getTratamentos().get(j).getNome()+", ");
							System.out.println(consultas.get(i).getPaciente().getTratamentos().get(j).getDescricao());
						}
						consulta = consultas.get(i);
						indice = i;
						encontrado = true;
					}
				}
				if (!encontrado) {
					System.out.println("Nenhuma consulta encontrada nesta data para este paciente.");
					break;
				}
				subMenu = 0;
				while(subMenu < 1 || subMenu > 2) {
					System.out.println("Alterar o status da consulta para realizada? 1.Sim 2.Não");
					subMenu = scan.nextInt();
					if(subMenu == 1) {
						consulta.setStatus(true);
						paciente = new Paciente();
						paciente = consulta.getPaciente();
						// Submenu para inserir novas informações ao prontuário
						int prontuario = 0;
						while (prontuario != 2) {
							System.out.println(
									"Deseja inserir mais informações deste tratamento ao Prontuário 1.Sim 2.Não");
							prontuario = scan.nextInt();
							if (prontuario == 1) {
								// Se Sim adiciona um novo tratamento
								tratamento = new Tratamento();
								System.out.println("Digite o nome do tratamento:");
								tratamento.setNome(scan.next());
								System.out.println("Digite a descrição do tratamento:");
								tratamento.setDescricao(scan.next());
								paciente.setTratamentos(tratamento);
							} else if (prontuario == 2) {
								consulta.setPaciente(paciente);
								consultas.add(indice, consulta);
								System.out.println("Cadastro do prontuário concluído com sucesso.");
							} else {
								System.out.println("Opção inválida, digite 1 ou 2.");
							}
						}						
					}else if(subMenu == 2) {
						System.out.println("Consulta inalterada");
					}else {
						System.out.println("Opção inválida, digite 1 ou 2");
					}
				}
				break;
			case 5:
				System.out.println("Obrigado por utilizar este Sistema. Bye bye!");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
