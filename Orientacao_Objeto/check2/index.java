import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class index extends JFrame {

	private JPanel contentPane;
	private String names[] = {"logo.png"};
	private Icon icons[] = {new ImageIcon(getClass().getResource(names[0]))};

	static login loginFrame;	
	static index indexFrame;

	public index() {
	    indexFrame();
	}

	public void otherPages(login loginPage, index indexPage) {
		loginFrame = loginPage;
		indexFrame = indexPage;
	}

	/**
	 * Create the frame.
	 */
	public void indexFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 741, 480);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 704, 418);
        panel.setBorder(null);
        contentPane.add(panel);
        panel.setLayout(null);

        JTextArea txtMission = new JTextArea();
        txtMission.setBackground(Color.LIGHT_GRAY);
        txtMission.setEditable(false);
        txtMission.setText("Missão \nImpactar o mercado de jogos, \ncom inovações a cada \nlançamento, e assim gerar \ntendências novas para os \ngames do mainstream e mesmo \ncom essas novidades manter o \nmesmo formato de sempre, o \nprincipal deles, conhecido como \nsoulslike. A fromsoftware também, \nmesmo com o seu estilo único \nde jogos procura sempre prezar \na qualidade de seus jogos, tendo \nem sua coleção diversos prêmios \ncom direção de arte, trilha sonora, \nmelhor jogo do ano, melhor \ndireção, entre outros.");
        txtMission.setBounds(10, 112, 186, 306);
        panel.add(txtMission);

        JTextArea txtVision = new JTextArea();
        txtVision.setBackground(Color.LIGHT_GRAY);
        txtVision.setEditable(false);
        txtVision.setText("Visão \nA visão da from software é\n ousada, querendo manter sempre \nessa mesma franquia de jogos no \nseu mais puro estado de \nexcelência, e qualidade, sem se \npreocupar com tempo de \nresolução, gerando também, \nnovos estilos de arte para que \nnenhum de seus jogos tenha a \nexperiência do anterior e que \ncada vez que o cliente entre, ele \nsaia feliz e satisfeito.");
        txtVision.setBounds(263, 112, 186, 306);
        panel.add(txtVision);

        JTextArea txtValues = new JTextArea();
        txtValues.setBackground(Color.LIGHT_GRAY);
        txtValues.setEditable(true);
        txtValues.setText("Valores \nA FromSoftware tem \ndiversos valores, tais como o \nesforço e o trabalho duro, mas os \nmaiores valores são os da vontade \ne do apoio que a empresa da pros \nseus empregados, os \ntrabalhadores da FromSoftware \ntem sempre resultados positivos \npois amam o que fazem e tem a \ncompreensão da empresa para \nque façam bem feito o seu jogo, \nos trabalhadores sempre realizam \ncom vontade e carinho tudo o que \ndesenvolvem, assim, aumentando \na qualidade do seu produto, \nmesmo que isso custe mais, \nou consuma mais tempo.");
        txtValues.setBounds(508, 112, 186, 306);
        panel.add(txtValues);

        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(10, 11, 531, 90);
        panel.add(lblLogo);
        lblLogo.setIcon(icons[0]);

        JButton btnExit = new JButton("Sair");
        btnExit.setBounds(565, 46, 98, 33);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.setVisible(false);
				loginFrame.setVisible(true);
			}
		});
	}
}

