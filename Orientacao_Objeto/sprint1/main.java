import veiculos.*;

public class main {
    public static void main(String[] args) {
        Carro carro = new Carro(10, 5, false, "123AV-13D", "Masserati", "GranTurismo");

        carro.ligar();
        carro.DesativarFreioDeMao();
        carro.aumentarCambio();
        carro.acelerar(10);
        System.out.println(carro.getVelocidade());
        carro.aumentarCambio();
        carro.acelerar(5);
        System.out.println(carro.getVelocidade());
        carro.aumentarCambio();
        carro.acelerar(1);
        System.out.println(carro.getVelocidade());
        carro.DesativarFreioDeMao();


        Moto moto = new Moto(3, 6, "1234-000", "Yamaha", "Aloha");
    
        moto.ligar();
        moto.aumentarCambio();
        moto.acelerar(10);
        System.out.println(moto.getVelocidade());
        moto.aumentarCambio();
        moto.acelerar(5);
        System.out.println(moto.getVelocidade());
        moto.aumentarCambio();
        moto.acelerar(1);
        System.out.println(moto.getVelocidade());
        moto.freiar(13);
        System.out.println(moto.getVelocidade());


        Caminhao caminhao = new Caminhao(7, 4, false, "999-AA99", "Caminho", "Optimus");
    
        caminhao.ligar();
        caminhao.aumentarCambio();
        caminhao.acelerar(10);
        System.out.println(caminhao.getVelocidade());
        caminhao.aumentarCambio();
        caminhao.acelerar(5);
        System.out.println(caminhao.getVelocidade());
        caminhao.aumentarCambio();
        caminhao.acelerar(1);
        System.out.println(caminhao.getVelocidade());
        caminhao.freiar(13);
        System.out.println(caminhao.getVelocidade());
    }
}
