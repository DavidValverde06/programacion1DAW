package prPractica02;

import java.util.Scanner;

/**
 * 15. Programa que lea 3 números de teclado y los muestre en pantalla de forma ordenada.
 */

public class Ejercicioo15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3,primero=0,segundo=0,tercero=0; ayuda
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		System.out.print("Introduce el tercer número: ");
		num3=sc.nextInt();
		
//		if (num1>num2&&num1>num3 && num2<num1&&num2>num3 && num3<num1&&num3<num2) { //num1 > num2 > num3
//			primero=num1;
//			segundo=num2;
//			tercero=num3;
//		}
//		else if (num2>num1&&num1>num3) { // num2 > num1 > num3
//			primero=num2;
//		}
//		else if (num3>num1&&num3>num2) { // num3 > num1 > num2
//			primero=num3;
//		}
		
		if (num1>num2) {
			primero = num1;
			if (num2>num3) {
				segundo = num2;
				tercero= num3;
			}
			else {
				segundo = num3;
				tercero = num2;
			}
		}
		else if (num2>primero) {
			primero = num2;
			segundo = num1;
		}
		
		System.out.println("Números ordenados" +
						"\n1º: " + primero +
						"\n2º: " + segundo +
						"\n3º: " + tercero);
		
		sc.close();
	}

}
