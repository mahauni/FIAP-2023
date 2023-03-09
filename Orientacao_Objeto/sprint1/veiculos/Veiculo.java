public abstract class Veiculo {
    protected int motor;
    protected int freio;
    protected boolean activated;
    protected int cambio;
    protected int velocidade;

    public Veiculo(int motor, int freio) {
        this.motor = motor;
        this.freio = freio;
        this.activated = false;
        this.cambio = 0;
        this.velocidade = 0;
    }

    public void ligar() {
        if (!isOn())
            this.activated = true;
        else
            System.out.println("O carro ja esta ligado!");    
    }
    public void desligar() {
        if (isOn())
            this.activated = false;
        else
            System.out.println("O carro ja esta desligado!");    
    }
    public boolean isOn() {
        if (this.activated == true)
            return true;
        return false;
    }
    public void freiar(int tempo) {
        if (isOn() && tempo > 0 && this.velocidade > 0) {
            if (this.velocidade < this.freio) {
                this.velocidade = 0;
                return;
            }
            this.velocidade -= this.freio;
            freiar(tempo - 1);
        }
    }
    public void aumentarCambio() {
        if (isOn() && this.cambio < 7)
            this.cambio += 1;        
    }
    // Moto nao tem Ré que seria o nosso cambio ao -1
    public void diminuirCambio() {
        if (isOn() && this.cambio > -2)
            this.cambio -= 1;
    }
    public abstract void acelerar(int tempo);
    

    public int getCambio() {
        return cambio;
    }
    public int getVelocidade() {
        return velocidade;
    }    
}
