import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwdField;
	private String names[] = {"logo.png"};
	private Icon icons[] = {new ImageIcon(getClass().getResource(names[0]))};

	static Login loginFrame;
	static Cadastro cadastroFrame;
	static Index indexFrame;

	public Login() {
		loginFrame();
	}

	public void otherPages(Login loginPage, Cadastro cadastroPage, Index indexPage) {
		loginFrame = loginPage;
		cadastroFrame = cadastroPage;
		indexFrame = indexPage;
	}

	/**
	 * Create the frame.
	 */
	public void loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		userField.setBounds(235, 112, 233, 39);
		contentPane.add(userField);
		userField.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(139, 97, 152, 66);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenha.setBounds(149, 184, 158, 39);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setBounds(139, 253, 142, 34);
		contentPane.add(btnEntrar);

		JLabel lblEsqSen = new JLabel("Esqueci minha senha");
		lblEsqSen.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblEsqSen.setBounds(215, 320, 289, 34);
		contentPane.add(lblEsqSen);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(354, 253, 142, 34);
		contentPane.add(btnCancelar);

		passwdField = new JPasswordField();
		passwdField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwdField.setColumns(10);
		passwdField.setBounds(235, 184, 233, 39);
		contentPane.add(passwdField);

		JButton btnCadastro = new JButton("Cadastro");
        btnCadastro.setBounds(520, 51, 89, 23);
        contentPane.add(btnCadastro);

		JLabel lblLogo = new JLabel();
        lblLogo.setBounds(10, 11, 500, 75);
        contentPane.add(lblLogo);
        lblLogo.setIcon(icons[0]);

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userField.getText();	
				String password = passwdField.getText();	

				System.out.println(user);
				System.out.println(password);
				
				// if passwd fail says the passwd or the user is wrong
				if (!Verification.verificar(user, password)) {
					passwdField.setText("");
					JOptionPane.showMessageDialog(null, "Wrong password or user");
					return;
				}
				
				// if it enters we open another frame and close this one
				System.out.println("entered");
				
				loginFrame.setVisible(false);
				userField.setText("");
				passwdField.setText("");
				indexFrame.setVisible(true);
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userField.setText("");
				passwdField.setText("");
			}
		});
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				cadastroFrame.setVisible(true);
			}
		});
	}
}
