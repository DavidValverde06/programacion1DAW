package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 10. Diseña tres programas que dibujen las siguientes figuras, para ello se pedirá la altura del triángulo.
		En estos tres ejemplos la altura del triángulo es 4.
 */

public class Ejercicioo10 {

	public static void main(String[] args) {

		int altura,espacios,asteriscos;
		String cadena="";
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la altura del triángulo: ");
		altura=sc.nextInt();

		// ---------------------------------------------------------------------------------------------
		// PRIMER TRIÁNGULO
		System.out.println("\n----------------\nPrimer triángulo\n");

		for (int cont=0;cont<altura;cont++) {
			System.out.println(cadena+='*');
		}

		System.out.println("\n----------------");
		// FIN PRIMER TRIÁNGULO
		// ---------------------------------------------------------------------------------------------



		// ---------------------------------------------------------------------------------------------
		// SEGUNDO TRIÁNGULO
		System.out.println("Segundo triángulo\n");

		cadena="";

		for (int cont=altura;cont>0;cont--) {

			for (int cont2=0;cont2<cont;cont2++) {
				cadena+='*';
			}
			cadena+='\n';
		}

		System.out.println(cadena);

		System.out.println("----------------");
		// FIN SEGUNDO TRIÁNGULO
		// ---------------------------------------------------------------------------------------------



		// ---------------------------------------------------------------------------------------------
		// TERCER TRIÁNGULO

		//		Línea 1: 4 espacios + 1 asterisco
		//		Línea 2: 3 espacios + 3 asteriscos
		//		Línea 3: 2 espacios + 5 asteriscos
		//		Línea 4: 1 espacio + 7 asteriscos
		//		Línea 5: 0 espacios + 9 asteriscos

		System.out.println("Tercer triángulo\n");

		for (int cont=0;cont<altura;cont++) {
			cadena="";
			espacios=altura-cont-1;
			asteriscos=2*cont+1;
			for (int cont2=0;cont2<espacios;cont2++) {
				cadena+=' ';
			}
			for (int cont3=0;cont3<asteriscos;cont3++) {
				cadena+='*';
			}
			System.out.println(cadena);
		}

		System.out.println("\n----------------");
		// FIN TERCER TRIÁNGULO
		// ---------------------------------------------------------------------------------------------



		// ---------------------------------------------------------------------------------------------
		// CUARTO TRIÁNGULO

		// TRIÁNGULO DE ARRIBA

		System.out.println("Cuarto triángulo\n");

		for (int cont=0;cont<altura-1;cont++) {
			cadena="";
			espacios=altura-cont-1;
			asteriscos=2*cont+1;
			for (int cont2=0;cont2<espacios;cont2++) {
				cadena+=' ';
			}
			for (int cont3=0;cont3<asteriscos;cont3++) {
				cadena+='*';
			}
			System.out.println(cadena);
		}

		// TRIÁNGULO DE ABAJO (INVERTIDO)

		//		Espacios: cont (empieza en 0 y sube)
		//		Asteriscos: 2 * (altura - cont - 1) + 1

		for (int cont=0;cont<altura;cont++) {
			cadena="";
			espacios=cont;
			asteriscos=2*(altura-cont-1)+1;
			for (int cont2=0;cont2<espacios;cont2++) {
				cadena+=' ';
			}
			for (int cont3=0;cont3<asteriscos;cont3++) {
				cadena+='*';
			}
			System.out.println(cadena);
		}

		System.out.println("\n----------------");
		// FIN CUARTO TRIÁNGULO
		// ---------------------------------------------------------------------------------------------



		// ---------------------------------------------------------------------------------------------
		// QUINTO TRIÁNGULO
		System.out.println("Quinto triángulo\n");

		for (int cont=1;cont<=altura;cont++) {
			cadena="";
			espacios=altura-cont;
			asteriscos=2*cont-1;
			for (int cont2=0;cont2<espacios;cont2++) {
				cadena+=' ';
			}
			for (int cont3=1;cont3<=cont;cont3++) {
				cadena+=cont3;
			}
			for (int cont4=cont-1;cont4>=1;cont4--) {
				cadena+=cont4;
			}

			System.out.println(cadena);
		}

		System.out.println("\n----------------");
		// FIN QUINTO TRIÁNGULO
		// ---------------------------------------------------------------------------------------------

		sc.close();
	}

}
