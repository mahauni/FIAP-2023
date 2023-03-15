package veiculos;

import interfaces.Marcha;

public class Moto extends Veiculo implements Marcha {
    private int cambio;

    public Moto(int motor, int freio, String placa, String marca, String modelo) {
        super(motor, freio, placa, marca, modelo);
        this.cambio = 0;
    }

    @Override
    public void acelerar(int tempo) {
        if (isOn() && tempo > 0 && this.cambio > 0) {
            switch (this.cambio) {
                case 1:
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 2:
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 3:
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 4:
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 5:
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 6:
                    if (this.velocidade < 270) {
                        if (this.velocidade + this.motor * 3 > 270) {
                            this.velocidade = 270;
                        } else
                            this.velocidade += this.motor * 3;
                    }
                    break;
            }
            acelerar(tempo - 1);
        } else if (!isOn()) {
            ligar();
            System.out.println("O carro foi ligado");
            acelerar(tempo);
        }
    }

    
    @Override
    public void aumentarCambio() {
        if (isOn() && this.cambio < 6)
            this.cambio += 1;
        else
            System.out.println("Voce esta no limite da marcha!");
    }

    @Override
    public void diminuirCambio() {
        if (isOn() && this.cambio > 0)
            this.cambio -= 1;
        else
            System.out.println("Voce esta no limite da marcha!");
    }

    public int marcha(int cambio, int velocidade, int motor) {
        if (velocidade < 40 * cambio) {
            if (velocidade + motor * 3 > 40 * cambio) {
                velocidade = 40 * cambio;
            } else
                velocidade += motor * 3;
        }
        return velocidade;
    }
}
