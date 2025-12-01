package urna;

/**
 * c) Crear la clase UrnaDeTresColores (negras, blancas y rojas), en este caso como podemos ver si han
 * añadido bolas de color Rojo. Una vez desarrollada esta clase, para su testeo realizaremos un
 * programa que haga lo siguiente: mientras en la urna quede más de una bola, sacar dos bolas de la
 * misma. Si ambas son blancas, introducir una bola roja en la urna.
 * 
 * Si ambas son iguales, menos blancas, introducir una bola del mismo color en la urna. Y si son distintas
 * se mete una bola blanca.
 * Finalmente se extrae la última bola que queda y se indica su color.
 */

public class UrnaDeTresColores extends Urna {

	/**
	 * Variables de instancia
	 */
	protected int bolasRojas;

	/**
	 * Constructor
	 * @param bolasNegras
	 * @param bolasBlancas
	 * @param bolasRojas
	 */
	public UrnaDeTresColores(int bolasNegras, int bolasBlancas, int bolasRojas) {
		super(bolasNegras, bolasBlancas);
		
		this.bolasRojas = bolasRojas;
	}
	
	/**
	 * int totalBolas()
	 * 
	 * Devuelve el número total de bolas (privado).
	 */
	@Override
	private int totalBolas() {
		return (this.bolasBlancas + this.bolasNegras + this.bolasRojas);
	}
	
	/**
	 * Getter's y setter's 
	 */
	public int getBolasRojas() {
		return bolasRojas;
	}

	public void setBolasRojas(int bolasRojas) {
		this.bolasRojas = bolasRojas;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNúmero de bolas negras: " + this.bolasRojas;
	}
	
}
