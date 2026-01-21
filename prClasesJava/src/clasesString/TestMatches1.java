package clasesString;

import java.util.Scanner;

public class TestMatches1 {
	
	public static void main(String[] args) {

		String respuesta; 
		try (Scanner sc = new Scanner(System.in)) {
			
			do { 
				System.out.println("Escriba el texto: ");
				respuesta=sc.nextLine();

				if (respuesta.matches("--[0-9]{3}[A-Z]+")==false) { 
					System.out.println("La expresión no encaja con el patrón"); 
				} 
			}
			while(respuesta.matches("--[0-9]{3}[A-Z]+")==false); 
			
			System.out.println("Expresión correcta!" );  
		}
	}
}
