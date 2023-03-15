import veiculos.*;

public class main {
    public static void main(String[] args) {
        Carro carro = new Carro(10, 5, false);

        carro.ligar();
        carro.freioDeMaoDeactivate();
        carro.aumentarCambio();
        carro.acelerar(10);
        System.out.println(carro.getVelocidade());
    }
}
