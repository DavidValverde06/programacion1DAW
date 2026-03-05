package prExamen03;

import java.util.Comparator;

public class ComparatorPrecioInscripcion implements Comparator<Asistente> {

	@Override
	public int compare(Asistente o1, Asistente o2) {
		return Double.compare(o2.calcularPrecioInscripcion(), o1.calcularPrecioInscripcion());
	}
}
