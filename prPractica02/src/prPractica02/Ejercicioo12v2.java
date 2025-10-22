package prPractica02;

/**
 * Diseñar un algoritmo para simular una calculadora simple. Para ello deberá tener las siguientes
   características:
		✓ Sólo efectuará operaciones con dos operandos.
		✓ Operaciones permitidas: (+, -, *, /).
		✓ Se trabajará con operandos enteros.
		✓ Pedirá en primer lugar el operador, y a continuación los dos operandos. Si el operador no se
		  corresponde con alguno de los indicados se emitirá un mensaje de error:

 */

import java.util.Scanner;

public class Ejercicioo12v2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char signo,confirmar;
		int num1,num2;
		boolean validacion=true;

		System.out.println("CALCULADORA SIMPLE");
		
		do {
			System.out.print("\nIntroduce un signo: ");
			signo = sc.nextLine().charAt(0);

			if (signo!='+'&& signo!='-'&& signo!='*'&& signo!='/') {
				System.out.println("ERROR. OPERACIÓN NO VÁLIDA");
			}
			else {
				System.out.print("Introduce el operando 1: ");
				num1=sc.nextInt();
				System.out.print("Introduce el operando 2: ");
				num2=sc.nextInt();

				switch (signo) {
				case '+':
					System.out.println("\nOperación: " + signo +
							"\nOperando 1: " + num1 +
							"\nOperando 2: " + num2 +
							"\nResultado: " + (num1+num2));
					break;
				case '-':
					System.out.println("\nOperación: " + signo +
							"\nOperando 1: " + num1 +
							"\nOperando 2: " + num2 +
							"\nResultado: " + (num1-num2));
					break;
				case '*':
					System.out.println("\nOperación: " + signo +
							"\nOperando 1: " + num1 +
							"\nOperando 2: " + num2 +
							"\nResultado: " + (num1*num2));
					break;
				case '/':
					System.out.println("\nOperación: " + signo +
							"\nOperando 1: " + num1 +
							"\nOperando 2: " + num2 +
							"\nResultado: " + (num1/num2));
					break;
				default:
					System.out.println("ERROR. OPERACIÓN NO VÁLIDA");
					break;

				}
			}
			
			System.out.print("\nDesea repetir la operación(S/N): ");
			confirmar=sc.next().charAt(0);
			if (Character.toLowerCase(confirmar)=='s') {
				validacion=true;
			}
			else if (Character.toLowerCase(confirmar)=='n') {
				validacion=false;
				System.out.println("\nFIN DE PROGRAMA");
			}
			else {
				System.out.println("\nERROR. VUELVA A INTENTARLO ");
			}

		}
		while(validacion!=false);

		sc.close();
	}

}
