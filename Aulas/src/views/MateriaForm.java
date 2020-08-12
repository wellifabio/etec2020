package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaAluno;
import controllers.ProcessaProfessor;
import models.Aluno;
import models.Materia;
import models.Professor;

public class MateriaForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String cabecalho = "Aluno:                 Matéria:                                                   Professor:";
	private JLabel labelCabecalho;
	private JTextField tfAluno, tfMateria;
	private JComboBox<String> cbProfessor;
	private JTable tabela;
	private DefaultTableModel tModel;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;
	private int indiceAluno = 0;

	MateriaForm(Aluno aluno, int indice) {
		setTitle("Cadastro de Materias");
		setBounds(350, 200, 497, 310);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		indiceAluno = indice;

		// Cabeçalho do formulário de Matérias
		labelCabecalho = new JLabel(cabecalho);
		labelCabecalho.setBounds(10, 10, 580, 20);
		panel.add(labelCabecalho);
		tfAluno = new JTextField(aluno.getRa() + "-" + aluno.getNome());
		tfAluno.setEnabled(false);
		tfAluno.setBounds(10, 35, 120, 25);
		panel.add(tfAluno);
		tfMateria = new JTextField();
		tfMateria.setBounds(130, 35, 170, 25);
		panel.add(tfMateria);
		cbProfessor = new JComboBox<String>();
		cbProfessor.setBounds(300, 35, 100, 25);
		for (Professor p : ProcessaProfessor.getProfessores()) {
			cbProfessor.addItem(p.getId() + "-" + p.getNome());
		}
		panel.add(cbProfessor);

		// Botões e Tabela
		btAdd = new JButton("Add");
		btAdd.setBounds(400, 35, 68, 25);
		panel.add(btAdd);
		btAdd.addActionListener(this);

		// Tabela de Matérias (READ, UPDATE)
		tModel = new DefaultTableModel();
		tModel.addColumn("RA");
		tModel.addColumn("Matéria");
		tModel.addColumn("Professor");
		tModel.addColumn("Nota");
		for (Materia m : aluno.getMaterias()) {
			tModel.addRow(new String[] { m.getAluno().getRa(), m.getNome(),
					m.getProfessor().getId() + "-" + m.getProfessor().getNome(), m.getNota() + "" });
		}
		tabela = new JTable(tModel);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 60, 459, 170);
		panel.add(scroll);

		btDel = new JButton("Del");
		btDel.setBounds(178, 230, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(this);

		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(228, 230, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(this);

		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(348, 230, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			if (tfMateria.getText().length() > 0 && !ProcessaProfessor.getProfessores().isEmpty()) {
				tModel.addRow(new String[] { tfAluno.getText(), tfMateria.getText(),
						cbProfessor.getSelectedItem().toString(), "0" });
				tfMateria.setText("");
			}
		} else if (e.getSource() == btDel) {
			if (tabela.getSelectedRow() >= 0) {
				tModel.removeRow(tabela.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btSalvar) {
			ArrayList<Materia> materias = new ArrayList<>();
			Materia materia;
			for(int i = 0; i < tModel.getRowCount(); i++) {
				materia = new Materia();
				materia.setAluno(ProcessaAluno.getAlunos().get(indiceAluno));
				int idProf = Integer.parseInt(tModel.getValueAt(i,2).toString().split("-")[0]);
				materia.setProfessor(ProcessaProfessor.getProfessor(idProf));
				materia.setNome(tModel.getValueAt(i,1).toString());
				materia.setNota(Integer.parseInt(tModel.getValueAt(i,3).toString()));
				materias.add(materia);
			}
			ProcessaAluno.getAlunos().get(indiceAluno).setMaterias(materias);
			dispose();
		} else {
			dispose();
		}
	}

}
