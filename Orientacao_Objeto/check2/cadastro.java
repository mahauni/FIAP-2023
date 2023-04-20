import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class cadastro extends JFrame {

    private JPanel contentPane;
	private JTextField userField;
	private JTextField passwdField;
	private String names[] = {"logo.png"};
	private Icon icons[] = {new ImageIcon(getClass().getResource(names[0]))};
    
	static login loginFrame;	
	static cadastro cadastroFrame;

	public cadastro() {
		cadastroFrame();
	}

	public void otherPages(login loginPage, cadastro cadastroPage) {
		loginFrame = loginPage;
		cadastroFrame = cadastroPage;
	}

	/**
	 * Create the frame.
	 */
	public void cadastroFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		userField.setBounds(238, 171, 233, 39);
		contentPane.add(userField);
		userField.setColumns(10);
        
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(142, 157, 152, 66);
		contentPane.add(lblUsuario);
        
        passwdField = new JTextField();
        passwdField.setFont(new Font("Tahoma", Font.PLAIN, 25));
        passwdField.setColumns(10);
        passwdField.setBounds(238, 243, 233, 39);
        contentPane.add(passwdField);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenha.setBounds(142, 243, 158, 39);
		contentPane.add(lblSenha);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrar.setBounds(142, 312, 142, 34);
		contentPane.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(357, 312, 142, 34);
		contentPane.add(btnCancelar);

		JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(520, 61, 89, 23);
        contentPane.add(btnLogin);

		JLabel lblLogo = new JLabel();
        lblLogo.setBounds(10, 11, 500, 75);
        contentPane.add(lblLogo);
        lblLogo.setIcon(icons[0]);
		
		JLabel lblTitle = new JLabel("Cadastrar novo usuario");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(192, 88, 261, 39);
		contentPane.add(lblTitle);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userField.getText();	
				String password = passwdField.getText();	

				System.out.println(user);
				System.out.println(password);

                if (verification.cadastro(user, password)) {
					userField.setText("");
					passwdField.setText("");
					JOptionPane.showMessageDialog(null, "Usuario cadastrado");
					return;
				}

				userField.setText("");
				passwdField.setText("");
				JOptionPane.showMessageDialog(null, "Usuario existente");
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userField.setText("");
				passwdField.setText("");
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroFrame.setVisible(false);
				loginFrame.setVisible(true);
			}
		});
	}
}
