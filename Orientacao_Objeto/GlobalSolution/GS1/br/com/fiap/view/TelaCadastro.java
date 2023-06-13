package br.com.fiap.view;

import br.com.fiap.model.Dado;
import br.com.fiap.repository.DadoDAO;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField campoPh;
	private JTextField campoUmidade;
	private JTextField campoSalinidade;
	private JTextField campoAcoes;
	private JTextField campoSugestoes;
	private JTextField campoAumento;
	private JTextField campoNutri;
	private JTextField campoUsuario;
	private DadoDAO dao = new DadoDAO();
	private Dado dado = new Dado();
	private int userId = -1;
	private JTable table;
	private DefaultTableModel model;
	private JTextField campoId;
	private JScrollPane scroll_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Interface de Registro");
		lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 23));
		lblNewLabel.setBounds(247, 11, 210, 34);
		contentPane.add(lblNewLabel);

		JLabel lblPh = new JLabel("Ph:");
		lblPh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPh.setBounds(75, 116, 46, 14);
		contentPane.add(lblPh);

		campoPh = new JTextField();
		campoPh.setBounds(107, 115, 86, 20);
		contentPane.add(campoPh);
		campoPh.setColumns(10);

		JLabel lblUmidade = new JLabel("Umidade:");
		lblUmidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUmidade.setBounds(35, 157, 62, 14);
		contentPane.add(lblUmidade);

		campoUmidade = new JTextField();
		campoUmidade.setBounds(107, 156, 86, 20);
		contentPane.add(campoUmidade);
		campoUmidade.setColumns(10);

		campoSalinidade = new JTextField();
		campoSalinidade.setBounds(107, 203, 86, 20);
		contentPane.add(campoSalinidade);
		campoSalinidade.setColumns(10);

		campoAcoes = new JTextField();
		campoAcoes.setBounds(354, 115, 127, 20);
		contentPane.add(campoAcoes);
		campoAcoes.setColumns(10);

		JLabel lblSalinidade = new JLabel("Salinidade:");
		lblSalinidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalinidade.setBounds(35, 204, 74, 14);
		contentPane.add(lblSalinidade);

		JLabel lblAcao = new JLabel("Acoes:");
		lblAcao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAcao.setBounds(293, 116, 46, 14);
		contentPane.add(lblAcao);

		JLabel lblSugestoes = new JLabel("Sugestoes:");
		lblSugestoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSugestoes.setBounds(266, 75, 81, 14);
		contentPane.add(lblSugestoes);

		campoSugestoes = new JTextField();
		campoSugestoes.setBounds(354, 74, 127, 20);
		contentPane.add(campoSugestoes);
		campoSugestoes.setColumns(10);

		JLabel lblNutrientes = new JLabel("Nutrientes:");
		lblNutrientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNutrientes.setBounds(265, 204, 74, 14);
		contentPane.add(lblNutrientes);

		JLabel lblAumentoPre = new JLabel("Aumento Previsto:");
		lblAumentoPre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAumentoPre.setBounds(219, 157, 120, 14);
		contentPane.add(lblAumentoPre);

		campoAumento = new JTextField();
		campoAumento.setBounds(354, 156, 127, 20);
		contentPane.add(campoAumento);
		campoAumento.setColumns(10);

		campoNutri = new JTextField();
		campoNutri.setBounds(354, 203, 127, 20);
		contentPane.add(campoNutri);
		campoNutri.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(45, 76, 69, 12);
		contentPane.add(lblUsuario);

		campoUsuario = new JTextField();
		campoUsuario.setBounds(107, 74, 86, 20);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoId.setText("");
				campoAumento.setText("");
				campoSugestoes.setText("");
				campoUmidade.setText("");
				campoNutri.setText("");
				campoPh.setText("");
				campoSalinidade.setText("");
				campoUsuario.setText("");
				campoAcoes.setText("");

				dado.setId(-1);
			}
		});
		btnLimpar.setBounds(485, 247, 115, 23);
		contentPane.add(btnLimpar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(616, 19, 89, 23);
		contentPane.add(btnSair);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dado.setUsuario(campoUsuario.getText());
				dado.setAumento_previsto(Float.parseFloat(campoAumento.getText()));
				dado.setSugestoes(campoSugestoes.getText());
				dado.setUmidade(Float.parseFloat(campoUmidade.getText()));
				dado.setNutrientes(campoNutri.getText());
				dado.setPh(Float.parseFloat(campoPh.getText()));
				dado.setSalinidade(Float.parseFloat(campoSalinidade.getText()));
				dado.setAcoes(campoAcoes.getText());

				Dado s = dado;

				System.out.println(s);

				dao.insert(s);
			}
		});
		btnCadastrar.setBounds(282, 247, 115, 23);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar Dados");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dado.setId(Integer.parseInt(campoId.getText()));
				dado.setUsuario(campoUsuario.getText());
				dado.setAumento_previsto(Float.parseFloat(campoAumento.getText()));
				dado.setSugestoes(campoSugestoes.getText());
				dado.setUmidade(Float.parseFloat(campoUmidade.getText()));
				dado.setNutrientes(campoNutri.getText());
				dado.setPh(Float.parseFloat(campoPh.getText()));
				dado.setSalinidade(Float.parseFloat(campoSalinidade.getText()));
				dado.setAcoes(campoAcoes.getText());

				dao.update(dado);
			}
		});
		btnAlterar.setBounds(540, 92, 115, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir Dados");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userId = Integer.parseInt(campoId.getText());
				dao.delete(userId);
			}
		});
		btnExcluir.setBounds(540, 183, 115, 23);
		contentPane.add(btnExcluir);

		JButton btnBuscar = new JButton("Buscar Dados");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(1);
				List<Dado> dados = dao.selectAll();
				for (Dado dado : dados) {

					Vector<Object> row = new Vector<>();
					row.add(dado.getId());
					row.add(dado.getUsuario());
					row.add(dado.getPh());
					row.add(dado.getUmidade());
					row.add(dado.getSalinidade());
					row.add(dado.getNutrientes());
					row.add(dado.getAcoes());
					row.add(dado.getSugestoes());
					row.add(dado.getAumento_previsto());
					model.addRow(row);

					System.out.println("----------------------------------------");
					System.out.println("Id: " + dado.getId());
					System.out.println("Usuario: " + dado.getUsuario());
					System.out.println("Acoes: " + dado.getAcoes());
					System.out.println("Nutrientes: " + dado.getNutrientes());
					System.out.println("Sugestoes: " + dado.getSugestoes());
					System.out.println("pH: " + dado.getPh());
					System.out.println("Salinidade: " + dado.getSalinidade());
					System.out.println("Umidade: " + dado.getUmidade());
					System.out.println("Aumento previsto: " + dado.getAumento_previsto());
				}
			}
		});
		btnBuscar.setBounds(78, 247, 115, 23);
		contentPane.add(btnBuscar);

		model = new DefaultTableModel(0, 9) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable( model );
		model.addRow(new String[]{"Id", "Usuario", "pH", "Umidade", "Salinidade", "Nutrientes", "Acoes", "Sugestoes", "Aumento previsto"});
		scroll_table = new JScrollPane(table);
		scroll_table.setToolTipText("");
		scroll_table.setBounds(10, 279, 695, 239);
		contentPane.add(scroll_table);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(75, 31, 46, 14);
		contentPane.add(lblId);

		JButton btnPegar = new JButton("Pegar Dados");
		btnPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				campoId.setText(model.getValueAt(selectedRow, 0).toString());
				campoUsuario.setText(model.getValueAt(selectedRow, 1).toString());
				campoPh.setText(model.getValueAt(selectedRow, 2).toString());
				campoUmidade.setText(model.getValueAt(selectedRow, 3).toString());
				campoSalinidade.setText(model.getValueAt(selectedRow, 4).toString());
				campoNutri.setText(model.getValueAt(selectedRow, 5).toString());
				campoAcoes.setText(model.getValueAt(selectedRow, 6).toString());
				campoSugestoes.setText(model.getValueAt(selectedRow, 7).toString());
				campoAumento.setText(model.getValueAt(selectedRow, 8).toString());
			}
		});
		btnPegar.setBounds(540, 137, 115, 23);
		contentPane.add(btnPegar);

		campoId = new JTextField();
		campoId.setBounds(107, 30, 54, 20);
		contentPane.add(campoId);
		campoId.setColumns(10);
		campoId.setEditable(false);
	}
}
