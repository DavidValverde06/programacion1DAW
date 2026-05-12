package inmobiliaria;

import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad o1, Propiedad o2) {
		return Double.compare(o1.getPrecio(), o2.getPrecio());
	}

}
