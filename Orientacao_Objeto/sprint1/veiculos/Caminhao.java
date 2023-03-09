public class Caminhao extends Veiculo {
    private boolean freioDeMao;

    public Caminhao(int motor, int freio) {
        super(motor, freio);
        this.freioDeMao = true;
    }

    public void freioDeMaoActivate() {
        this.freioDeMao = true;
        this.velocidade = 0;
    }
    public void freioDeMaoDeactivate() {
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
        if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0) {
            this.velocidade += this.motor * 1;
            acelerar(tempo - 1);
        }
    }
}
