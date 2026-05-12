package ejemplo5;

import java.util.Scanner;

/**
 * Clase para probar el funcionamiento de las clase ExMatriculaValidar
 *
 */
public class Test {

	public static void main (String[] args) {

		ValidarMatricula LaMatricula = new ValidarMatricula();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Introduce la matricula (longitud 8, primer carácter letra): ");
			String matricula = sc.nextLine();
			LaMatricula.validar(matricula);
		}
		catch(ExMatricula e) {
			switch (e.getMalFormada()) {
			case ExMatricula.MAL_TAMANIO -> System.out.println("Tamaño incorrecto"); 
			case ExMatricula.MAL_LETRA   -> System.out.println("Letra inicial no incluida"); 
			}
		}

		sc.close();
	}
}



