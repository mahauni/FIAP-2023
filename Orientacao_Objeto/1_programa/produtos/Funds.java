package produtos;

import interfaces.Produto;

public class Funds implements Produto {

    @Override
    public double investir(double valor) {
        return valor * 1.05;
    }
    
}
