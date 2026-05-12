package urna;

/**
 * 4.- a) Crear la clase Urna, la cual contiene inicialmente un número determinado de bolas blancas y un
 * número determinado de bolas negras, y presenta como interfaz los siguientes métodos:
 * 
 * 	✓ Urna(int a, int b). Constructor que inicializa las variables de instancia de la clase.
 * 
 * 	✓ char sacaBola(). Devolverá el color de la bola sacada. Decrementa en 1 el nº de bolas de ese color.
 * 
 * 	✓ void meteBola(char color). Incrementa en 1 el número de bolas del color dado.
 * 
 * 	✓ boolean quedanBolas(). Devuelve cierto si hay bolas en la urna.
 * 
 * 	✓ boolean quedaMasDeUnaBola(). Devuelve cierto si hay más de una bola en la urna.
 * 
 * 	✓ int totalBolas(). Devuelve el número total de bolas (privado).
 * 
 * 	✓ Métodos get y set.
 * 
 * 	✓ String toString(). Este método devuelve una cadena con información sobre la
 *  urna, redefiniremos el método toString de la clase Object.
 */

public class Urna {

	/**
	 * Variables de instancia
	 */
	protected int bolasNegras;
	protected int bolasBlancas;

	/**
	 * Constructor
	 */
	public Urna(int bolasNegras, int bolasBlancas) {
		this.bolasNegras = bolasNegras;
		this.bolasBlancas = bolasBlancas;
	}

	/**
	 * Método sacaBola()
	 * 
	 * Devolverá el color de la bola sacada. Decrementa en 1 el nº de bolas de ese color.
	 */
	public char sacaBola() {
		int total = this.bolasBlancas+this.bolasNegras;
		int bolaSacada=(int)(Math.random()*total);
		if (bolaSacada<this.bolasNegras) {
			this.bolasNegras--;
			if (this.bolasNegras<=0) {
				this.bolasNegras=0;
			}
			return 'N';
		}
		else {
			this.bolasBlancas--;
			if (this.bolasBlancas<=0) {
				this.bolasBlancas=0;
			}
			return 'B';
		}
	}

	/**
	 * meteBola(char color)
	 * 
	 * Incrementa en 1 el número de bolas del color dado.
	 */
	public void meteBola(char colorBola) {
		if (colorBola=='N') {
			this.bolasNegras++;
		}
		else if (colorBola=='B') {
			this.bolasBlancas++;
		}
	}

	/**
	 * boolean quedanBolas()
	 * 
	 * Devuelve cierto si hay bolas en la urna.
	 */
	public boolean quedanBolas() {
		return this.totalBolas()>0;

		//		if (this.bolasBlancas>0 && this.bolasNegras>0) {
		//			return true;
		//		}
		//		return false;
	}

	/**
	 * boolean quedaMasDeUnaBola()
	 * 
	 * Devuelve cierto si hay más de una bola en la urna.
	 */
	public boolean quedaMasDeUnaBola() {
		return this.totalBolas()>1;
	}

	/**
	 * int totalBolas()
	 * 
	 * Devuelve el número total de bolas (privado).
	 */
	private int totalBolas() {
		return (this.bolasBlancas + this.bolasNegras);
	}

	/**
	 * Métodos get y set.
	 */
	public int getBolasNegras() {
		return bolasNegras;
	}
	public void setBolasNegras(int bolasNegras) {
		this.bolasNegras = bolasNegras;
	}
	public int getBolasBlancas() {
		return bolasBlancas;
	}
	public void setBolasBlancas(int bolasBlancas) {
		this.bolasBlancas = bolasBlancas;
	}

	/**
	 * String toString(). Este método devuelve una cadena con información sobre la
	 * urna, redefiniremos el método toString de la clase Object.
	 */
	@Override
	public String toString() {
		return "\n" + this.getClass().getSimpleName().toUpperCase() +
				"\nNúmero de bolas blancas: " + this.bolasBlancas +
				"\nNúmero de bolas negras: " + this.bolasNegras +
				"\nNúmero total de bolas: " + this.totalBolas() + "\n";
	}
}
