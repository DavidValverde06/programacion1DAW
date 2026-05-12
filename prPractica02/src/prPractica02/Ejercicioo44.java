package prPractica02;

import java.util.Scanner;

/**
 * 44. Introducir la nota de una asignatura por teclado, que esté comprendida entre 0 y 10 y escribir la nota
	   en letra, atendiendo a:
	   
	    0 > Nota < 3 Muy deficiente
		3 >= Nota < 5 Insuficiente
		5 >= Nota < 6 Suficiente
		6 >= Nota < 7 Bien
		7 >= Nota < 9 Notable
		9 >= Nota =< 10 Sobresaliente
 */

public class Ejercicioo44 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int nota;
		
		System.out.print("Introduce la nota: ");
		nota=sc.nextInt();
		
		if (nota<0||nota>10) {
			System.out.println("ERROR. Nota no válida");
		}
		else if (nota<3) {
			System.out.println("Muy deficiente");
		}
		else if (nota<5) {
			System.out.println("Insuficiente");
		}
		else if (nota<6) {
			System.out.println("Suficiente");
		}
		else if (nota<7) {
			System.out.println("Bien");
		}
		else if (nota<9) {
			System.out.println("Notable");
		}
		else {
			System.out.println("Sobresaliente");
		}
		
		sc.close();
	}

}
