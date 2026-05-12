package ejemplos;

import java.util.Scanner;

/**
 * Programa que si el dia de la semana es de lunes a viernes nos diga "Dia laborable" y si es sabado o domingo, me dirá "Fin de semana"
 */

public class EjemploSwitch2 {

	public static void main(String[] args) {

		byte diaSemana;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Día de la semana: ");
			diaSemana=sc.nextByte();
		}

		switch (diaSemana) {
		case 1 -> {
			System.out.println("Lunes");
			System.out.println("Laborable");
		}
		case 2 -> {
			System.out.println("Martes");
			System.out.println("Laborable");
		}
		case 3 -> {
			System.out.println("Miercoles");
			System.out.println("Laborable");
		}
		case 4 -> {
			System.out.println("Jueves");
			System.out.println("Laborable");
		}
		case 5 -> {
			System.out.println("Viernes");
			System.out.println("Laborable");
		}
		case 6 -> {
			System.out.println("Sabado");
			System.out.println("Fin de semana");
		}
		case 7 -> {
			System.out.println("Domingo");
			System.out.println("Fin de semana");
		}
		default ->
		System.out.println("Día no válido");
		}

		System.out.println("-----------");
		
		switch (diaSemana) {
		case 1,2,3,4,5 ->	System.out.println("Laborable");
		case 6,7 ->	System.out.println("Fin de semana");
		default ->	System.out.println("Error");
		}
	}

}
