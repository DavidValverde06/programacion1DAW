package urna;

/**
 * b) Desarrollar la clase UrnaTrampa, la cual tiene un comportamiento especial, porque al sacar una bola,
 * hay una probabilidad del 0.2% de que una de las bolas que quedan dentro cambie de color (para ello
 * ha de haber bolas de ambos colores en la urna). Probar el funcionamiento de la nueva clase.
 */

public class UrnaTrampa extends Urna {

	/**
	 * Constructor
	 * @param bolasNegras
	 * @param bolasBlancas
	 */
	public UrnaTrampa(int bolasNegras, int bolasBlancas) {
		super(bolasNegras, bolasBlancas);
	}

	/**
	 * Método sacaBola redefinido
	 */
	@Override
	public char sacaBola() {
		int cambiarBola;
		int probabilidad;

		probabilidad=(int)(Math.random()*1000)+1;

		if (probabilidad<=2) {
			if (this.bolasBlancas>0 && this.bolasNegras>0) {
				cambiarBola=(int)Math.random()*2;
				if (cambiarBola==0) {
					this.bolasBlancas++;
					this.bolasNegras--;
				}
				else {
					this.bolasBlancas--;
					this.bolasNegras++;
				}
			}
		}
		return super.sacaBola();
	}
}
