public class Moto extends Veiculo {

    public Moto(int motor, int freio) {
        super(motor, freio);
    }

    @Override
    public void acelerar(int tempo) {
        if (isOn() && tempo > 0 && this.cambio > 0) {
            this.velocidade += this.motor * 3;
            acelerar(tempo - 1);
        }
    }
}
