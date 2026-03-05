package prExamen03;

import java.util.Comparator;

public class ComparatorFechaNombreDNI implements Comparator<Asistente> {

	@Override
	public int compare(Asistente o1, Asistente o2) {
		int compara = o1.getFechaInscripcion().compareTo(o2.getFechaInscripcion());
		if (compara!=0) {
			return compara;
		}

		compara = o1.getNombre().compareTo(o2.getNombre());
		if (compara!=0) {
			return compara;
		}

		return o1.getDni().compareTo(o2.getDni());
	}

}
