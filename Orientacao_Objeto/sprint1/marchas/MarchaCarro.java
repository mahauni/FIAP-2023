package marchas;

import interfaces.Marcha;


// TERMINAR ESSA INTERFACE TALVEZ IMPLEMENTAR RÉ MAS TALVEZ NAO DA
public class MarchaCarro implements Marcha {
    @Override
    public void marcha(int marcha, int velocidade, int motor) {
        if (velocidade < 30) {
            if (velocidade + motor * 2 > 30) {
                velocidade = 30;
            } else
                velocidade += motor * 2;
        }
    }   
}

// O QUE EU QUERO FAZER COM ISSO
// FAZER A MARCHA AUTOMATICA DA PRA FAZER;
// DA PARA VERIFICAR AUTOMATICAMENTE?
