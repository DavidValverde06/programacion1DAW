package prExamenAnioPasado;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int edad,contJuvenil=0,contPromesa=0,contSenior=0,contVetA=0,contVetB=0,contVetC=0;

		System.out.print("Indique su edad para inscribirse: ");
		edad=sc.nextInt();

		while (edad>0) {

			if (edad<18){
				System.out.println("No pueden inscribirse menores de edad");
			}
			else if (edad<=22) {
				contJuvenil++;
			}
			else if (edad<=30) {
				contPromesa++;
			}
			else if (edad<=39) {
				contSenior++;
			}
			else if (edad<=49) {
				contVetA++;
			}
			else if (edad<=59) {
				contVetB++;
			}
			else {
				contVetC++;
			}

			System.out.print("Indique su edad para inscribirse: ");
			edad=sc.nextInt();
		}

		if (contJuvenil>0)
			System.out.println("\nJunior: " + contJuvenil + " corredores");
		else
			System.out.println("\nJunior: Ningún inscrito");

		if (contPromesa>0)
			System.out.println("Promesa: " + contPromesa + " corredores");
		else
			System.out.println("Promesa: Ningún inscrito");

		if (contSenior>0)
			System.out.println("Senior: " + contSenior + " corredores");
		else
			System.out.println("Senior: Ningún inscrito");

		if (contVetA>0)
			System.out.println("Veterano A: " + contVetA + " corredores");
		else
			System.out.println("Veterano A: Ningún inscrito");

		if (contVetB>0)
			System.out.println("Veterano B: " + contVetB + " corredores");
		else
			System.out.println("Veterano B: Ningún inscrito");

		if (contVetC>0)
			System.out.println("Veterano C: " + contVetC + " corredores");
		else
			System.out.println("Veterano C: Ningún inscrito");

		sc.close();
	}

}
