public class TryCatch {
    public static void main(String[] args) {
        int v1 = 0, v2 = 0, res = 0;
        char lista[] = { 1, 2, 3 };

        for (int i = 0; i < lista.length; i++) {
            try {
                if (i ==0) {
                    res = v1 / v2;
                } else {
                    lista[3] = 4;
                }
            } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Exeption: " + e);
            } finally {
                System.out.println("QUE NEGOCIO RUIM PQP ISSO VAI ATIVAR MESMO QUE OCORRA UM ERRO. SEMPRE VAI OCORRER ESSE BLOCO DE CODIGO");
            }
            System.out.println("i = " + i);
            System.out.println("res = " + res);
        }
    }
}
