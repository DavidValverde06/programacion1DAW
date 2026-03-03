package trabajadores;

/**
 * Clase propia de manejo de excepciones
 * @author Usuario
 *
 */
public class EmpresaException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto
	 */
	public EmpresaException() {
		super();
	}
	
	/**
	 * Constructor con mensaje personlizado
	 * @param msg
	 */
	public EmpresaException(String msg) {
		super(msg);
	}
}
