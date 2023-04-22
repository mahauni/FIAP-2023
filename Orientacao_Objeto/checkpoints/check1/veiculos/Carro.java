package veiculos;

import interfaces.Marcha;

public class Carro extends Veiculo implements Marcha {
    private boolean freioDeMao;
    private int cambio;
    private boolean cambioAutomatico;

    public Carro(int motor, int freio, boolean cambioAutomatico, String placa, String marca, String modelo) {
        super(motor, freio, placa, marca, modelo);
        this.freioDeMao = true;
        this.cambio = 0;
        this.cambioAutomatico = cambioAutomatico;
    }
    
    public void AtivarFreioDeMao() {
        this.freioDeMao = true;
        this.velocidade = 0;
    }
    public void DesativarFreioDeMao() {
        this.freioDeMao = false;
    }
    public boolean freioDeMaoAtivado() {
        if (this.freioDeMao == true)
            return true;
        return false;
    }
    public void re(int tempo) {
        if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.velocidade == 0 && this.cambio == -1) {
            this.velocidade -= this.motor;
            re(tempo - 1);
        }
    }

    @Override
    public void acelerar(int tempo) {
        if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == false) {
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
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 7:
                    if (this.velocidade < 240) {
                        if (this.velocidade + this.motor * 2 > 240) {
                            this.velocidade = 240;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
            }
            acelerar(tempo - 1);
        } else if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == true) {
            this.velocidade += this.motor * 2;
            acelerar(tempo - 1);
        } else if (!isOn()) {
            ligar();
            System.out.println("O carro foi ligado");
            acelerar(tempo);
        } else if (freioDeMaoAtivado()) {
            DesativarFreioDeMao();
            System.out.println("O freio de mao foi ativado");
        }
    }

    @Override
    public int marcha(int cambio, int velocidade, int motor) {
        if (velocidade < 30 * cambio) {
            if (velocidade + motor * 2 > 30 * cambio) {
                velocidade = 30 * cambio;
            } else
                velocidade += motor * 2;
        }
        return velocidade;
    }

    @Override
    public void aumentarCambio() {
        if (isOn() && this.cambio < 7)
            this.cambio += 1;
        else
            System.out.println("Voce esta no limite da marcha");
    }
    
    @Override
    public void diminuirCambio() {
        if (isOn() && this.cambio > -1)
            this.cambio -= 1;
        else
            System.out.println("Voce esta no limite da marcha");
    }
}