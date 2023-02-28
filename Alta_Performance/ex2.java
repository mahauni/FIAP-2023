package Alta_Performance;

import java.util.Scanner;

public class ex2 {

	public static final int N = 30;
	
	public static void main(String[] args) {
		int rm[] = new int[N];
		double nota1[] = new double[N];
		double nota2[] = new double[N];
		double media[] = new double[N];
		int aprovados[] = new int[N];
		
		int n = entradaDados(rm, nota1, nota2);

        calculaMedia(n, nota1, nota2, media);
        System.out.println("\n\n Medias dos Alunos");
        for (int i = 0; i < n; i += 1) {
            System.out.println("RM: "+ rm[i] +"\t Media: "+ media[i]);
        }

        int nAp = geraListaAprovados(n, media, rm, aprovados);
        System.out.println("\n\n Lista de Aprovados");
		for (int i=0; i<nAp;i++)
			System.out.println("RM: "+ aprovados[i]);
    }
	
	public static int entradaDados(int rm[], double nota1[], double nota2[]) {
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
		return n;
	}

    public static void calculaMedia(int n, double nota1[], double nota2[], double media[]) {
        for (int i = 0; i < n; i += 1) {
            media[i] = (nota1[i] + nota2[i]) / 2;
        }
    }

    public static int geraListaAprovados(int n, double media[], int rm[], int aprovados[]) {
        int nAp =0; // quantidade de alunos aprovados
        for (int i=0; i<n; i++) {
			if (media[i] >= 6) {
				aprovados[nAp] = rm[i];
				nAp++;
			}
		}
        
        return nAp;
    }

}

