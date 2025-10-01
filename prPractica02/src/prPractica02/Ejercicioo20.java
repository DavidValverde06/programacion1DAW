package prPractica02;

/**
 * 20. Desarrolla un programa que resuelva la siguiente serie matemática:
			s(n) = 1 + 1/2 + 1/3 + ... + 1/n
 */

public class Ejercicioo20 {

	public static void main(String[] args) {

		int num=1;
		
		for (int cont=2;cont>0;cont++) {
			System.out.println((num+1)/cont);
		}
	}

}
