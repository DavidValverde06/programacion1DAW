package prExamen01;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final float PRECIOGASOLINA95= 1.45f;
		final float PRECIOGASOLINA98= 1.65f;
		final float PRECIODIESEL= 1.45f;
		final float PRECIODIESELPLUS= 1.50f;

		int litrosRepostar,tipoCombustible,totalLitrosVendidos=0;
		float importePagar=0,totalRecaudado=0;
		char validacion;
		boolean atenderVehiculo=true;

		do { // Inicio del bucle do... while
			System.out.print("\nIntroduce los litros a repostar: ");
			litrosRepostar=sc.nextInt();

			if (litrosRepostar<=0) { // Controlar si los litros son negativos o 0.
				System.out.println("Cantidad inválida. No se puede repostar un valor negativo o cero.");
			}

			else {

				// En el escribe faltaria usar las constantes
				System.out.println("\n=== Tipos de combustible ===");
				System.out.println("1. Gasolina 95 (1.45 €/L)");
				System.out.println("2. Gasolina 98 (1.65 €/L)");
				System.out.println("3. Diésel (1.4 €/L)");
				System.out.println("4. Diésel plus (1.5 €/L)");

				System.out.print("Introduce el tipo de combustible (1-4): ");
				tipoCombustible=sc.nextInt();

				switch (tipoCombustible) {
				case 1 -> importePagar=PRECIOGASOLINA95*litrosRepostar;
				case 2 -> importePagar=PRECIOGASOLINA98*litrosRepostar;
				case 3 -> importePagar=PRECIODIESEL*litrosRepostar;
				case 4 -> importePagar=PRECIODIESELPLUS*litrosRepostar;
				default -> System.out.println("Tipo de combustible no válido. Se cancela el repostaje");
				}

				if (tipoCombustible==1 || tipoCombustible==2 || tipoCombustible==3 || tipoCombustible==4) {
					System.out.println("Importe a pagar: " + importePagar + " €");
					totalLitrosVendidos+=litrosRepostar;
					totalRecaudado+=importePagar;
				}
				
				// Este if mejor así:
				// if (tipoCombustible>=1 && tipoCombustible<=4) {
				//
				// }

			}

			System.out.print("\n¿Deseas atender a otro vehículo? (s/n): ");
			validacion=sc.next().charAt(0);
			validacion=Character.toLowerCase(validacion);

			if (validacion=='s') {
				atenderVehiculo=true;
			}
			else {
				atenderVehiculo=false;
			}

		} 

		while(atenderVehiculo==true); // Fin del bucle do... while
		
		// No es necesaria la variable boolean, se puede poner así:
		
		// 'validacion' es la variable tipo 'char'
		
		// while(validacion=='s') {
		//
		// }

		System.out.println("Fin del servicio.");
		System.out.println("Total de litros vendidos: " + totalLitrosVendidos + " L");
		System.out.println("Total recaudado: " + totalRecaudado + " €");

		sc.close();

	}

}
