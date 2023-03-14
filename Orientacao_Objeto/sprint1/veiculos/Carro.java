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
                    if (this.getVelocidade() < 30) {
                        if (this.velocidade + this.motor * 2 > 30) {
                            this.velocidade = 30;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
                case 2:
                    if (this.velocidade < 60) {
                        if (this.velocidade + this.motor * 2 > 60) {
                            this.velocidade = 60;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
                case 3:
                    if (this.velocidade < 90) {
                        if (this.velocidade + this.motor * 2 > 90) {
                            this.velocidade = 90;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
                case 4:
                    if (this.velocidade < 120) {
                        if (this.velocidade + this.motor * 2 > 120) {
                            this.velocidade = 120;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
                case 5:
                    if (this.velocidade < 150) {
                        if (this.velocidade + this.motor * 2 > 150) {
                            this.velocidade = 150;
                        } else
                            this.velocidade += this.motor * 2;
                    }
                    break;
                case 6:
                    if (this.velocidade < 180) {
                        if (this.velocidade + this.motor * 2 > 180) {
                            this.velocidade = 180;
                        } else
                            this.velocidade += this.motor * 2;
                    }
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
            freioDeMaoActivate();
            System.out.println("O freio de mao foi ativado");
        }
        // tem que ativar o carro quando acelerar quando o carro tentou acelerar e estiver desligado
    }
}
