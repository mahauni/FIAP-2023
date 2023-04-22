import java.awt.EventQueue;

public class main {
    static login loginFrame = new login();
	static cadastro cadastroFrame = new cadastro();
	static index indexFrame = new index();

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
