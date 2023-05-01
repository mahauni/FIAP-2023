import java.awt.EventQueue;

public class Main {
    static Login loginFrame = new Login();
	static Cadastro cadastroFrame = new Cadastro();
	static Index indexFrame = new Index();

	public static void main(String[] args) {

		loginFrame.otherPages(loginFrame, cadastroFrame, indexFrame);
		cadastroFrame.otherPages(loginFrame, cadastroFrame);
		indexFrame.otherPages(loginFrame, indexFrame);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
