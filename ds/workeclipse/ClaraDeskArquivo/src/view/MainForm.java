package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProcessaClinica;
import model.Consulta;
import model.Funcionario;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JButton btCadPaciente, btCadFuncionario, btCadConsulta;
	private JComboBox<String> cbDentista;
	private DefaultTableModel tmConsultas;
	private JTable tbConsultas;
	private JScrollPane scroll;
	private String[] linha = new String[7];

	public MainForm() {
		// Cabeçalho do Formulário
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CLÍNICA CLARA - Tela Principal");
		setBounds(100, 100, 597, 400);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Botão cadastrar Paciente
		btCadPaciente = new JButton("Cadastrar Paciente");
		btCadPaciente.setBounds(10, 10, 180, 30);
		panel.add(btCadPaciente);
		btCadPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacienteForm formPaciente = new PacienteForm();
				formPaciente.setModal(true);
				formPaciente.setVisible(true);
			}
		});

		// Botão cadastrar Funcionario
		btCadFuncionario = new JButton("Cadastrar Funcionario");
		btCadFuncionario.setBounds(200, 10, 180, 30);
		panel.add(btCadFuncionario);
		btCadFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncionarioForm formFunc = new FuncionarioForm();
				formFunc.setModal(true);
				formFunc.setVisible(true);
				dispose();
				new MainForm().setVisible(true);
				ProcessaClinica.setId(0);
			}
		});

		// Combo Box para escolher o Dentista e Filtrar a Agenda
		cbDentista = new JComboBox<String>();
		cbDentista.addItem("0-Escolha o Dentista");
		for (Funcionario f : ProcessaClinica.getFuncionarios()) {
			if (f.getCargo().contentEquals("Dentista")) {
				cbDentista.addItem(f.getId() + "-" + f.getNome());
			}
		}
		cbDentista.setBounds(390, 10, 180, 30);
		panel.add(cbDentista);

		// Evento que pega o id do Dentista selecionado na JComboBox
		// coloca na variável id e atualiza o form
		cbDentista.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ProcessaClinica.setId(Integer.parseInt(cbDentista.getSelectedItem().toString().split("-")[0]));
					dispose();
					new MainForm().setVisible(true);
				}
			}
		});

		// Monta a tabela de Consultas
		montarModeloDaTabelaConsultas(ProcessaClinica.getId());
		tbConsultas = new JTable(tmConsultas);
		tbConsultas.setEnabled(false);
		scroll = new JScrollPane(tbConsultas);
		scroll.setBounds(10, 50, 561, 260);
		panel.add(scroll);
		// Botão Agendar Consulta
		btCadConsulta = new JButton("Agendar Consulta");
		if (ProcessaClinica.getPacientes().isEmpty() || ProcessaClinica.getFuncionarios().isEmpty())
			btCadConsulta.setEnabled(false);
		else
			btCadConsulta.setEnabled(true);
		btCadConsulta.setBounds(390, 315, 180, 30);
		panel.add(btCadConsulta);
		btCadConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaForm formConsulta = new ConsultaForm();
				formConsulta.setModal(true);
				formConsulta.setVisible(true);
				dispose();
				new MainForm().setVisible(true);
				ProcessaClinica.setId(0);
			}
		});
	}

	// Método que monta a tabela de Consultas
	// recebe o id como filtro
	public void montarModeloDaTabelaConsultas(int filtro) {
		tmConsultas = new DefaultTableModel();
		tmConsultas.addColumn("Data");
		tmConsultas.addColumn("Hora");
		tmConsultas.addColumn("Paciente");
		tmConsultas.addColumn("Dentista");
		tmConsultas.addColumn("Atendente");
		tmConsultas.addColumn("Tratamento");
		tmConsultas.addColumn("Status");
		for (Consulta c : ProcessaClinica.getConsultas()) {
			if (filtro == 0) {
				if (!c.isStatus()) {
					linha[0] = c.getData();
					linha[1] = c.getHora();
					linha[2] = c.getPaciente().getNome();
					linha[3] = c.getDentista().getNome();
					linha[4] = c.getAtendente().getNome();
					linha[5] = c.getTratamento();
					linha[6] = "" + c.isStatus();
					tmConsultas.addRow(linha);
				}
			} else {
				if (!c.isStatus() && filtro == c.getDentista().getId()) {
					linha[0] = c.getData();
					linha[1] = c.getHora();
					linha[2] = c.getPaciente().getNome();
					linha[3] = c.getDentista().getNome();
					linha[4] = c.getAtendente().getNome();
					linha[5] = c.getTratamento();
					linha[6] = "" + c.isStatus();
					tmConsultas.addRow(linha);
				}
			}
		}
	}

	public static void main(String[] args) {
		ProcessaClinica.start();
		MainForm mainForm = new MainForm();
		mainForm.setVisible(true);
	}
}
