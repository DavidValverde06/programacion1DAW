package fraccion;

/**
 * 4. Crea la clase Fraccion. Los atributos serán numerador y denominador. Y algunos de los métodos pueden
 * 	  ser invierte, simplifica, multiplica, divide, etc.
 */

public class Fraccion {

	/*
	 * Variables de instancia
	 */
	private int signo;
	private int numerador;
	private int denominador;

	/*
	 * Constructor
	 */
	public Fraccion(int numerador, int denominador) throws Exception {
		if (denominador==0) {
			throw new Exception("Error, el denominador no puede ser 0");
		}

		if (numerador*denominador<0) {
			this.signo = -1;
		}
		else {
			this.signo = 1;
		}

		this.numerador = Math.abs(numerador);
		this.denominador = Math.abs(denominador);
	}

	/*
	 * Métodos getter's y setter's
	 */
	public int getNumerador() {
		return numerador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	/*
	 * Método toString 
	 */
	@Override
	public String toString() {
		if(signo == -1) {
			return "-" + this.numerador + "/" + this.denominador;
		}
		else {
			return this.numerador + "/" + this.denominador;
		}
	}

	/*
	 * Método equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraccion other = (Fraccion) obj;
		return denominador == other.denominador && numerador == other.numerador;
	}

	/*
	 * Método invierte
	 */
	public void invierte() {
		int aux = this.denominador;
		this.denominador = numerador;
		this.numerador = aux;
		System.out.println("Fracción invertida");
	}

	/*
	 * Método privado para el calculo del MCD para el método simplifica()
	 */
	private static int maximoComunDivisorRecursivo(int numA, int numB) {

		if (numA==numB) {
			return numA;
		}
		if (numA>numB) {
			return maximoComunDivisorRecursivo(numA-numB, numB);
		}
		else {
			return maximoComunDivisorRecursivo(numA, numB-numA);
		}
	}

	/*
	 * Método simplifica MEJORAR
	 */
	public void simplifica() {
		int mcd = maximoComunDivisorRecursivo(numerador, denominador);
		if (mcd > 1) {
			numerador = numerador/mcd;
			denominador = denominador/mcd;
		}
		else {
			System.out.println("La fracción ya está simplificada o no se puede simplificar más.");
		}
	}

	/*
	 * Método multiplica
	 */
	public Fraccion multiplica(Fraccion fraccionMultiplicar) throws Exception {
		int nuevoNumerador = this.numerador * fraccionMultiplicar.numerador;
		int nuevoDenominador = this.denominador * fraccionMultiplicar.denominador;
		return new Fraccion(nuevoNumerador, nuevoDenominador);
	}

	/*
	 * Método divide
	 */
	public Fraccion divide(Fraccion fraccionDividir) throws Exception {
		int nuevoNumerador = this.numerador * fraccionDividir.denominador;
		int nuevoDenominador = this.denominador * fraccionDividir.numerador;
		return new Fraccion(nuevoNumerador, nuevoDenominador);
	}
}
