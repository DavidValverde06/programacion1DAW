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

public class Ejercicioo12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char signo;
		int num1,num2;
		
		System.out.print("Introduce un signo: ");
		signo = sc.next().charAt(0);
		
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
		
		sc.close();
	}

}
