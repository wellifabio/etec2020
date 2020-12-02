package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menuCadastro, menuAulas;
	private JMenuItem miAluno, miProfessor, miAula, miSair;

	// Método Construtor
	MainForm() {
		// Configurações do FORM
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema de Aulas");
		this.setBounds(200, 100, 800, 600);
		this.panel = new JPanel();
		this.setContentPane(panel);
		this.setLayout(null);

		// Desenhar o Menu
		this.menuBar = new JMenuBar(); // Inicia a Barra de Menus
		this.setJMenuBar(menuBar); // Acrescenta a Barra de menus ao Formulário
		this.menuCadastro = new JMenu("Cadastro");
		this.menuAulas = new JMenu("Aula");
		this.menuBar.add(menuCadastro); // Adiciona o menú a Barra de menús
		this.menuBar.add(menuAulas); // Adiciona o menú a Barra
		this.miAluno = new JMenuItem("Alunos");
		this.miProfessor = new JMenuItem("Professores");
		this.miAula = new JMenuItem("Aulas");
		this.miSair = new JMenuItem("Sair");
		this.menuCadastro.add(miAluno);
		this.menuCadastro.add(miProfessor);
		this.menuAulas.add(miAula);
		this.menuAulas.add(miSair);

		// Ouvir os eventos do Menú (Clicar no menú escolhido)
		this.miAluno.addActionListener(this);
		this.miProfessor.addActionListener(this);
		this.miAula.addActionListener(this);
		this.miSair.addActionListener(this);
	}

	// Método que veio da interface ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miAluno) {
			FormAluno dialogAluno = new FormAluno();
			dialogAluno.setModal(true);
			dialogAluno.setVisible(true);
		} else if (e.getSource() == miProfessor) {
			FormProfessor dialogProfessor = new FormProfessor();
			dialogProfessor.setModal(true);
			dialogProfessor.setVisible(true);
		} else if (e.getSource() == miAula) {

		} else {
			this.dispose();
		}
	}

	// Método principal
	public static void main(String[] args) {
		MainForm telaPrincipal = new MainForm();
		telaPrincipal.setVisible(true);
	}

}
