package prPractica01;

import java.util.Scanner;

/**
 * 20.- Un biólogo está realizando un estudio de distintas especies de invertebrados y necesita una aplicación
		que le ayude a contabilizar el número de patas que tienen en total todos los animales capturados
		durante una jornada de trabajo. Para ello, nos ha solicitado una aplicación a la que hay que
		proporcionar:
			• El número de hormigas capturadas (6 patas).
			• El número de arañas capturadas (8 patas).
			• El número de cochinillas capturadas (14 patas).
			
		La aplicación debe mostrar el número total de patas.
 */

public class Ejercicioo20 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final int PATASHORMIGAS = 6;
		final int PATASARANIAS = 8;
		final int PATASCOCHINILLAS = 14;
		
		int numHormigas,numAranias,numCochinillas;
		int totalPatasHormigas,totalPatasAranias,totalPatasCochinillas,totalTotal;
		
		System.out.print("Introduce el número de hormigas: ");
		numHormigas=sc.nextInt();
		System.out.print("Introduce el número de arañas: ");
		numAranias=sc.nextInt();
		System.out.print("Introduce el número de cochinillas: ");
		numCochinillas=sc.nextInt();
		
		totalPatasHormigas=numHormigas*PATASHORMIGAS;
		totalPatasAranias=numAranias*PATASARANIAS;
		totalPatasCochinillas=numCochinillas*PATASCOCHINILLAS;
		
		totalTotal=totalPatasHormigas+totalPatasAranias+totalPatasCochinillas;
		
		System.out.println("\nTotal de patas de hormigas: " + totalPatasHormigas);
		System.out.println("Total de patas de arañas: " +  totalPatasAranias);
		System.out.println("Total de patas de cochinillas: " +  totalPatasCochinillas);
		System.out.println("\nTotal de patas general: " + totalTotal);
		
		sc.close();
		
	}

}
