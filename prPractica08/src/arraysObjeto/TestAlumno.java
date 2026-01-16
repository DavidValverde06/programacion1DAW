package arraysObjeto;

import java.util.Arrays;

public class TestAlumno {

	public static void main(String[] args) {

		Alumno [] clase = new Alumno[3];

		clase[0] = new Alumno("Juan", "Moreno", "López", 20);
		clase[1] = new Alumno("Ana", "Martín", "García", 19);
		clase[2] = new Alumno("Antonio", "Gil", "González", 22);

		System.out.println(Arrays.toString(clase));

		Alumno [] clase2 = {new Alumno("Juan", "Moreno", "López", 20),
				new Alumno("Ana", "Martín", "García", 19),
				new Alumno("Antonio", "Gil", "González", 22),
				new Alumno("María", "Gil", "González", 22),
				new Alumno("Ana", "Martín", "García", 19),
		};
		System.out.println(Arrays.toString(clase2));

		Alumno [] clase3 = {new Alumno("Juan", "Moreno", "López", 20),
				new Alumno("Ana", "Martín", "García", 19),
				new Alumno("Antonio", "Gil", "González", 22),
				new Alumno("María", "Gil", "González", 22),
				new Alumno("Ana", "Martín", "García", 19),
		};

		System.out.println();

		// Recorrer el array 3 con indices mostrando el nombre del alumno en mayúscula y su edad
		for (int cont=0;cont<clase3.length;cont++) {
			System.out.println(clase3[cont]);
			System.out.println(clase3[cont].getNombre().toUpperCase() + ", " + clase3[cont].getEdad());
		}

		System.out.println();

		// Recorrer el array con el bucle for-each
		for(Alumno elem:clase3) {
			System.out.println(elem);
		}

		// Comparar arrays de objetos
		System.out.println("Comparación clase y clase2: " + Arrays.equals(clase, clase2));
		System.out.println("Comparación clase2 y clase3: " + Arrays.equals(clase2, clase3));

		// Ordenar el array por el orden natural (Comparable)
		Arrays.sort(clase2);
		System.out.println(Arrays.toString(clase2));
		
		// Ordenar el array por un orden alternativo
		Arrays.sort(clase3,new OrdenAlternativo());
		System.out.println(Arrays.toString(clase3));

	}

}