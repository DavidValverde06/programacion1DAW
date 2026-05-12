package urna;

/**
 * c) Crear la clase UrnaDeTresColores (negras, blancas y rojas), en este caso como podemos ver si han
 * añadido bolas de color Rojo.
 */

public class UrnaDeTresColores extends Urna {

	/**
	 * Variables de instancia
	 */
	protected int bolasRojas;

	/**
	 * Constructor
	 */
	public UrnaDeTresColores(int bolasNegras, int bolasBlancas, int bolasRojas) {
		super(bolasNegras, bolasBlancas);

		this.bolasRojas = bolasRojas;
	}

	/**
	 * Método sacaBola() redefinido
	 * 
	 * Devolverá el color de la bola sacada. Decrementa en 1 el nº de bolas de ese color.
	 */
	@Override
	public char sacaBola() {
		int total = this.bolasBlancas+this.bolasNegras+this.bolasRojas;
		int bolaSacada=(int)(Math.random()*total);
		if (bolaSacada<this.bolasNegras) {
			this.bolasNegras--;
			if (this.bolasNegras<=0) {
				this.bolasNegras=0;
			}
			return 'N';
		}
		else if (bolaSacada<this.bolasBlancas){
			this.bolasBlancas--;
			if (this.bolasBlancas<=0) {
				this.bolasBlancas=0;
			}
			return 'B';
		}
		else {
			this.bolasRojas--;
			if (this.bolasRojas<=0) {
				this.bolasRojas=0;
			}
			return 'R';
		}
		//		return super.sacaBola();
	}

	/**
	 * meteBola(char color) redefinido
	 * 
	 * Incrementa en 1 el número de bolas del color dado.
	 */
	@Override
	public void meteBola(char colorBola) {
		super.meteBola(colorBola);
		if (colorBola=='R') {
			this.bolasRojas++;
		}
	}

	/**
	 * boolean quedanBolas() redefinido
	 * 
	 * Devuelve cierto si hay bolas en la urna.
	 */
	@Override
	public boolean quedanBolas() {
		return this.totalBolas()>0;
	}

	/**
	 * boolean quedaMasDeUnaBola() redefinido
	 * 
	 * Devuelve cierto si hay más de una bola en la urna.
	 */
	@Override
	public boolean quedaMasDeUnaBola() {
		return this.totalBolas()>1;
	}

	/**
	 * int totalBolas()
	 * 
	 * Devuelve el número total de bolas (privado).
	 */
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
		return "\n" + this.getClass().getSimpleName().toUpperCase() +
				"\nNúmero de bolas blancas: " + this.bolasBlancas +
				"\nNúmero de bolas negras: " + this.bolasNegras +
				"\nNúmero de bolas rojas: " + this.bolasRojas +
				"\nNúmero total de bolas: " + this.totalBolas() + "\n";
	}
}
