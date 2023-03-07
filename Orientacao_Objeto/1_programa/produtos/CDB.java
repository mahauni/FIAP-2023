package produtos;

import interfaces.Produto;

public class CDB implements Produto {

    @Override
    public double investir(double valor) {
        return valor * 1.01;
    }
    
}
