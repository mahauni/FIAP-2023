public class Carro extends Veiculo {
    private boolean freioDeMao;
    private int cambio;
    private boolean cambioAutomatico;

    public Carro(int motor, int freio, boolean cambioAutomatico) {
        super(motor, freio);
        this.freioDeMao = true;
        this.cambio = 0;
        this.cambioAutomatico = cambioAutomatico;
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

    @Override
    public void acelerar(int tempo) {
        if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == false) {
            switch (this.cambio) {
                case 1:
                    if (this.velocidade < 30)
                        this.velocidade += this.motor * 2;
                    break;
                case 2:
                    if (this.velocidade < 60)
                        this.velocidade += this.motor * 2;
                    break;
                case 3:
                    if (this.velocidade < 90)
                        this.velocidade += this.motor * 2;
                    break;
                case 4:
                    if (this.velocidade < 120)
                        this.velocidade += this.motor * 2;
                    break;
                case 5:
                    if (this.velocidade < 150)
                        this.velocidade += this.motor * 2;
                    break;
                case 6:
                    if (this.velocidade < 180) {
                        this.velocidade += this.motor * 2;
                    }
                    break;
                case 7:
                    if (this.velocidade < 240) {
                        this.velocidade += this.motor * 2;
                    }
                    break;
            }
            acelerar(tempo - 1);
        } else if (isOn() && tempo > 0 && !freioDeMaoAtivado() && this.cambio > 0 && cambioAutomatico == true) {
            this.velocidade += this.motor * 2;
            acelerar(tempo - 1);
        }
    }
}
