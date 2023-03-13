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
                    if (this.velocidade < 40)
                        this.velocidade += this.motor * 3;
                    break;
                case 2:
                    if (this.velocidade < 80)
                        this.velocidade += this.motor * 3;
                    break;
                case 3:
                    if (this.velocidade < 120)
                        this.velocidade += this.motor * 3;
                    break;
                case 4:
                    if (this.velocidade < 160)
                        this.velocidade += this.motor * 3;
                    break;
                case 5:
                    if (this.velocidade < 200)
                        this.velocidade += this.motor * 3;
                    break;
                case 6:
                    if (this.velocidade < 270) {
                        this.velocidade += this.motor * 3;
                    }
                    break;
            }
            acelerar(tempo - 1);
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
