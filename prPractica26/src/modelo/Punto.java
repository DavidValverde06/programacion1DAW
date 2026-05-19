package modelo;

/**
 * a) Clase Punto que mantiene la información de un punto bidimensional y que debe proporcionar al menos
 * la siguiente interfaz:
 * 
 * - Constructor, se deben proporcionar dos constructores, uno que cree un objeto de la clase Punto sin
 * darle valor a las coordenadas, es decir, el constructor por defecto., y otro al que ya le lleguen las
 * coordenadas del punto.
 * 
 * - Métodos que devuelvan las coordenadas de un punto y método toString.
 * 
 * - Un método sobrecargado distancia, que nos devuelve la distancia de dicho punto a otro punto
 * pasado como argumento (bien las coordenadas, bien otro objeto de la clase punto). La distancia
 * entre dos puntos p(x1, y1) y q(x2,y2), se calcula con la siguiente fórmula:
 */
public class Punto {

	/**
	 * Variables de instancia
	 */
	private float varX;
	private float varY;

	/**
	 * Constructor sobrecargado
	 */
	public Punto(float varX, float varY) {
		this.varX = varX;
		this.varY = varY;
	}

	public Punto() {
		this.varX = 0;
		this.varY = 0;
	}

	/**
	 * Getter's
	 */
	public float getVarX() {return varX;}
	public float getVarY() {return varY;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return varX + ", " + varY;
	}

	/**
	 * Un método sobrecargado distancia, que nos devuelve la distancia de dicho punto a otro punto
	 * pasado como argumento (bien las coordenadas, bien otro objeto de la clase punto). La distancia
	 * entre dos puntos p(x1, y1) y q(x2,y2), se calcula con la siguiente fórmula:
	 * 
	 * 		d(p,q) = √(x2 – x1)2 + (y2 – y1 )2
	 */
	public float distancia(Punto punto2) {
		return (float)Math.sqrt( (Math.pow(punto2.getVarX()-varX, 2)) + (Math.pow(punto2.getVarY()-varY, 2)) );
	}

	public float distancia(int varX2, int varY2) {
		return (float)Math.sqrt( (Math.pow(varX2 - varX, 2)) + (Math.pow(varY2 - varY, 2)) );
	}
}
