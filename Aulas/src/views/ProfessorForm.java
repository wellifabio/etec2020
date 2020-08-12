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

public class ProfessorForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String cabecalho;
	private int id = ProcessaProfessor.getAutoId();
	private JLabel labelCabecalho;
	private JTextField tfId, tfNome, tfNascimento, tfTelefone;
	private JTable tbProfessores;
	private DefaultTableModel tmProfessores;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;

	ProfessorForm() {
		// Parâmetros iniciais do formulário
		setTitle("Cadastro de Professores");
		setBounds(300, 160, 597, 410);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Começa a desenhar o formulário
		cabecalho = "Id:          Nome:                                                                ";
		cabecalho += "       Nascimento:        Telefone:";
		labelCabecalho = new JLabel(cabecalho);
		labelCabecalho.setBounds(10, 10, 580, 20);
		panel.add(labelCabecalho);
		tfId = new JTextField(String.format("%d", id));
		tfId.setBounds(10, 35, 40, 25);
		tfId.setEnabled(false);
		panel.add(tfId);
		tfNome = new JTextField();
		tfNome.setBounds(50, 35, 250, 25);
		panel.add(tfNome);
		tfNascimento = new JTextField();
		tfNascimento.setBounds(300, 35, 100, 25);
		panel.add(tfNascimento);
		tfTelefone = new JTextField();
		tfTelefone.setBounds(400, 35, 100, 25);
		panel.add(tfTelefone);

		btAdd = new JButton("Add");
		btAdd.setBounds(500, 35, 68, 25);
		panel.add(btAdd);
		btAdd.addActionListener(this);

		tmProfessores = new DefaultTableModel();
		tmProfessores.addColumn("Id");
		tmProfessores.addColumn("Nome");
		tmProfessores.addColumn("Nascimento");
		tmProfessores.addColumn("Telefone");
		for (Professor p : ProcessaProfessor.getProfessores()) {
			tmProfessores.addRow(new String[] { p.getId() + "", p.getNome(), p.getNascimento(), p.getTelefone() });
		}
		tbProfessores = new JTable(tmProfessores);
		scroll = new JScrollPane(tbProfessores);
		scroll.setBounds(10, 60, 559, 270);
		panel.add(scroll);

		btDel = new JButton("Del");
		btDel.setBounds(278, 330, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(this);

		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 330, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(this);

		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 330, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			if (tfNome.getText().length() > 0 && tfNascimento.getText().length() > 0) {
				tmProfessores.addRow(new String[] { tfId.getText(), tfNome.getText(), tfNascimento.getText(),
						tfTelefone.getText() });
				id++;
				tfId.setText(id + "");
				tfNome.setText("");
				tfNascimento.setText("");
				tfTelefone.setText("");
			}
		} else if (e.getSource() == btDel) {
			if (tbProfessores.getSelectedRow() >= 0) {
				tmProfessores.removeRow(tbProfessores.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btSalvar) {
			ArrayList<Professor> professores = new ArrayList<>();
			Professor professor;
			for (int i = 0; i < tmProfessores.getRowCount(); i++) {
				professor = new Professor();
				professor.setId(Integer.parseInt(tmProfessores.getValueAt(i, 0).toString()));
				professor.setNome(tmProfessores.getValueAt(i, 1).toString());
				professor.setNascimento(tmProfessores.getValueAt(i, 2).toString());
				professor.setTelefone(tmProfessores.getValueAt(i, 3).toString());
				professores.add(professor);
			}
			ProcessaProfessor.setProfessores(professores);
			dispose();
		} else {
			dispose();
		}

	}

}
