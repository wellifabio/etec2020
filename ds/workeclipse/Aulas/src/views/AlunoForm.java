package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import controllers.ProcessaAluno;
import models.Aluno;

public class AlunoForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String cabecalho;
	private JLabel labelCabecalho;
	private JTextField tfRa, tfNome, tfNascimento, tfTelefone;
	private JTable tbAlunos;
	private DefaultTableModel tmAlunos;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;

	AlunoForm() {
		setTitle("Cadastro de Alunos");
		setBounds(300, 160, 597, 410);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		cabecalho = "Id:          Nome:                                                                ";
		cabecalho += "       Nascimento:        Telefone:";
		labelCabecalho = new JLabel(cabecalho);
		labelCabecalho.setBounds(10, 10, 580, 20);
		panel.add(labelCabecalho);
		tfRa = new JTextField();
		tfRa.setBounds(10, 35, 40, 25);
		panel.add(tfRa);
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

		tmAlunos = new DefaultTableModel();
		tmAlunos.addColumn("Id");
		tmAlunos.addColumn("Nome");
		tmAlunos.addColumn("Nascimento");
		tmAlunos.addColumn("Telefone");
		tmAlunos.addColumn("Matérias");
		if (!ProcessaAluno.getAlunos().isEmpty()) {
			for (Aluno a : ProcessaAluno.getAlunos()) {
				tmAlunos.addRow(new String[] { a.getRa(), a.getNome(), a.getNascimento(), a.getTelefone(),
						String.format("%d", a.getMaterias().size()) });
			}
		}
		tbAlunos = new JTable(tmAlunos);
		scroll = new JScrollPane(tbAlunos);
		scroll.setBounds(10, 60, 559, 270);
		panel.add(scroll);

		this.tbAlunos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int lin = tbAlunos.getSelectedRow();
				int col = tbAlunos.getSelectedColumn();
				if (col == 4 && !tbAlunos.getValueAt(lin, 4).equals("Novo")) {
					MateriaForm dialogMateria = new MateriaForm(ProcessaAluno.getAlunos().get(lin), lin);
					dialogMateria.setModal(true);
					dialogMateria.setVisible(true);
				}
			}
		});

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
			if (tfRa.getText().length() > 0 && tfNome.getText().length() > 0 && tfNascimento.getText().length() > 0) {
				tmAlunos.addRow(new String[] { tfRa.getText(), tfNome.getText(), tfNascimento.getText(),
						tfTelefone.getText(), "Novo" });
				tfRa.setText("");
				tfNome.setText("");
				tfNascimento.setText("");
				tfTelefone.setText("");
			}
		} else if (e.getSource() == btDel) {
			if (tbAlunos.getSelectedRow() >= 0) {
				tmAlunos.removeRow(tbAlunos.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btSalvar) {
			ArrayList<Aluno> alunos = new ArrayList<>();
			Aluno aluno;
			for (int i = 0; i < tmAlunos.getRowCount(); i++) {
				aluno = new Aluno();
				aluno.setRa(tmAlunos.getValueAt(i, 0).toString());
				aluno.setNome(tmAlunos.getValueAt(i, 1).toString());
				aluno.setNascimento(tmAlunos.getValueAt(i, 2).toString());
				aluno.setTelefone(tmAlunos.getValueAt(i, 3).toString());
				if (ProcessaAluno.getMateriasAluno(aluno.getRa()) != null) {
					aluno.setMaterias(ProcessaAluno.getMateriasAluno(aluno.getRa()));
				}
				if (!alunos.contains(aluno)) {
					alunos.add(aluno);
				} else {
					JOptionPane.showMessageDialog(null, "O aluno " + aluno.getRa() + " está com RA duplicado.");
				}
			}
			ProcessaAluno.setAlunos(alunos);
			dispose();
		} else {
			dispose();
		}
	}

}
