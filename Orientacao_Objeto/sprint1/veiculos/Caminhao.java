public class Caminhao extends Veiculo {
    private boolean freioDeMao;
    private boolean cambioAutomatico;

    public Caminhao(int motor, int freio, boolean cambioAutomatico) {
        super(motor, freio);
        this.cambioAutomatico = cambioAutomatico;
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
        if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == false) {
            switch (this.cambio) {
                case 1:
                    if (this.velocidade < 30)
                        this.velocidade += this.motor;
                    break;
                case 2:
                    if (this.velocidade < 60)
                        this.velocidade += this.motor;
                    break;
                case 3:
                    if (this.velocidade < 60)
                        this.velocidade += this.motor;
                    break;
                case 4:
                    if (this.velocidade < 90)
                        this.velocidade += this.motor;
                    break;
                case 5:
                    if (this.velocidade < 120)
                        this.velocidade += this.motor;
                    break;
                case 6:
                    this.velocidade += this.motor;
                    break;
            }
            this.velocidade += this.motor * 1;
            acelerar(tempo - 1);
        } else if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == true) {
            this.velocidade += this.motor * 1;
            acelerar(tempo - 1);
        }
    }
}
