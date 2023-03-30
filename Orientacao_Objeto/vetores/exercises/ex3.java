import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        HashSet<Integer> mapa = new HashSet();
        List<Integer> list = new LinkedList<Integer>();
        long iter = 50000000;

        long ini = System.currentTimeMillis();
        for (long i = 0; i < iter; i++) {
            lista.add(1);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto array list: " + (fim - ini));
    
        ini = System.currentTimeMillis();
        for (long i = 0; i < iter; i++) {
            list.add(1);
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto linked list: " + (fim - ini));

        ini = System.currentTimeMillis();
        for (long i = 0; i < iter; i++) {
            mapa.add(1);
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto mapa: " + (fim - ini));
    }
}
