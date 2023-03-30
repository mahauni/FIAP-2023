import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import vetores.usuario.Usuario;

public class ex2 {
    public static void main(String[] args) {
        Map<String, Usuario> mapa = new HashMap();

        mapa.put("Lucas", new Usuario(5, "Lucas", "senha69"));
        mapa.put("Teteu", new Usuario(2, "Teteu", "senha25"));
        mapa.put("Gabriel", new Usuario(7, "Gabriel", "senha24"));
        mapa.put("Vitin", new Usuario(1, "Vitin", "senha4"));
        mapa.put("Trogodita", new Usuario(3, "Trogodita", "senha420"));

        Object object = mapa.get("Teteu");
        Usuario usuario = (Usuario) object;
        System.out.println(usuario.getNome());

        System.out.println(mapa.get("Trogodita").getId());
    }
}