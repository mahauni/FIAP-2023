package vetores;
import vetores.usuario.Usuario;

public class mainUsuario {
    public static void main(String[] args) {
        Usuario usuarios[] = new Usuario[2];
        usuarios[0] = new Usuario(2, "Lucas", "senha123");
        usuarios[1] = new Usuario(1, "Teteu", "senha456");

        for (Usuario user: usuarios) {
            System.out.println(user.getNome());
        }
    }
}
