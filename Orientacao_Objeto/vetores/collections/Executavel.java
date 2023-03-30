package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Executavel {

	public static void main(String[] args) {

		Usuario jose = new Usuario(1, "Jose", "admin");
		Usuario maria = new Usuario(2, "Maria", "admin");
		Usuario antonio = new Usuario(3, "Antonio", "admin");
		Usuario ana = new Usuario(4, "Ana", "admin");
		Usuario raquel = new Usuario(5, "Raquel", "admin");

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		listaUsuarios.add(raquel);
		listaUsuarios.add(jose);
		listaUsuarios.add(antonio);
		listaUsuarios.add(ana);
		listaUsuarios.add(maria);
		listaUsuarios.add(new Usuario(6, "Emerson", "admin"));

		for (Usuario user : listaUsuarios) {
			System.out.println("Id: " + user.getIdUsuario());
			System.out.println("Nome: " + user.getNomeUsuario());
		}

		Collections.sort(listaUsuarios);
		System.out.println("\n***Lista ordenada***\n");

		for (Usuario user : listaUsuarios) {
			System.out.println("Id: " + user.getIdUsuario());
			System.out.println("Nome: " + user.getNomeUsuario());
		}

		System.out.println("\n***Mapa***\n");

		Map mapa = new HashMap();
		mapa.put("Jose", jose);

		System.out.println("Tamanho do mapa: " + mapa.size());

		Usuario user = (Usuario) mapa.get("Jose");
		System.out.println("Nome do usuario no mapa: " + user.getNomeUsuario());

	}

}
