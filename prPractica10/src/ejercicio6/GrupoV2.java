package ejercicio6;

import java.util.LinkedList;


public class GrupoV2 extends LinkedList<Alumno> {

	private static final long serialVersionUID = 7473028938181569368L;

	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		String cad = "\nLISTA DE CLASE" + 
	                 "\n--------------\n";
		
		for (Alumno alumnoClase: this) {
			cad = cad + alumnoClase.toString();
		}
		       
		return cad;
	}
}
