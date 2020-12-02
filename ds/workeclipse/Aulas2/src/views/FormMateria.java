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

public class FormMateria extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel labelCabecalho;
	private String cabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfRa, tfNome;
	private JComboBox<String> cbProfessor;
	private DefaultTableModel tmMaterias;
	private JTable tbMaterias;
	private JScrollPane scroll;
	private int indice;

	FormMateria(Aluno aluno, int indice) {
		this.indice = indice;
		// Propriedades do Formulário
		this.setTitle("Cadastro de Materias");
		this.setBounds(350, 200, 497, 310);
		this.panel = new JPanel();
		this.setContentPane(panel);
		this.setLayout(null);

		// Cabeçalho do Formulário
		this.cabecalho = "RA:          Matéria:                                                             ";
		this.cabecalho += "Professor:";
		this.labelCabecalho = new JLabel(cabecalho);
		this.labelCabecalho.setBounds(10, 10, 580, 20);
		this.panel.add(labelCabecalho);
		this.tfRa = new JTextField(ProcessaAluno.getAlunos().get(indice).getRa());
		this.tfRa.setEnabled(false);
		this.tfRa.setBounds(10, 35, 40, 25);
		this.panel.add(tfRa);
		this.tfNome = new JTextField();
		this.tfNome.setBounds(50, 35, 250, 25);
		this.panel.add(tfNome);
		this.cbProfessor = new JComboBox<String>();
		for (Professor p : ProcessaProfessor.getProfessores()) {
			this.cbProfessor.addItem(p.getId() + "-" + p.getNome());
		}
		this.cbProfessor.setBounds(300, 35, 100, 25);
		this.panel.add(cbProfessor);

		// Botão Adicionar (CREATE)
		this.btAdd = new JButton("Add");
		this.btAdd.setBounds(400, 35, 68, 25);
		this.panel.add(btAdd);
		this.btAdd.addActionListener(this);

		// Tabela de Matérias (READ, UPDATE)
		this.tmMaterias = new DefaultTableModel();
		this.tmMaterias.addColumn("RA");
		this.tmMaterias.addColumn("Matéria");
		this.tmMaterias.addColumn("Professor");
		this.tmMaterias.addColumn("Nota");
		if (!aluno.getMaterias().isEmpty()) {
			for (Materia m: aluno.getMaterias()) {
				this.tmMaterias.addRow(new String[] {m.getAluno().getRa(),m.getNome(),  m.getProfessor().getId()+"-"+m.getProfessor().getNome(),m.getNota()+""});
			}
		}
		this.tbMaterias = new JTable(tmMaterias);
		this.scroll = new JScrollPane(tbMaterias);
		this.scroll.setBounds(10, 60, 459, 170);
		this.panel.add(scroll);

		// Botão Deletar (DELETE)
		this.btDel = new JButton("Del");
		this.btDel.setBounds(178, 230, 59, 30);
		this.panel.add(btDel);
		this.btDel.addActionListener(this);

		// Botão Cancelar (Cancela as alterações)
		this.btCancelar = new JButton("Cancelar");
		this.btCancelar.setBounds(228, 230, 120, 30);
		this.panel.add(btCancelar);
		this.btCancelar.addActionListener(this);

		// Botão Salvar (Renova a lista)
		this.btSalvar = new JButton("Salvar");
		this.btSalvar.setBounds(348, 230, 120, 30);
		this.panel.add(btSalvar);
		this.btSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAdd) {
			this.tmMaterias.addRow(new String[] {this.tfRa.getText(),this.tfNome.getText(),cbProfessor.getSelectedItem().toString(),""});
			this.tfNome.setText("");
		} else if (e.getSource() == this.btDel) {
			if (this.tbMaterias.getSelectedRow() >= 0) {
				this.tmMaterias.removeRow(this.tbMaterias.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == this.btCancelar) {
			this.dispose();
		} else {
			ArrayList<Materia> materias = new ArrayList<>();
			Materia materia;
			for(int i = 0; i < tmMaterias.getRowCount(); i++) {
				materia = new Materia();
				materia.setAluno(ProcessaAluno.getAlunos().get(this.indice));
				materia.setNome(tmMaterias.getValueAt(i, 1).toString());
				materia.setProfessor(ProcessaProfessor.getProfessor(Integer.parseInt(tmMaterias.getValueAt(i, 2).toString().split("-")[0])));
				materias.add(materia);
			}
			ProcessaAluno.getAlunos().get(this.indice).setMaterias(materias);
			this.dispose();
		}
	}
}
