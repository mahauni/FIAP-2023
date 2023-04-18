package check2;

import java.util.HashMap;

public class verification {
	static HashMap<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		cadastro("Cictor", "123");
		
		verificar("Cictor", "123");
	}
	
	public static void cadastro(String usuario, String senha) {		
		map.put("Lucas", "1234");
		map.put("Cictor", "123");
		map.put("Teteu", "12");
		map.put("Gabriel", "1");
		
		if (map.containsKey(usuario)) {
			System.out.println("Usuario ja cadastrado");
			return;
		}
		
		map.put(usuario, senha);
		
		System.out.println("Usuario cadastrado");
	}
	
	public static boolean verificar(String usuario, String senha) {
		// verificar se a senha e o usuario e o mesmo
		
		String passwd = map.get(usuario);
		
		if (passwd.equals(senha)) {
			System.out.println("Voce entrou");
			return true;
		}
		
		System.out.println("Usuario nao valido");
		return false;
	}
}
