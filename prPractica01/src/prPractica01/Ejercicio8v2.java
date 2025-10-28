package prPractica01;

public class Ejercicio8v2 {

	public static void main(String[] args) {

		// Constantes
		 final int N = 10;
		 // Variables
		 int a, b, c = 0;
		 
		 a = Integer.parseInt(args[0]);
		 b = Integer.parseInt(args[1]);
		 
		 c = a - b + N;
		 c = c + c;
		 b = a + b - c;
		 a = a + b - c;
		 a = N * a;
		 
		 System.out.println(a);
		 
		}

	}