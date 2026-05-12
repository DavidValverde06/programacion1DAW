package prPractica01;

import java.util.Scanner;

/**
 * 7.- Un agricultor que se dedica al cultivo ecológico de naranjas y limones, quiere calcular los beneficios
	   que obtiene anualmente por la venta de los mismos. Por este motivo vamos a diseñar una aplicación
	   que solicite las ventas (en kilos) de cada semestre para cada fruta. La aplicación mostrará el importe
	   total sabiendo que el precio del kilo de naranjas está fijado en 1.25€ y el kilo de limones en 1.90€
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final float KILONARANJA=1.25f;
		final float KILOLIMON=1.90f;
		float ventaNaranjas1, ventaLimones1, ventaNaranjas2, ventaLimones2;
		float resultadoSemestre1Naranjas, resultadoSemestre1Limones, resultadoSemestre2Naranjas, resultadoSemestre2Limones;
		float totalNaranjas, totalLimones;
		
		System.out.print("Introduce la venta (en kilos) de naranjas el primer semestre: ");
		ventaNaranjas1=sc.nextFloat();
		System.out.print("Introduce la venta (en kilos) de limones el primer semestre: ");
		ventaLimones1=sc.nextFloat();
		
		
		resultadoSemestre1Naranjas=ventaNaranjas1*KILONARANJA;
		System.out.println("\nVenta de naranjas el primer semestre: " + resultadoSemestre1Naranjas + " €.");
		
		resultadoSemestre1Limones=ventaLimones1*KILOLIMON;
		System.out.println("Venta de limones el primer semestre: " + resultadoSemestre1Limones + " €.");
		
		
		System.out.print("\nIntroduce la venta (en kilos) de naranjas el segundo semestre: ");
		ventaNaranjas2=sc.nextFloat();
		System.out.print("Introduce la venta (en kilos) de limones el segundo semestre: ");
		ventaLimones2=sc.nextFloat();
		
		resultadoSemestre2Naranjas=ventaNaranjas2*KILONARANJA;
		System.out.println("\nVenta de naranjas el segundo semestre: " + resultadoSemestre2Naranjas + " €.");
		
		resultadoSemestre2Limones=ventaLimones2*KILOLIMON;
		System.out.println("Venta de limones el segundo semestre: " + resultadoSemestre2Limones + " €.");
		
		
		totalNaranjas=resultadoSemestre1Naranjas+resultadoSemestre2Naranjas;
		System.out.println("\nVenta total de naranjas: " + totalNaranjas + " €.");
		
		totalLimones=resultadoSemestre1Limones+resultadoSemestre2Limones;
		System.out.println("Venta total de limones: " + totalLimones  + " €.");
		
		System.out.println("TOTAL: " + (totalLimones+totalNaranjas) + " €.");

		sc.close();
	}

}
