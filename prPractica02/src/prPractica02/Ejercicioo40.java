package prPractica02;

import java.util.Scanner;

/**
 * 40. Introducir un número desde teclado y desglosarlo de forma ideal en billetes y monedas de curso legal,
	   es decir, con el mínimo número de billetes y monedas.
 */

public class Ejercicioo40 {

	public static void main(String[] args) {

		sin hacer pereza
		
		Scanner sc = new Scanner(System.in);

		float cantidad,billetes500=0;

		System.out.print("Introduce la cantidad a desglosar: ");
		cantidad=sc.nextFloat();

		while (cantidad!=0) {
			if (cantidad>500) { // BILLETES DE 500€
				cantidad=cantidad-500;
				billetes500++;
			}
			else if (cantidad>200) { // BILLETES DE 200€

			}
			else if (cantidad>100) { // BILLETES DE 100€

			}
			else if (cantidad>50) { // BILLETES DE 50€

			}
			else if (cantidad>20) { // BILLETES DE 20€

			}
			else if (cantidad>10) { // BILLETES DE 10€

			}
			else if (cantidad>5) { // BILLETES DE 5€

			}
			else if (cantidad>2) { // MONEDAS DE 2€

			}
			else if (cantidad>1) { // MONEDAS DE 1€

			}
			else if (cantidad>0.50) { // MONEDAS DE 50 CENTS

			}
			else if (cantidad>0.20) { // MONEDAS DE 20 CENTS

			}
			else if (cantidad>0.10) { // MONEDAS DE 10 CENTS

			}
			else if (cantidad>0.05) { // MONEDAS DE 5 CENTS

			}
			else if (cantidad>0.02) { // MONEDAS DE 2 CENTS

			}
			else if (cantidad>0.01) { // MONEDAS DE 1 CENTS

			}
		
		}
		
		System.out.println("Billetes de 500€: " + billetes500);

		sc.close();
	}

}
