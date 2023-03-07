package Alta_Performance;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {

		final int N = 30;
		int rm[] = new int[N];
		double nota1[] = new double[N];
		double nota2[] = new double[N];
		double media[] = new double[N];
		int aprovados[] = new int[N];
		int n=0; //quantidade de alunos  cadastrados
	
		Scanner le = new Scanner(System.in);
		System.out.print("Digite -1 para finalizar cadastro ou RM: ");
		int aux = le.nextInt();
		while (aux>0 && n<N) {
			rm[n] = aux;
			System.out.print("\t Nota1: ");
			nota1[n] = le.nextDouble();
			System.out.print("\t Nota2: ");
			nota2[n] = le.nextDouble();
			n++;
			System.out.print("Digite -1 para finalizar cadastro ou RM: ");
			aux = le.nextInt();
		}
		le.close();
		
		System.out.println("\n\n Medias dos Alunos");
		for (int i=0; i<n; i++) {
			media[i] = (nota1[i] + nota2[i]) / 2;
			System.out.println("RM: "+ rm[i] +"\t Media: "+ media[i]);
		}
		
		int nAp =0; // quantidade de alunos aprovados
		for (int i=0; i<n; i++) {
			if (media[i] >= 6) {
				aprovados[nAp] = rm[i];
				nAp++;
			}
		}
		
		System.out.println("\n\n Lista de Aprovados");
		for (int i=0; i<nAp;i++)
			System.out.println("RM: "+ aprovados[i]);
	}

}