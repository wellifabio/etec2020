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
import model.Consulta;
import model.Funcionario;
import model.Paciente;

public class ConsultaForm extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel labelCabecalho;
	private JButton btSalvar, btCancelar, btAdd, btDel;
	private JTextField tfData, tfHora;
	private JComboBox<String> cbPaciente, cbAtendente, cbDentista, cbTratamento;
	private DefaultTableModel dtmConsultas;
	private JTable tbConsultas;
	private JScrollPane scroll;
	private String[] linha = new String[7];
	private SimpleDateFormat sdfd = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfh = new SimpleDateFormat("hh:mm");
	private Consulta consulta;
	private int id;

	ConsultaForm() {
		// Propriedades do Formulário
		setTitle("Agendamento de Consultas");
		setBounds(100, 180, 597, 310);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Cabeçalho do Formulário
		labelCabecalho = new JLabel(
				"Data:             Hora:        Paciente:              Dentista:               Atendente:              Tratamento:");
		labelCabecalho.setBounds(10, 5, 580, 20);
		panel.add(labelCabecalho);
		tfData = new JTextField(sdfd.format(new Date()));
		tfData.setBounds(10, 30, 70, 25);
		panel.add(tfData);
		tfHora = new JTextField(sdfh.format(new Date()));
		tfHora.setBounds(80, 30, 50, 25);
		panel.add(tfHora);
		cbPaciente = new JComboBox<String>();
		for (Paciente p : ProcessaClinica.getPacientes())
			cbPaciente.addItem(p.getId() + "-" + p.getNome());
		cbPaciente.setBounds(130, 30, 95, 25);
		panel.add(cbPaciente);
		cbDentista = new JComboBox<String>();
		for (Funcionario f : ProcessaClinica.getFuncionarios())
			if (f.getCargo().contentEquals("Dentista"))
				cbDentista.addItem(f.getId() + "-" + f.getNome());
		cbDentista.setBounds(225, 30, 95, 25);
		panel.add(cbDentista);
		cbAtendente = new JComboBox<String>();
		for (Funcionario f : ProcessaClinica.getFuncionarios())
			if (f.getCargo().contentEquals("Auxiliar"))
				cbAtendente.addItem(f.getId() + "-" + f.getNome());
		cbAtendente.setBounds(320, 30, 95, 25);
		panel.add(cbAtendente);
		cbTratamento = new JComboBox<String>();
		for (String t : ProcessaClinica.getTratamentos())
			cbTratamento.addItem(t.toString());
		cbTratamento.setBounds(415, 30, 95, 25);
		panel.add(cbTratamento);

		// Tabela de Consultas Habilitada para Alteração do Conteúdo
		dtmConsultas = new DefaultTableModel();
		dtmConsultas.addColumn("Data");
		dtmConsultas.addColumn("Hora");
		dtmConsultas.addColumn("Paciente");
		dtmConsultas.addColumn("Dentista");
		dtmConsultas.addColumn("Atendente");
		dtmConsultas.addColumn("Tratamento");
		dtmConsultas.addColumn("Status");
		for (Consulta c : ProcessaClinica.getConsultas()) {
			linha[0] = c.getData();
			linha[1] = c.getHora();
			linha[2] = c.getPaciente().getId() + "-" + c.getPaciente().getNome();
			linha[3] = c.getDentista().getId() + "-" + c.getDentista().getNome();
			linha[4] = c.getAtendente().getId() + "-" + c.getAtendente().getNome();
			linha[5] = c.getTratamento();
			linha[6] = "" + c.isStatus();
			dtmConsultas.addRow(linha);
		}
		tbConsultas = new JTable(dtmConsultas);
		scroll = new JScrollPane(tbConsultas);
		scroll.setBounds(10, 55, 559, 170);
		panel.add(scroll);

		// Botão Adicionar Consulta à Tabela
		btAdd = new JButton("Add");
		btAdd.setBounds(509, 30, 59, 25);
		panel.add(btAdd);
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				linha[0] = tfData.getText();
				tfData.setText("");
				linha[1] = tfHora.getText();
				tfHora.setText("");
				linha[2] = cbPaciente.getSelectedItem().toString();
				linha[3] = cbDentista.getSelectedItem().toString();
				linha[4] = cbAtendente.getSelectedItem().toString();
				linha[5] = cbTratamento.getSelectedItem().toString();
				linha[6] = "false";
				dtmConsultas.addRow(linha);
			}
		});

		// Botão Deletar
		btDel = new JButton("Del");
		btDel.setBounds(278, 225, 59, 30);
		panel.add(btDel);
		btDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tbConsultas.getSelectedRow() >= 0) {
					dtmConsultas.removeRow(tbConsultas.getSelectedRow());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});

		// Botão Cancelar
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(328, 225, 120, 30);
		panel.add(btCancelar);
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		// Botão Salvar que Renova toda a lista com o conteúdo da tabela
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(448, 225, 120, 30);
		panel.add(btSalvar);
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Consulta> consultas = new ArrayList<>();
				for (int i = 0; i < dtmConsultas.getRowCount(); i++) {
					consulta = new Consulta();
					consulta.setData(dtmConsultas.getValueAt(i, 0).toString());
					consulta.setHora(dtmConsultas.getValueAt(i, 1).toString());
					id = Integer.parseInt(dtmConsultas.getValueAt(i, 2).toString().split("-")[0]);
					//Percorre a lista de objetos procurando por um atributo (id)
					for (Paciente p : ProcessaClinica.getPacientes())
						if (p.getId() == id)
							consulta.setPaciente(p);//Se encontrar configura o objeto paciente
					id = Integer.parseInt(dtmConsultas.getValueAt(i, 3).toString().split("-")[0]);
					for (Funcionario f : ProcessaClinica.getFuncionarios())
						if (f.getId() == id)
							consulta.setDentista(f);
					id = Integer.parseInt(dtmConsultas.getValueAt(i, 4).toString().split("-")[0]);
					for (Funcionario f : ProcessaClinica.getFuncionarios())
						if (f.getId() == id)
							consulta.setAtendente(f);
					consulta.setTratamento(dtmConsultas.getValueAt(i, 5).toString());
					if (dtmConsultas.getValueAt(i, 6).toString().contentEquals("true"))
						consulta.setStatus(true);
					else
						consulta.setStatus(false);
					consultas.add(consulta);
				}
				ProcessaClinica.setConsultas(consultas);
				dispose();
			}
		});
	}

}
