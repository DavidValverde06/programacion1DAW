package _09Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class EjemploFichero7 {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(
				 new File("./src/_09Scanner/valores.txt"))
				       .useDelimiter("\\s*[,;: \r\n]\\s*")){
					
			while (sc.hasNextInt()) { // Mientras queden numeros separadas por , ; : o espacio
				
				int numero=sc.nextInt();  // Leer un numero
				
				System.out.println(numero);   // Mostrar el numero en consola
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
	}
}
