package prPractica02;

import java.util.Scanner;

/**
 * 40. Introducir un número desde teclado y desglosarlo de forma ideal en billetes y monedas de curso legal,
	   es decir, con el mínimo número de billetes y monedas.
 */

public class Ejercicioo40 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double cantidad;
		int euros,centimos;
		int cont500=0,cont200=0,cont100=0,cont50=0,cont20=0,cont10=0,cont5=0,cont2=0,cont1=0;
		int contCent50=0,contCent20=0,contCent10=0,contCent5=0,contCent2=0,contCent1=0;

		System.out.print("Introduce la cantidad a desglosar: ");
		cantidad=sc.nextDouble();

		euros=(int)cantidad;
		centimos=(int) Math.round((cantidad - euros) * 100);

		System.out.println("Euros: " + euros + " \nCéntimos: " + centimos);

		while (euros>0) {

			// EUROS
			if (euros>=500) { // BILLETES DE 500€
				euros-=500;
				cont500++;
			}
			else if (euros>=200) { // BILLETES DE 200€
				euros-=200;
				cont200++;
			}
			else if (euros>=100) { // BILLETES DE 100€
				euros-=100;
				cont100++;
			}
			else if (euros>=50) { // BILLETES DE 50€
				euros-=50;
				cont50++;
			}
			else if (euros>=20) { // BILLETES DE 20€
				euros-=20;
				cont20++;
			}
			else if (euros>=10) { // BILLETES DE 10€
				euros-=10;
				cont10++;
			}
			else if (euros>=5) { // BILLETES DE 5€
				euros-=5;
				cont5++;
			}
			else if (euros>=2) { // MONEDAS DE 2€
				euros-=2;
				cont2++;
			}
			else if (euros>=1) { // MONEDAS DE 1€
				euros-=1;
				cont1++;
			}
		}

		while (centimos>0) {

			// CÉNTIMOS
			if (centimos>=50) { // MONEDAS DE 50 CENTS
				centimos-=50;
				contCent50++;
			}
			else if (centimos>=20) { // MONEDAS DE 20 CENTS
				centimos-=20;
				contCent20++;
			}
			else if (centimos>=10) { // MONEDAS DE 10 CENTS
				centimos-=10;
				contCent10++;
			}
			else if (centimos>=5) { // MONEDAS DE 5 CENTS
				centimos-=5;
				contCent5++;
			}
			else if (centimos>=2) { // MONEDAS DE 2 CENTS
				centimos-=2;
				contCent2++;
			}
			else if (centimos>=1) { // MONEDAS DE 1 CENTS
				centimos-=1;
				contCent1++;
			}
		}

		System.out.println(); // Salto de línea

		if (cont500 > 0) {
			System.out.println(cont500 + " billetes de 500€");
		}
		if (cont200 > 0) {
			System.out.println(cont200 + " billetes de 200€");
		}
		if (cont100 > 0) {
			System.out.println(cont100 + " billetes de 100€");
		}
		if (cont50 > 0) {
			System.out.println(cont50 + " billetes de 50€");
		}
		if (cont20 > 0) {
			System.out.println(cont20 + " billetes de 20€");
		}
		if (cont10 > 0) {
			System.out.println(cont10 + " billetes de 10€");
		}
		if (cont5 > 0) {
			System.out.println(cont5 + " billetes de 5€");
		}
		if (cont2 > 0) {
			System.out.println(cont2 + " monedas de 2€");
		}
		if (cont1 > 0) {
			System.out.println(cont1 + " monedas de 1€");
		}
		if (contCent50 > 0) {
			System.out.println(contCent50 + " monedas de 50 céntimos");
		}
		if (contCent20 > 0) {
			System.out.println(contCent20 + " monedas de 20 céntimos");
		}
		if (contCent10 > 0) {
			System.out.println(contCent10 + " monedas de 10 céntimos");
		}
		if (contCent5 > 0) {
			System.out.println(contCent5 + " monedas de 5 céntimos");
		}
		if (contCent2 > 0) {
			System.out.println(contCent2 + " monedas de 2 céntimos");
		}
		if (contCent1 > 0) {
			System.out.println(contCent1 + " monedas de 1 céntimo");
		}

		sc.close();

	}
}
