package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import controller.ProcessaClinica;
import model.Funcionario;

public class FuncionarioForm extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel labelCabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfId, tfNome, tfNasc, tfTel, tfDataCad;
	private JComboBox<String> cbCargo;
	private DefaultTableModel dtmFuncionarios;
	private JTable tbFuncionarios;
	private JScrollPane scroll;
	private String[] linha = new String[6];

	private Funcionario funcionario;
	private int id = 1;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	FuncionarioForm() {
		// Propriedades do Formulário
		setTitle("Cadastro de Funcionários");
		setBounds(100, 180, 597, 310);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Pega o último Id de funcionário e acrescenta 1
		// (Enquanto não temos Controller ou DAO)
		if (ProcessaClinica.getFuncionarios().size() > 0) {
			id = ProcessaClinica.getFuncionarios().get(ProcessaClinica.getFuncionarios().size() - 1).getId() + 1;
		}

		// Cabeçalho do Formulário
		labelCabecalho = new JLabel(
				"Id:          Nome:                                       Nascimento:Telefone:               Data cad.:     Cargo:");
		labelCabecalho.setBounds(10, 10, 580, 20);
		panel.add(labelCabecalho);
		tfId = new JTextField("" + id);
		tfId.setBounds(10, 35, 40, 25);
		tfId.setEnabled(false);
		panel.add(tfId);
		tfNome = new JTextField();
		tfNome.setBounds(50, 35, 150, 25);
		panel.add(tfNome);
		tfNasc = new JTextField();
		tfNasc.setBounds(200, 35, 70, 25);
		panel.add(tfNasc);
		tfTel = new JTextField();
		tfTel.setBounds(270, 35, 100, 25);
		panel.add(tfTel);
		tfDataCad = new JTextField(sdf.format(new Date()));
		tfDataCad.setBounds(370, 35, 65, 25);
		tfDataCad.setEnabled(false);
		panel.add(tfDataCad);
		cbCargo = new JComboBox<String>();
		cbCargo.addItem("Dentista");
		cbCargo.addItem("Auxiliar");
		cbCargo.setBounds(435, 35, 74, 25);
		panel.add(cbCargo);

		// Tabela de Funcionários Habilitada para Alteração do Conteúdo
		dtmFuncionarios = new DefaultTableModel();
		dtmFuncionarios.addColumn("Id");
		dtmFuncionarios.addColumn("Nome");
		dtmFuncionarios.addColumn("Nascimento");
		dtmFuncionarios.addColumn("Telefone");
		dtmFuncionarios.addColumn("Dat. Cad.");
		dtmFuncionarios.addColumn("Cargo");
		for (Funcionario f : ProcessaClinica.getFuncionarios()) {
			linha[0] = "" + f.getId();
			linha[1] = f.getNome();
			linha[2] = f.getNascimento();
			linha[3] = f.getTelefone();
			linha[4] = f.getDataCadastro();
			linha[5] = f.getCargo();
			dtmFuncionarios.addRow(linha);
		}
		tbFuncionarios = new JTable(dtmFuncionarios);
		scroll = new JScrollPane(tbFuncionarios);
		scroll.setBounds(10, 60, 559, 170);
		panel.add(scroll);

		// Botão Adicionar Funcionario à Tabela
		btAdd = new JButton("Add");
		btAdd.setBounds(509, 35, 59, 25);
		panel.add(btAdd);
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				linha[0] = tfId.getText();
				id++;
				tfId.setText("" + id);
				linha[1] = tfNome.getText();
				tfNome.setText("");
				linha[2] = tfNasc.getText();
				tfNasc.setText("");
				linha[3] = tfTel.getText();
				tfTel.setText("");
				linha[4] = tfDataCad.getText();
				linha[5] = cbCargo.getSelectedItem().toString();
				dtmFuncionarios.addRow(linha);
			}
		});

		// Botão Deletar
		btDel = new JButton("Del");
		btDel.setBounds(278, 230, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tbFuncionarios.getSelectedRow() >= 0) {
					dtmFuncionarios.removeRow(tbFuncionarios.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});

		// Botão Cancelar
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 230, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		// Botão Salvar que Renova toda a lista com o conteúdo da tabela
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 230, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Funcionario> funcionarios = new ArrayList<>();
				for (int i = 0; i < dtmFuncionarios.getRowCount(); i++) {
					funcionario = new Funcionario();
					funcionario.setId(Integer.parseInt(dtmFuncionarios.getValueAt(i, 0).toString()));
					funcionario.setNome(dtmFuncionarios.getValueAt(i, 1).toString());
					funcionario.setNascimento(dtmFuncionarios.getValueAt(i, 2).toString());
					funcionario.setTelefone(dtmFuncionarios.getValueAt(i, 3).toString());
					funcionario.setDataCadastro(dtmFuncionarios.getValueAt(i, 4).toString());
					funcionario.setCargo(dtmFuncionarios.getValueAt(i, 5).toString());
					funcionarios.add(funcionario);
				}
				ProcessaClinica.setFuncionarios(funcionarios);
				dispose();
			}
		});
	}
}
