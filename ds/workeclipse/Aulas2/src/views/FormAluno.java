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

public class FormAluno extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel labelCabecalho;
	private String cabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfRa, tfNome, tfNascimento, tfTelefone;
	private DefaultTableModel tmAlunos;
	private JTable tbAlunos;
	private JScrollPane scroll;

	FormAluno() {
		// Propriedades do Formulário
		this.setTitle("Cadastro de Alunos");
		this.setBounds(300, 160, 597, 410);
		this.panel = new JPanel();
		this.setContentPane(panel);
		this.setLayout(null);

		// Cabeçalho do Formulário
		this.cabecalho = "RA:          Nome:                                                                ";
		this.cabecalho += "       Nascimento:        Telefone:";
		this.labelCabecalho = new JLabel(cabecalho);
		this.labelCabecalho.setBounds(10, 10, 580, 20);
		this.panel.add(labelCabecalho);
		this.tfRa = new JTextField();
		this.tfRa.setBounds(10, 35, 40, 25);
		this.panel.add(tfRa);
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

		// Tabela de Alunos (READ, UPDATE)
		this.tmAlunos = new DefaultTableModel();
		this.tmAlunos.addColumn("RA");
		this.tmAlunos.addColumn("Nome");
		this.tmAlunos.addColumn("Nascimento");
		this.tmAlunos.addColumn("Telefone");
		this.tmAlunos.addColumn("Matérias");
		if (!ProcessaAluno.getAlunos().isEmpty()) {
			for (Aluno a : ProcessaAluno.getAlunos()) {
				this.tmAlunos.addRow(new String[] { a.getRa(), a.getNome(), a.getNascimento(), a.getTelefone(),
						a.getMaterias().size() + "" });
			}
		}
		this.tbAlunos = new JTable(tmAlunos);
		this.scroll = new JScrollPane(tbAlunos);
		this.scroll.setBounds(10, 60, 559, 270);
		this.panel.add(scroll);

		this.tbAlunos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int lin = tbAlunos.getSelectedRow();
				int col = tbAlunos.getSelectedColumn();
				if (col == 4 && !tbAlunos.getValueAt(lin, 4).equals("Novo")) {
					FormMateria dialogMateria = new FormMateria(ProcessaAluno.getAlunos().get(lin), lin);
					dialogMateria.setModal(true);
					dialogMateria.setVisible(true);
				}
			}
		});

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
			this.tmAlunos.addRow(new String[] { this.tfRa.getText(), this.tfNome.getText(), this.tfNascimento.getText(),
					this.tfTelefone.getText(), "Novo" });
			this.tfRa.setText("");
			this.tfNome.setText("");
			this.tfNascimento.setText("");
			this.tfTelefone.setText("");
		} else if (e.getSource() == this.btDel) {
			if (this.tbAlunos.getSelectedRow() >= 0) {
				this.tmAlunos.removeRow(this.tbAlunos.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == this.btCancelar) {
			this.dispose();
		} else {
			ArrayList<Aluno> alunosBkp = ProcessaAluno.getAlunos();
			ArrayList<Aluno> alunos = new ArrayList<>();
			Aluno aluno;
			for (int i = 0; i < tmAlunos.getRowCount(); i++) {
				aluno = new Aluno();
				aluno.setRa(tmAlunos.getValueAt(i, 0).toString());
				aluno.setNome(tmAlunos.getValueAt(i, 1).toString());
				aluno.setNascimento(tmAlunos.getValueAt(i, 2).toString());
				aluno.setTelefone(tmAlunos.getValueAt(i, 3).toString());
				if (!alunosBkp.isEmpty()) {
					if (!alunosBkp.get(i).getMaterias().isEmpty()) {
						aluno.setMaterias(alunosBkp.get(i).getMaterias());
					}
				}
				alunos.add(aluno);
			}
			ProcessaAluno.setAlunos(alunos);
			this.dispose();
		}
	}
}
