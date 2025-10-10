package ejemplos;

import java.util.Scanner;

// 		---EJEMPLO DE ROSI---

public class EjemploDebug {

	public static void main(String[] args) {
		
		// Declaración de las variables
		int numero;
		byte numTabla;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIntroduzca un número: ");
		numero = sc.nextInt();

		if ((numero%2)==0)
			System.out.println("El número es par");
		else
			System.out.println("El número es impar");

		if (numero>0)
			System.out.println("Número positivo");
		else
			if (numero<0)
				System.out.println("Número negativo");
			else
				System.out.println("Es cero");
		
		
		// Leer el número de la tabla
		System.out.print("Introduzca el número de la tabla: ");
		numTabla = sc.nextByte();
			
		System.out.println("TABLA DE MULTIPLICAR DE " + numTabla);
		
		
		// Generar la tabla de multiplicar (for)
		for (byte cont=1; cont<=10; cont++) {
			System.out.println(numTabla+" x "+cont+" = "+ (numTabla*cont));
		}

		System.out.println();
		
		// Generar la tabla de multiplicar (while)
		byte cont=1;
		while (cont<=10){	
			System.out.println(numTabla+" x "+cont+" = "+ (numTabla*cont));
			cont++;
		}
		
		System.out.println();		
		
		// Generar la tabla de multiplicar (do..while)
		byte cont2=1;
		do {	
			System.out.println(numTabla+" x "+cont2+" = "+ (numTabla*cont2));
			cont2++;
		}
		while (cont2<=10);
		
		System.out.println("Fin del programa");
		
		sc.close();
	}

	

}
