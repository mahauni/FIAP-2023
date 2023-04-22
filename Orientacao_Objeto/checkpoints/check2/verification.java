import java.util.HashMap;
import java.util.Map;

public class verification {
	static Map<String, String> map = new HashMap<String, String>() {{
		put("Lucas", "1234");
		put("Cictor", "123");
		put("Teteu", "12");
		put("Gabriel", "1");
	}};
	
	public static void main(String[] args) {
		cadastro("Cictor", "123");
		
		verificar("Cictor", "123");
	}
	
	public static boolean cadastro(String usuario, String senha) {		
		if (map.containsKey(usuario)) {
			System.out.println("Usuario ja cadastrado");
			return false;
		}
		
		map.put(usuario, senha);
		
		System.out.println("Usuario cadastrado");
		return true;
	}
	
	public static boolean verificar(String usuario, String senha) {
		// verificar se a senha e o usuario e o mesmo
		
		String passwd = map.get(usuario);
		
		if (passwd != null && passwd.equals(senha)) {
			System.out.println("Voce entrou");
			return true;
		}
		
		System.out.println("Usuario nao valido");
		return false;
	}
}
