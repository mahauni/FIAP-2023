package aplicacao;

import entidades.Sensor;
import filas.FilaSensor;
import listas.ListaCrescente;

import java.util.Random;
import java.util.Scanner;

public class Monitora {
	static Random gerador = new Random();
	static FilaSensor sensores = new FilaSensor();
	static ListaCrescente sensoresUmidade = new ListaCrescente();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// init();
		int option;
		app: while (true) {
			menu();
			option = Integer.parseInt(sc.nextLine());

			switch (option) {
				case 1: {
					loadData();
					break;
				}
				case 2: {
					createSensor();
					break;
				}
				case 3: {
					sensoresUmidade.verificar(sensores);
					break;
				}
				case 4: {
					acharSensorPreMade();
					break;
				}
				case 5: {
					acharSensor();
					break;
				}
				case 6: {
					sensores.traverse();
					break;
				}
				case 7: {
					search();
					break;
				}
				case 0: {
					break app;
				}
				default: {
					System.out.println("Not available command, try another one.");
					break;
				}
			}
		}
	}

	public static void search() {
		System.out.println("Digite qual sensor que voce quer buscar:");
		int n = Integer.parseInt(sc.nextLine());
		sensores.get(n);
	}

	public static void acharSensorPreMade() {
		System.out.println(sensoresUmidade.procura("47o55’44”W,21o00’39”S")); // existe
		sensoresUmidade.procura("47o55’44”W,21o00’39”N"); // nao existe
	}

	public static void acharSensor() {
		Sensor found = sensoresUmidade.procura(sc.nextLine());
		if (found != null) {
			System.out.println(found.getCoordenada());
		}
	}

	public static void menu() {
		System.out.println("-------- WHAT DO YOU WANT TO DO --------");
		System.out.println("1. Load data");
		System.out.println("2. Criar um sensor");
		System.out.println("3. Verificar os sensores na lista");
		System.out.println("4. Achar o sensor (pre-made)");
		System.out.println("5. Achar o sensor");
		System.out.println("6. Atraversar todo os sensores ruins");
		System.out.println("7. Procurar 1 sensor ruim");
		System.out.println("0. Exit program");
		System.out.print("Type the number: ");
	}

	public static void loadData() {
		String[] coordenadasSensores = { "47o55’44”W,21o00’34”S", "47o55’42”W,21o00’35”S", "47o55’39”W,21o00’37”S",
				"47o55’44”W,21o00’39”S", "47o55’40”W,21o00’40”S", "47o55’32”W,21o00’34”S", "47o55’28”W,21o00’34”S",
				"47o55’28”W,21o00’38”S", "47o55’33”W,21o00’39”S", "47o55’27”W,21o00’34”S", "47o55’27”W,21o00’33”S",
				"47o55’36”W,21o00’33”S", "47o55’41”W,21o00’30”S", "47o55’41”W,21o00’37”S", "47o55’33”W,21o00’38”S",
				"47o55’34”W,21o00’29”S", "47o55’32”W,21o00’31”S" };
		int n = coordenadasSensores.length;

		System.out.println(" Coordenadas Iniciais");
		for (int i = 0; i < n; i++) {
			System.out.println("Sensor " + i + ": " + coordenadasSensores[i]);
			// load the FilaSensor with random data
			int u = gerador.nextInt(10) + 15;
			float pH = round(getRandomNumber(5.5F, 7.5F));
			float sal = round(getRandomNumber(0F, 0.5F));
			float Ca = round(getRandomNumber(0.02F, 0.25F));
			float Mg = round(getRandomNumber(0.15F, 0.6F));
			float N = round(getRandomNumber(35F, 65F));
			float P = round(getRandomNumber(2F, 7F));
			float K = round(getRandomNumber(15F, 65F));
			float[] nutr = {Ca, Mg, N, P, K};
			Sensor sensor = new Sensor(i, coordenadasSensores[i], pH, u, sal, nutr);
			sensoresUmidade.insere(sensor);
		}
	}

	public static void createSensor() {
		System.out.println("Digite as coordenadas");
		String coord = sc.nextLine();
		System.out.println("Digite a umidade");
		int umi = Integer.parseInt(sc.nextLine());
		System.out.println("Digite o pH");
		float ph = Float.parseFloat(sc.nextLine());
		System.out.println("Digite a salinidade");
		float sal = Float.parseFloat(sc.nextLine());
		System.out.println("Digite os nutrientes no solo");
		System.out.println("Digite a quantidade de Fosforo");
		float Mg = Float.parseFloat(sc.nextLine());
		System.out.println("Digite a quantidade de Calcio");
		float Ca = Float.parseFloat(sc.nextLine());
		System.out.println("Digite a quantidade de Nitrogenio");
		float N = Float.parseFloat(sc.nextLine());
		System.out.println("Digite a quantidade de Magnesio");
		float P = Float.parseFloat(sc.nextLine());
		System.out.println("Digite a quantidade de Potassio");
		float K = Float.parseFloat(sc.nextLine());

		Sensor sensor = new Sensor(sensoresUmidade.contaNos(), coord, ph, umi, sal, new float[]{Ca, Mg, N, P, K});

		sensoresUmidade.insere(sensor);
	}

	public static float round(float f) {
		return (float) (Math.round(f*100.0)/100.0);
	}

	public static float getRandomNumber(float min, float max) {
		return (float) ((Math.random() * (max - min)) + min);
	}
}