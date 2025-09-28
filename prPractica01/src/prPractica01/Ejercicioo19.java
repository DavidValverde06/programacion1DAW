package prPractica01;

import java.util.Scanner;

/**
 * 19.- Convertir un tiempo expresado en segundos a un formato que lo represente a horas, minutos y
		segundos.

 */

public class Ejercicioo19 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int segundos,minutos,horas;
		
		System.out.print("Introduce un número (en segundos): ");
		
		segundos=sc.nextInt();
		
		horas=segundos/3600;
		minutos = (segundos % 3600) / 60;
		segundos=segundos%60;
		
		System.out.println(horas + " horas " + minutos + " minutos " + segundos + " segundos");
		
		sc.close();
	}

}
