package modelo;

import java.util.Comparator;

public class ComparatorPrioridadHoraNombre implements Comparator<CitaMedica>{

	@Override
	public int compare(CitaMedica o1, CitaMedica o2) {
		int compara = Integer.compare(o1.getPrioridadCita(), o2.getPrioridadCita());
		if (compara!=0) {
			return compara;
		}

		compara = o1.getHoraVisita().compareTo(o2.getHoraVisita());
		if (compara!=0) {
			return compara;
		}

		return o1.getNombrePaciente().compareTo(o2.getNombrePaciente());
	}

}
