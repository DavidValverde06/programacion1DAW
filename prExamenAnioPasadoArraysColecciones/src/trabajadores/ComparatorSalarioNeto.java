package trabajadores;

import java.util.Comparator;

public class ComparatorSalarioNeto implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		return Double.compare(o1.calculoSalarioNeto(), o2.calculoSalarioNeto());
	}

}
