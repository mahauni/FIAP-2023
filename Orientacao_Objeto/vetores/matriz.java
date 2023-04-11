package vetores;
import java.util.Random;

public class matriz {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] matriz = new int[10][10];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(101);
            }
        }

        // print
        for (int[] l : matriz) {
            for (int c: l) {
                System.out.print(c + "\t");
            }
            System.out.println("");
        }
    }
}
