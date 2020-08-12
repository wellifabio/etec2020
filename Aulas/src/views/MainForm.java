package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {

	//JAVA GUI (Graphic User Interface)
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuCadastro, menuAulas;
	private JMenuItem miAluno, miProfessor, miAula, miSair;
	private ImageIcon img = new ImageIcon("./img/fundo.png");
	private Image image = img.getImage();
	private Image newImg = image.getScaledInstance(700, 470, java.awt.Image.SCALE_SMOOTH);
	private JLabel lbImg = new JLabel();

	// Método Construtor
	MainForm() {
		// Configurações do FORM
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema de Aulas");
		setBounds(200, 100, 800, 600); //Posição (x e y) e tamanho (Larg, Altura)
		setJMenuBar(menuBar); // Acrescenta a Barra de menus ao Formulário
		setContentPane(panel); //Acrescenta o Painel onde ficam todos os outros conteúdos do Form
		setLayout(null);
		
		// Desenhar o Menu
		menuCadastro = new JMenu("Cadastro");
		menuAulas = new JMenu("Aula");
		menuBar.add(menuCadastro); // Adiciona o menú a Barra de menús
		menuBar.add(menuAulas); // Adiciona o menú a Barra
		miAluno = new JMenuItem("Alunos");
		miProfessor = new JMenuItem("Professores");
		miAula = new JMenuItem("Aulas");
		miSair = new JMenuItem("Sair");
		menuCadastro.add(miAluno);
		menuCadastro.add(miProfessor);
		menuAulas.add(miAula);
		menuAulas.add(miSair);

		//Carregar a imagem de fundo
		img = new ImageIcon(newImg);
		lbImg.setIcon(img);
		lbImg.setBounds(40,20,700,470);
		panel.add(lbImg);
		
		// Ouvir os eventos do Menú (Clicar no menú escolhido)
		miAluno.addActionListener(this);
		miProfessor.addActionListener(this);
		miAula.addActionListener(this);
		miSair.addActionListener(this);
	}

	// Método que veio da interface ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miAluno) {
			AlunoForm dAluno = new AlunoForm();
			dAluno.setModal(true);
			dAluno.setVisible(true);
		} else if (e.getSource() == miProfessor) {
			ProfessorForm dProf = new ProfessorForm();
			dProf.setModal(true);
			dProf.setVisible(true);
		} else if (e.getSource() == miAula) {
			
		} else {
			JOptionPane.showMessageDialog(this, "Até logo.");
			dispose();
		}
	}

	// Método principal
	public static void main(String[] args) {
		MainForm tp = new MainForm();
		tp.setVisible(true);
	}

}
