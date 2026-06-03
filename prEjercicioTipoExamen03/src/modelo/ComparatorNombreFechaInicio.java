package modelo;

import java.util.Comparator;

/**
 * Ordenada por Alojamiento, y si este se repite por Fecha de Inicio
 */
public class ComparatorNombreFechaInicio implements Comparator<Reserva> {

	@Override
	public int compare(Reserva o1, Reserva o2) {
		int compara = o1.getAlojamientoReservado().getNombre().compareTo(o2.getAlojamientoReservado().getNombre());
		if (compara != 0) {
			return compara;
		}
		return o1.getFechaInicio().compareTo(o2.getFechaInicio());
	}
	
}
