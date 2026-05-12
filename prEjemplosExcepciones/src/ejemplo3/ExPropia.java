package ejemplo3;
/**
 * Definión de una clase que define una clase propia de manejo de excepciones
 */

public class ExPropia extends Exception 
{ 
	private static final long serialVersionUID = -3286997316340530132L;

	/**
	 * Constructor por defecto
	 */
	public ExPropia() { 
		super("Esta es mi propia excepcion");	
	}

	/**
	 * Constructor con mensaje personalizado
	 * @param s
	 */
	public ExPropia(String s) { 
		super(s); 
	}
}

