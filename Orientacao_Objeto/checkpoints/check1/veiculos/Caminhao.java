package veiculos;

import interfaces.Marcha;

public class Caminhao extends Veiculo implements Marcha {
    private boolean freioDeMao;
    private boolean cambioAutomatico;
    protected int cambio;

    public Caminhao(int motor, int freio, boolean cambioAutomatico, String placa, String marca, String modelo) {
        super(motor, freio, placa, marca, modelo);
        this.cambioAutomatico = cambioAutomatico;
        this.freioDeMao = true;
        this.cambio = 0;
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
                    this.velocidade = marcha(this.cambio, this.velocidade, this.motor);
                    break;
                case 8:
                    if (this.velocidade < 200) {
                        if (this.velocidade + this.motor > 200) {
                            this.velocidade = 200;
                        } else
                            this.velocidade += this.motor;
                    }
                    break;
            }
            acelerar(tempo - 1);
        } else if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == true) {
            this.velocidade += this.motor * 1;
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
    public void aumentarCambio() {
        if (isOn() && this.cambio < 8)
            this.cambio += 1;
        else
            System.out.println("Voce esta no limite da marcha!");
    }

    @Override
    public void diminuirCambio() {
        if (isOn() && this.cambio > -1)
            this.cambio -= 1;
        else
            System.out.println("Voce esta no limite da marcha!");
    }
    
    public int marcha(int marcha, int velocidade, int motor) {
        if (velocidade < 20 * marcha) {
            if (velocidade + motor > 20 * marcha) {
                velocidade = 20 * marcha;
            } else
                velocidade += motor;
        }
        return velocidade;
    }
}
