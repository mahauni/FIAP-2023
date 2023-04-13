import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TextAreaFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextAreaFrame frame = new TextAreaFrame();
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
	public TextAreaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box box = Box.createHorizontalBox();
		String string = "Isso e um texto demosntrativo para ser copiado";
		textArea1 = new JTextArea(string, 10, 15);
		
		box.add(new JScrollPane(textArea1));
		button = new JButton("Copiar >>>");
		box.add(button);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea2.setText(textArea1.getSelectedText());
			}
		});
		
		textArea2 = new JTextArea(10, 15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));
		add(box);
	}

}
