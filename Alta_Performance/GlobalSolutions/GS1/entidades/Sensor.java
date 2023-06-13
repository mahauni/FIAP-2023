package entidades;

import java.util.Arrays;

public class Sensor {
    private int id;
    private String coordenada;
    private float PH;
    private int umidade;
    private float salinidade;
    private float[] nutrientes;

    public Sensor(int id, String coordenada, float PH, int umidade, float salinidade, float[] nutrientes) {
        this.id = id;
        this.coordenada = coordenada;
        this.PH = PH;
        this.umidade = umidade;
        this.salinidade = salinidade;
        this.nutrientes = nutrientes;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public boolean getPhPrint() {
        switch (compare(6, 7, this.PH)) {
            case -1: {
                System.out.println("O pH do solo esta muito baixo!");
                return false;
            }
            case 0: {
                System.out.println("O pH do solo esta em um nivel bom!");
                return true;
            }
            case 1: {
                System.out.println("o pH do solo esta muito alto!");
                return false;
            }
        }
        return false;
    }

    public void setPH(float PH) {
        this.PH = PH;
    }

    public boolean getUmidadePrint() {
        switch (compare(18, 23, this.umidade)) {
            case -1: {
                System.out.println("O solo esta com uma umidade baixa para a coleta do arroz!");
                return false;
            }
            case 0: {
                System.out.println("O solo esta muito umido para a coleta do arroz!");
                return false;
            }
            case 1: {
                System.out.println("O solo esta com uma boa umidade para a coleta do arroz!");
                return true;
            }
        }

        return false;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public boolean getSalinidadePrint() {
        switch (compare(0.25F, 0.35F, this.salinidade)) {
            case -1: {
                System.out.println("A salinidade do solo está em um nivel bom!");
                return true;
            }
            case 0: {
                System.out.println("A salinidade do solo esta um pouco alta, mas não esta em niveis perigosos!");
                return true;
            }
            case 1: {
                System.out.println("A salinidade do solo esta muito alta!");
                return false;
            }
        }

        return false;
    }

    public void setSalinidade(float salinidade) {
        this.salinidade = salinidade;
    }

    public boolean[] getNutrientesPrint() {
        boolean[] verified = new boolean[5];

        // Ca: Calcio
        switch (compare(0.05F, 0.2F, this.nutrientes[0])) {
            case -1: {
                System.out.println("O nivel de calcio no solo está muito baixo!");
                verified[0] = false;
                break;
            }
            case 0: {
                System.out.println("O nivel de calcio no solo está em um nivel bom!");
                verified[0] = true;
                break;
            }
            case 1: {
                System.out.println("O nivel de calcio no solo está em um nivel elevado, reduça o mais rapido possivel!");
                verified[0] = false;
                break;
            }
        }

        // Mg: Magnesio
        switch (compare(0.2F, 0.5F, this.nutrientes[1])) {
            case -1: {
                System.out.println("O nivel de magnesio no solo está muito baixo!");
                verified[1] = false;
                break;
            }
            case 0: {
                System.out.println("O nivel de magnesio no solo esta em um nivel bom!");
                verified[1] = true;
                break;
            }
            case 1: {
                System.out.println("O nivel de magnesio no solo esta em um nivel elevado, reduça o mais rapido possivel!");
                verified[1] = false;
                break;
            }
        }

        // N: Nitrogenio
        switch (compare(40, 60, this.nutrientes[2])) {
            case -1: {
                System.out.println("O solo não contem Nitrogenio suficiente!");
                verified[2] = false;
                break;
            }
            case 0: {
                System.out.println("O solo contem uma boa quantidade de Nitrogenio!");
                verified[2] = true;
                break;
            }
            case 1: {
                System.out.println("O solo contem uma quantidade extremamente perigosa de Nitrogenio, diminua!");
                verified[2] = false;
                break;
            }
        }

        // P: Fosforo
        switch (compare(3F, 6F, this.nutrientes[3])) {
            case -1: {
                System.out.println("O nivel de fosforo no solo esta muito baixo!");
                verified[3] = false;
                break;
            }
            case 0: {
                System.out.println("O nivel de fosforo no solo esta em um nivel bom!");
                verified[3] = true;
                break;
            }
            case 1: {
                System.out.println("O nivel de fosforo no solo esta em um nivel elevado, reduça o mais rapido possivel!");
                verified[3] = false;
                break;
            }
        }

        // K: Potassio
        switch (compare(20, 60, this.nutrientes[4])) {
            case -1: {
                System.out.println("O solo não contem Potassion suficiente!");
                verified[4] = false;
                break;
            }
            case 0: {
                System.out.println("O solo contem uma boa quantidade de Potassio!");
                verified[4] = true;
                break;
            }
            case 1: {
                System.out.println("O solo contem uma quantidade extremamente perigosa de Potassio, diminua!");
                verified[4] = false;
                break;
            }
        }

        return verified;
    }

    public void setNutrientes(float[] nutrientes) {
        this.nutrientes = nutrientes;
    }

    public float getPH() {
        return PH;
    }

    public int getUmidade() {
        return umidade;
    }

    public float getSalinidade() {
        return salinidade;
    }

    public float[] getNutrientes() {
        return nutrientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int compare(float min, float max, float val) {
        if (val < min) {
            return -1;
        }
        if (val <= max) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Sensor { " +
                "id=" + id +
                ", coordenada='" + coordenada + '\'' +
                ", PH=" + PH +
                ", umidade=" + umidade +
                ", salinidade=" + salinidade +
                ", nutrientes=" + Arrays.toString(nutrientes) +
                " }";
    }
}
