package marchas;

public class CarroMarcha implements interfaces.Marcha {
    @Override
    public int marcha(int marcha, int velocidade, int motor) {
        if (velocidade < 30 * marcha) {
            if (velocidade + motor * 2 > 30 * marcha) {
                velocidade = 30 * marcha;
            } else
                velocidade += motor * 2;
        }
        return velocidade;
    }
}
