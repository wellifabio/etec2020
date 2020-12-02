package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import model.Paciente;

public class PacienteForm extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel labelCabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfId, tfNome, tfNasc, tfTel, tfDataCad;
	private JComboBox<String> cbTipo;
	private DefaultTableModel dtmPacientes;
	private JTable tbPacientes;
	private JScrollPane scroll;
	private String[] linha = new String[7];

	private Paciente paciente;
	private int id = 1;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	PacienteForm() {
		// Propriedades do Formulário
		setTitle("Cadastro de Pacientes");
		setBounds(100, 180, 597, 310);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Pega o último Id de Paciente e acrescenta 1
		// (Enquanto não temos Controller ou DAO)
		if (ProcessaClinica.getPacientes().size() > 0) {
			id = ProcessaClinica.getPacientes().get(ProcessaClinica.getPacientes().size() - 1).getId() + 1;
		}

		// Cabeçalho do Formulário
		labelCabecalho = new JLabel(
				"Id:          Nome:                                       Nascimento:Telefone:               Data cad.:     Tipo:");
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
		cbTipo = new JComboBox<String>();
		cbTipo.addItem("Plano");
		cbTipo.addItem("Particular");
		cbTipo.setBounds(435, 35, 74, 25);
		panel.add(cbTipo);

		// Tabela de Pacientes Habilitada para Alteração do Conteúdo
		dtmPacientes = new DefaultTableModel();
		dtmPacientes.addColumn("Id");
		dtmPacientes.addColumn("Nome");
		dtmPacientes.addColumn("Nascimento");
		dtmPacientes.addColumn("Telefone");
		dtmPacientes.addColumn("Dat. Cad.");
		dtmPacientes.addColumn("Tipo");
		dtmPacientes.addColumn("Prontuário");
		for (Paciente p : ProcessaClinica.getPacientes()) {
			linha[0] = "" + p.getId();
			linha[1] = p.getNome();
			linha[2] = p.getNascimento();
			linha[3] = p.getTelefone();
			linha[4] = p.getDataCadastro();
			linha[5] = p.getTipo();
			linha[6] = "Clique para editar";
			dtmPacientes.addRow(linha);
		}
		tbPacientes = new JTable(dtmPacientes);
		scroll = new JScrollPane(tbPacientes);
		scroll.setBounds(10, 60, 559, 170);
		panel.add(scroll);

		// Evento que pega linha e coluna da tabela que foi selecionada com o Mouse.
		tbPacientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int lin = tbPacientes.getSelectedRow();
				int col = tbPacientes.getSelectedColumn();
				int idSelecionado = Integer.parseInt(tbPacientes.getValueAt(lin, 0).toString());
				for (Paciente p : ProcessaClinica.getPacientes()) {
					if (p.getId() == idSelecionado && col == 6) {
						TratamentoForm formTratamento = new TratamentoForm(p.getProntuario(), lin);
						formTratamento.setModal(true);
						formTratamento.setVisible(true);
					}
				}
			}
		});

		// Botão Adicionar Paciente a Tabela
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
				linha[5] = cbTipo.getSelectedItem().toString();
				linha[6] = "Prontuário";
				dtmPacientes.addRow(linha);
			}
		});

		// Botão Deletar
		btDel = new JButton("Del");
		btDel.setBounds(278, 230, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tbPacientes.getSelectedRow() >= 0) {
					dtmPacientes.removeRow(tbPacientes.getSelectedRow());
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
				ArrayList<Paciente> prontuariosBack = ProcessaClinica.getPacientes();
				ArrayList<Paciente> pacientes = new ArrayList<>();
				for (int i = 0; i < dtmPacientes.getRowCount(); i++) {
					paciente = new Paciente();
					paciente.setId(Integer.parseInt(dtmPacientes.getValueAt(i, 0).toString()));
					paciente.setNome(dtmPacientes.getValueAt(i, 1).toString());
					paciente.setNascimento(dtmPacientes.getValueAt(i, 2).toString());
					paciente.setTelefone(dtmPacientes.getValueAt(i, 3).toString());
					paciente.setDataCadastro(dtmPacientes.getValueAt(i, 4).toString());
					paciente.setTipo(dtmPacientes.getValueAt(i, 5).toString());
					if (i < prontuariosBack.size()) {
						paciente.setProntuario(prontuariosBack.get(i).getProntuario());
					}
					pacientes.add(paciente);
				}
				ProcessaClinica.setPacientes(pacientes);
				dispose();
			}
		});
	}
}