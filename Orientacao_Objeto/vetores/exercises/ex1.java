package vetores.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vetores.usuario.Usuario;

public class ex1 {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(new Usuario(5, "Lucas", "senha69"));
        usuarios.add(new Usuario(2, "Teteu", "senha25"));
        usuarios.add(new Usuario(7, "Gabriel", "senha24"));
        usuarios.add(new Usuario(1, "Vitin", "senha4"));
        usuarios.add(new Usuario(3, "Trogodita", "senha420"));

        for (Usuario i: usuarios) {
            System.out.print(i.getId() + "\t");
        }

        System.out.println("");
        Collections.sort(usuarios);      
    
        for (Usuario i: usuarios) {
            System.out.print(i.getId() + "\t");
        }
    }
}
