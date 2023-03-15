package veiculos;

public abstract class Veiculo {
    protected int motor;
    protected int freio;
    protected boolean activated;
    protected int velocidade;

    protected String placa;
    protected String marca;
    protected String modelo;

    public Veiculo(int motor, int freio, String placa, String marca, String modelo) {
        this.motor = motor;
        this.freio = freio;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.activated = false;
        this.velocidade = 0;
    }

    public void ligar() {
        if (!isOn()) {
            this.activated = true;
            System.out.println("O carro foi ligado!");
        } else
            System.out.println("O carro ja esta ligado!");    
    }
    public void desligar() {
        if (isOn()) {
            this.activated = false;
            System.out.println("O carro foi desligado!");
        } else
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

    public abstract void acelerar(int tempo);
    

    public int getVelocidade() {
        return velocidade;
    }
}
