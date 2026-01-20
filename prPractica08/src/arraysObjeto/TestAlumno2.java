package arraysObjeto;

import java.util.Scanner;

/**
 * Define un array de seis alumnos y rellénalo solicitando los datos por teclado. Por último, muestra los datos de los
 * alumnos por pantalla, así como el nombre y la nota del alumno que tiene la nota media más alta.
 */
public class TestAlumno2 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
		
		final int TAMANIOCLASE=2;
		String nombre;
		int edad;
		
		Alumno2[] clase2 = new Alumno2[TAMANIOCLASE];
		
		for (int cont=0;cont<clase2.length;cont++) {
			System.out.print("Introduce el nombre del alumno: ");
			nombre=sc.nextLine();
			System.out.print("Introduce su edad: ");
			edad=sc.nextInt();
			sc.nextLine();
			
			clase2[cont] = new Alumno2();
			clase2[cont].setNombre(nombre);
			clase2[cont].setEdad(edad);
		}
		
		System.out.println(clase2);
		
		}
	}

}
