package prExamenAnioPasado;

import java.util.Scanner;

/**
 * Diseña un programa que permita registrar las temperaturas máximas diarias de una ciudad durante un mes (30 días). El programa debe:
 * 		Solicitar al usuario las temperaturas día por día.
		
		Calcular y mostrar:
			La temperatura media del mes.
			
			El día con la temperatura más alta y el día con la más baja.
			
			Cuántos días superaron los 35 °C (días de ola de calor).
			
			Cuántos días estuvieron por debajo de 10 °C (días fríos).
			
			Mostrar una advertencia si hay más de 5 días de ola de calor consecutivos.
 */

public class Ejercicio5RepasoExamen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		revisar
		
		final int DIAS=5;
		int contDias=1,temperatura,temperaturaMedia=0,temperaturaMax,temperaturaMin,contDiasOlaCalor=0,contDiasFrios=0,contAdvertencia=0;
		boolean advertencia=false;

		System.out.print("Día " + contDias + " - Introduce la temperatura máxima diaria: ");
		temperatura=sc.nextInt();
		
		temperaturaMax=temperatura;
		temperaturaMin=temperatura;
		
		while (contDias<DIAS) {
			
			temperaturaMedia+=temperatura;
			
			if (temperatura>temperaturaMax) {
				temperaturaMax=temperatura;
			}
			
			if (temperatura<temperaturaMin) {
				temperaturaMin=temperatura;
			}
			
			if (temperatura>35) {
				contDiasOlaCalor++;
				contAdvertencia++;
			}
			else {
				contAdvertencia=0;
			}
			
			if (contAdvertencia>=5) {
				advertencia=true;
			}
			else {
				advertencia=false;
			}
			
			if (temperatura<10) {
				contDiasFrios++;
			}
			
			contDias++;
			
			System.out.print("Día " + contDias + " - Introduce la temperatura máxima diaria: ");
			temperatura=sc.nextInt();
		}

		temperaturaMedia=temperaturaMedia/contDias;
		
		System.out.println("\nTemperatura media: " + temperaturaMedia + "ºC");
		System.out.println("Temperatura más alta: " + temperaturaMax + "ºC");
		System.out.println("Temperatura más baja: " + temperaturaMin + "ºC");
		System.out.println("Número de días que superaron los 35 °C (días de ola de calor): " + contDiasOlaCalor + " días");
		System.out.println("Número de días que estuvieron por debajo de 10 °C (días fríos): " + contDiasFrios + " días");
		
		if (advertencia=true) {
			System.out.println("ADVERTENCIA: " + advertencia + " - 5 días de ola de calor consecutivos");
		}
		
		sc.close();
	}

}
