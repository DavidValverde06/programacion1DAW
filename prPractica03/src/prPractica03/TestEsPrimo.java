package prPractica03;

import java.util.Scanner;

public class TestEsPrimo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		do {
			System.out.print("Introduce un número: ");
			num=sc.nextInt();
			System.out.println(LibreriaMatematica.esPrimo(num)?"Es primo\n":"No es primo\n");
		}
		while(num>=0);
		
		sc.close();
	}

}
