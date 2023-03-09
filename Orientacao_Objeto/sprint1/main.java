public class main {
    public static void main(String[] args) {
        Carro carro = new Carro(10, 5);

        carro.ligar();
        carro.acelerar(10);
        carro.freioDeMaoDeactivate();
        System.out.println(carro.getVelocidade());
        carro.acelerar(10);
        System.out.println(carro.getVelocidade());
        carro.freiar(10);
        System.out.println(carro.getVelocidade());
    }
}
