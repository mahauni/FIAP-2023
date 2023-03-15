import veiculos.*;

public class main {
    public static void main(String[] args) {
        Carro carro = new Carro(10, 5, false, "123AV-13D", "Masserati", "GranTurismo");

        System.out.println("-------- Carro --------");
        carro.ligar();
        System.out.println("Desativando o freio de mao");
        carro.DesativarFreioDeMao();
        System.out.println("Aumento o cambio");
        carro.aumentarCambio();
        System.out.println("Acelerando o carro");
        carro.acelerar(10);
        System.out.println(carro.getVelocidade());
        carro.aumentarCambio();
        System.out.println("Aumento o cambio");
        carro.acelerar(5);
        System.out.println("Acelerando o carro");
        System.out.println(carro.getVelocidade());
        carro.aumentarCambio();
        System.out.println("Aumento o cambio");
        carro.acelerar(1);
        System.out.println("Acelerando o carro");
        System.out.println(carro.getVelocidade());
        carro.AtivarFreioDeMao();
        System.out.println("Ativando o freio de mao"); 
        System.out.println(carro.getVelocidade());

        System.out.println();


        System.out.println("-------- Moto --------");
        Moto moto = new Moto(3, 6, "1234-000", "Yamaha", "Aloha");
    
        moto.ligar();
        moto.aumentarCambio();
        System.out.println("Aumento o cambio");
        moto.acelerar(10);
        System.out.println("Acelerando o moto");
        System.out.println(moto.getVelocidade());
        moto.aumentarCambio();
        System.out.println("Aumento o cambio");
        moto.acelerar(5);
        System.out.println("Acelerando o moto");
        System.out.println(moto.getVelocidade());
        moto.aumentarCambio();
        System.out.println("Aumento o cambio");
        moto.acelerar(1);
        System.out.println("Acelerando o moto");
        System.out.println(moto.getVelocidade());
        moto.freiar(13);
        System.out.println("Freiando a moto");
        System.out.println(moto.getVelocidade());


        System.out.println();

        System.out.println("-------- Caminhao --------");
        Caminhao caminhao = new Caminhao(7, 4, false, "999-AA99", "Caminho", "Optimus");
    
        caminhao.ligar();
        caminhao.aumentarCambio();
        System.out.println("Aumento o cambio");
        caminhao.acelerar(10);
        System.out.println("Acelerando o caminhao");
        System.out.println(caminhao.getVelocidade());
        caminhao.aumentarCambio();
        System.out.println("Aumento o cambio");
        caminhao.acelerar(5);
        System.out.println("Acelerando o caminhao");
        System.out.println(caminhao.getVelocidade());
        caminhao.aumentarCambio();
        System.out.println("Aumento o cambio");
        caminhao.acelerar(1);
        System.out.println("Acelerando o caminhao");
        System.out.println(caminhao.getVelocidade());
        caminhao.freiar(13);
        System.out.println("Freiando a caminhao");
        System.out.println(caminhao.getVelocidade());
    }
}
