package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.User;

public class Database {
	private static List<User> lista = new ArrayList<>();	
	private static int id = 1;
	
	public static void adiciona(User user) {
		user.setId(id++);
		lista.add(user);
	}
	
	public static void remove(int id) {
		Iterator<User> it = lista.iterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getId() == id) {
				it.remove();
			}
		}
	}
	
	public static List<User> getUsers() {
		return lista;
	}
	
	public static User searchById(int id) {
		for (User user : lista) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
}
