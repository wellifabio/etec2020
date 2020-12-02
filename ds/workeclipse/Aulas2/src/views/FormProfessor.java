package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaProfessor;
import models.Professor;

public class FormProfessor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel labelCabecalho;
	private String cabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfId, tfNome, tfNascimento, tfTelefone;
	private DefaultTableModel tmProfessores;
	private JTable tbProfessores;
	private JScrollPane scroll;
	private int id = ProcessaProfessor.getAutoId();

	FormProfessor() {
		// Propriedades do Formulário
		this.setTitle("Cadastro de Professores");
		this.setBounds(300, 160, 597, 410);
		this.panel = new JPanel();
		this.setContentPane(panel);
		this.setLayout(null);

		// Cabeçalho do Formulário
		this.cabecalho = "Id:          Nome:                                                                ";
		this.cabecalho += "       Nascimento:        Telefone:";
		this.labelCabecalho = new JLabel(cabecalho);
		this.labelCabecalho.setBounds(10, 10, 580, 20);
		this.panel.add(labelCabecalho);
		this.tfId = new JTextField("" + id);
		this.tfId.setBounds(10, 35, 40, 25);
		this.tfId.setEnabled(false);
		this.panel.add(tfId);
		this.tfNome = new JTextField();
		this.tfNome.setBounds(50, 35, 250, 25);
		this.panel.add(tfNome);
		this.tfNascimento = new JTextField();
		this.tfNascimento.setBounds(300, 35, 100, 25);
		this.panel.add(tfNascimento);
		this.tfTelefone = new JTextField();
		this.tfTelefone.setBounds(400, 35, 100, 25);
		this.panel.add(tfTelefone);

		// Botão Adicionar (CREATE)
		this.btAdd = new JButton("Add");
		this.btAdd.setBounds(500, 35, 68, 25);
		this.panel.add(btAdd);
		this.btAdd.addActionListener(this);

		// Tabela de Professores (READ, UPDATE)
		this.tmProfessores = new DefaultTableModel();
		this.tmProfessores.addColumn("Id");
		this.tmProfessores.addColumn("Nome");
		this.tmProfessores.addColumn("Nascimento");
		this.tmProfessores.addColumn("Telefone");
		if (!ProcessaProfessor.getProfessores().isEmpty()) {
			for (Professor p: ProcessaProfessor.getProfessores()) {
				this.tmProfessores.addRow(new String[] {p.getId()+"",p.getNome(), p.getNascimento(), p.getTelefone()});
			}
		}
		this.tbProfessores = new JTable(tmProfessores);
		this.scroll = new JScrollPane(tbProfessores);
		this.scroll.setBounds(10, 60, 559, 270);
		this.panel.add(scroll);

		// Botão Deletar (DELETE)
		this.btDel = new JButton("Del");
		this.btDel.setBounds(278, 330, 59, 30);
		this.panel.add(btDel);
		this.btDel.addActionListener(this);

		// Botão Cancelar (Cancela as alterações)
		this.btCancelar = new JButton("Cancelar");
		this.btCancelar.setBounds(328, 330, 120, 30);
		this.panel.add(btCancelar);
		this.btCancelar.addActionListener(this);

		// Botão Salvar (Renova a lista)
		this.btSalvar = new JButton("Salvar");
		this.btSalvar.setBounds(448, 330, 120, 30);
		this.panel.add(btSalvar);
		this.btSalvar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAdd) {
			//Ao ser pressionado o botão Add
			//Acrescenta a linha no Modelo da tabela
			this.tmProfessores.addRow(new String[] {this.tfId.getText(),this.tfNome.getText(),tfNascimento.getText(),this.tfTelefone.getText()});
			//Limpra os objetos gráficos JTextFiesd
			this.id++; //Atribui um novo Id
			this.tfId.setText("" + id); //Configura o próximo ID
			this.tfNome.setText(""); //Limpa o campo Nome
			this.tfNascimento.setText(""); //Limpa o campo Nascimento
			this.tfTelefone.setText("");
		} else if (e.getSource() == this.btDel) {
			//Ao ser pressionado o botão Del
			if (this.tbProfessores.getSelectedRow() >= 0) {
				this.tmProfessores.removeRow(this.tbProfessores.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == this.btCancelar) {
			//Ao ser pressionado o botão Cancelar
			this.dispose();
		} else {
			//Ao ser pressionado o botão Salvar
			ArrayList<Professor> profs = new ArrayList<>();
			Professor prof;
			//Passando os dados da tabela para uma Lista (ArrayList)
			for(int i = 0; i < tmProfessores.getRowCount(); i++) {
				prof = new Professor();
				prof.setId(Integer.parseInt((String) tmProfessores.getValueAt(i, 0)));
				prof.setNome((String) tmProfessores.getValueAt(i, 1));
				prof.setNascimento((String) tmProfessores.getValueAt(i, 2));
				prof.setTelefone((String) tmProfessores.getValueAt(i, 3));
				profs.add(prof);
			}
			ProcessaProfessor.setProfessores(profs);
			this.dispose();
		}
	}
}
