package excelTesteMesa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	// adiciona as novas variaveis junto com os valores inseridos.
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira os valores, respectivamente, da E1, P1, E2, API.");
 
        double E1 = scan.nextDouble();

        double P1 = scan.nextDouble();

        double E2 = scan.nextDouble();

        double api = scan.nextDouble();

        System.out.println("Agora insira as notas extras e da avaliação substitutiva, respectivamente. ");
        double X = scan.nextDouble();

        double SUB = scan.nextDouble();


        double soma = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X + (SUB * 0.15);
        double MEDI = soma * 0.5;

        double NUM = Math.max(soma - 5.9, 0);
        double denominador = soma - 5.9;
        if (denominador != 0) {
         double	somaApi = (NUM / denominador) * api * 0.5;
         double MED = MEDI + somaApi;
         System.out.println("Sua média é: " + MED);
        }

        

        
    }
}
