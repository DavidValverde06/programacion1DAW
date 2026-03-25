package prPractica22Rosi;

/**
 * Clase propia de control de excepciones
 * @author profesor
 *
 */
public class MiExcepcion extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructores
	 */
	public MiExcepcion() {
		super("ERROR");
	}

	public MiExcepcion(String mensaje) {
		super(mensaje);
	}

}
