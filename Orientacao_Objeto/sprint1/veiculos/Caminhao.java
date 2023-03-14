public class Caminhao extends Veiculo {
    private boolean freioDeMao;
    private boolean cambioAutomatico;
    protected int cambio;

    public Caminhao(int motor, int freio, boolean cambioAutomatico) {
        super(motor, freio);
        this.cambioAutomatico = cambioAutomatico;
        this.freioDeMao = true;
        this.cambio = 0;
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
                    if (this.velocidade < 20)
                        this.velocidade += this.motor;
                    break;
                case 2:
                    if (this.velocidade < 40)
                        this.velocidade += this.motor;
                    break;
                case 3:
                    if (this.velocidade < 60)
                        this.velocidade += this.motor;
                    break;
                case 4:
                    if (this.velocidade < 80)
                        this.velocidade += this.motor;
                    break;
                case 5:
                    if (this.velocidade < 100)
                        this.velocidade += this.motor;
                    break;
                case 6:
                    if (this.velocidade < 120) {
                        this.velocidade += this.motor;
                    }
                    break;
                case 7:
                    if (this.velocidade < 140) {
                        this.velocidade += this.motor;
                    }
                    break;
                case 8:
                    if (this.velocidade < 200) {
                        this.velocidade += this.motor;
                    }
                    break;
            }
            acelerar(tempo - 1);
        } else if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == true) {
            this.velocidade += this.motor * 1;
            acelerar(tempo - 1);
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
}
