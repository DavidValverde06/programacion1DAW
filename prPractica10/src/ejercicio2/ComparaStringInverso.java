package ejercicio2;

import java.util.Comparator;

public class ComparaStringInverso implements Comparator<String> {

	/**
	 * Método que compara cadenas en sentido inverso
	 */
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}

}
