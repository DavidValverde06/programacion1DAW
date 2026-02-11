package ejemplo5;

/**
 * Clase propia de control de excepciones
 * 
 * En esta clase también tenemos una variable de instancia, y un par de constantes
 *
 */

public class ExMatricula extends Exception {

	private static final long serialVersionUID = 3836519845115256708L;

	/**
	 * Variable de instancia
	 */
	private int malFormada = 0;

	/**
	 * Constantes de clase
	 */
	static final int MAL_TAMANIO = -1;
	static final int MAL_LETRA = -2;


	/**
	 * Constructores
	 */
	public ExMatricula () {super();}

	public ExMatricula (String s) {super(s);}

	public ExMatricula (int malFormada) {
		this.malFormada = malFormada;
	}


	/**
	 * Método get
	 * @return
	 */
	public int getMalFormada() { 
		return malFormada;
	}
}





