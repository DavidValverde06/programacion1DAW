package ejemplos;

import java.util.Scanner;

public class EjemploSwitch {

	public static void main(String[] args) {

		byte diaSemana;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Día de la semana: ");
			diaSemana=sc.nextByte();
		}

		// 1º Solución con if simles.
		if (diaSemana==1) {
			System.out.println("Lunes");
		}
		if (diaSemana==2) {
			System.out.println("Martes");
		}
		if (diaSemana==3) {
			System.out.println("Miercoles");
		}
		if (diaSemana==4) {
			System.out.println("Jueves");
		}
		if (diaSemana==5) {
			System.out.println("Viernes");
		}
		if (diaSemana==6) {
			System.out.println("Sabado");
		}
		if (diaSemana==7) {
			System.out.println("Domingo");
		}

		System.out.println("---------");

		// 2º solución con if anidados (más eficiente el planteamiento)
		if (diaSemana==1) {
			System.out.println("Lunes");
		}
		else
			if (diaSemana==2) {
				System.out.println("Martes");
			}
			else
				if (diaSemana==3) {
					System.out.println("Miercoles");
				}
				else
					if (diaSemana==4) {
						System.out.println("Jueves");
					}
					else
						if (diaSemana==5) {
							System.out.println("Viernes");
						}
						else
							if (diaSemana==6) {
								System.out.println("Sabado");
							}
							else
								if (diaSemana==7) {
									System.out.println("Domingo");
								}

		System.out.println("---------");

		// 3º solución con switch clasico
		switch (diaSemana) {
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miercoles");
			break;
		case 4:
			System.out.println("Jueves");
			break;
		case 5:
			System.out.println("Viernes");
			System.out.println("Por fin");
			break;
		case 6:
			System.out.println("Sabado");
			System.out.println("Fiesta");
			break;
		case 7:
			System.out.println("Domingo");
			break;
		default:
			System.out.println("Día no válido");
			break;
		}

		System.out.println("---------");
		
		// 4º solución switch ("ultimas versiones")
		switch (diaSemana) {
		case 1 ->
		System.out.println("Lunes");
		case 2 ->
		System.out.println("Martes");
		case 3 ->
		System.out.println("Miercoles");
		case 4 ->
		System.out.println("Jueves");
		case 5 -> {
			System.out.println("Viernes");
			System.out.println("Por fin");
		}
		case 6 -> {
			System.out.println("Sabado");
			System.out.println("Fiesta");
		}
		case 7 ->
		System.out.println("Domingo");
		default ->
		System.out.println("Día no válido");
		}
	}

}
