package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dao.TextoDAO;

public class FormTestes extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextArea areaDeTexto;
	private TextoDAO td = new TextoDAO();
	private JButton botao;
	
	FormTestes(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Manipulando com Arquivos");
		setBounds(200, 100, 800, 560);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);
		
		areaDeTexto = new JTextArea(td.open());
		areaDeTexto.setBounds(10,10,760,460);
		painel.add(areaDeTexto);
		botao = new JButton("Salvar");
		botao.setBounds(670,480,100,30);
		painel.add(botao);
		
		botao.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botao) {
			td.save(areaDeTexto.getText());
		}
	}
	
	public static void main(String[] args) {
		FormTestes ft = new FormTestes();
		ft.setVisible(true);
	}

}
