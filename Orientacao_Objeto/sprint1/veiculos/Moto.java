public class Moto extends Veiculo {
    private int cambio;

    public Moto(int motor, int freio) {
        super(motor, freio);
        this.cambio = 0;
    }

    @Override
    public void acelerar(int tempo) {
        if (isOn() && tempo > 0 && this.cambio > 0) {
            switch (this.cambio) {
                case 1:
                    if (this.velocidade < 40) {
                        if (this.velocidade + this.motor * 3 > 40) {
                            this.velocidade = 40;
                        } else
                            this.velocidade += this.motor * 3;
                    }
                    break;
                case 2:
                    if (this.velocidade < 80) {
                        if (this.velocidade + this.motor * 3 > 80) {
                            this.velocidade = 80;
                        } else
                            this.velocidade += this.motor * 3;
                    }
                    break;
                case 3:
                    if (this.velocidade < 120) {
                        if (this.velocidade + this.motor * 3 > 120) {
                            this.velocidade = 120;
                        } else
                            this.velocidade += this.motor * 3;
                    }
                    break;
                case 4:
                    if (this.velocidade < 160) {
                        if (this.velocidade + this.motor * 3 > 160) {
                            this.velocidade = 160;
                        } else
                            this.velocidade += this.motor * 3;
                    }
                    break;
                case 5:
                    if (this.velocidade < 200) {
                        if (this.velocidade + this.motor * 3 > 200) {
                            this.velocidade = 200;
                        } else
                            this.velocidade += this.motor * 3;
                    }
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
}
