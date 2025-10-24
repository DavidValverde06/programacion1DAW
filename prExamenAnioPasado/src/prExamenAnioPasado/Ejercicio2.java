package prExamenAnioPasado;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float coste=0,numInvitados,costeCakePops=0,costeDonuts=0;
		char cakePops,donuts,fuenteChocolate;
		boolean cakePopsBoolean=true,donutsBoolean=true,fuenteChocolateBoolean=true;
		final int COSTEMONTAJE = 80;
		final int COSTEFUENTE = 100;

		System.out.print("Indique el número de invitados al evento: ");
		numInvitados=sc.nextInt();

		coste+=COSTEMONTAJE; // Coste del montaje son 80€

		coste+=numInvitados; // Por cada invitado, se cobrara 1€

		System.out.print("¿Desea añadir cake pops? ");
		cakePops=sc.next().charAt(0);

		if (cakePops=='s') {
			cakePopsBoolean=true;

			for (int cont=0;cont<numInvitados;cont++) {
				costeCakePops+=0.25f;
			}

			coste+=costeCakePops;
		}
		else if (cakePops=='n') {
			cakePopsBoolean=false;
		}

		System.out.print("¿Desea añadir donuts? ");
		donuts=sc.next().charAt(0);

		if (donuts=='s') {
			donutsBoolean=true;

			for (int cont=0;cont<numInvitados;cont++) {
				costeDonuts+=0.30f;
			}

			coste+=costeDonuts;
		}
		else if (donuts=='n') {
			donutsBoolean=false;
		}

		System.out.print("¿Desea añadir una fuente? ");
		fuenteChocolate=sc.next().charAt(0);

		if (fuenteChocolate=='s') {
			fuenteChocolateBoolean=true;

			coste+=COSTEFUENTE;
		}
		else if (fuenteChocolate=='n') {
			fuenteChocolateBoolean=false;
		}

		System.out.println("\nEL COSTE TOTAL DE LA MESA ASCIENDE A: " + coste + "€");

		System.out.println("\tCoste montaje: " + COSTEMONTAJE + "€");
		System.out.println("\tNúmero de invitados: " + (int)numInvitados);
		if (cakePopsBoolean) {
			System.out.println("\tCake pops: SI");

		}
		else {
			System.out.println("\tCake pops: NO");
		}
		
		if (donutsBoolean) {
			System.out.println("\tDonuts: SI");
		}
		else {
			System.out.println("\tDonuts: NO");
		}
		
		if (fuenteChocolateBoolean) {
			System.out.println("\tFuente chocolate: SI");
		}
		else {
			System.out.println("\tFuente chocolate: NO");
		}

		sc.close();
	}

}
