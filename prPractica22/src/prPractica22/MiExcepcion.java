package prPractica22;

public class MiExcepcion extends Exception {

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
