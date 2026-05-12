package ejercicio6;

import java.util.Comparator;

public class OrdenaApellido1DNI implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		int compara = o1.getApellido1().compareToIgnoreCase(o2.getApellido1());
		if (compara!=0) // El apellido1 es diferente
			return compara; 
		
		return o1.getDni().compareToIgnoreCase(o2.getDni());
	}

}
