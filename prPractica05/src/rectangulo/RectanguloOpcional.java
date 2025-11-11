package rectangulo;

/**
 * Opcional: Realiza una segunda versión del ejercicio en la que valides mediante el control de excepciones
 * que el alto y el ancho sean valores positivos, tanto en el constructor como en los métodos set y
 * agrandar.
 */

public class RectanguloOpcional {

	validar con control de excepciones
	
	/*
	 * Variables de instancia
	 */
	private int ancho;
	private int alto;

	/*
	 * Constructores
	 */
	public RectanguloOpcional(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

	public RectanguloOpcional(int lado) {
		this.ancho = lado;
		this.alto = lado;
	}

	public RectanguloOpcional() {
		this.ancho = 0;
		this.alto = 0;
	}

	/*
	 * area(). Devuelve el área del rectángulo (área = ancho * alto). 
	 */
	public double area() {
		return (double)this.ancho * this.alto;
	}

	/*
	 *  perimetro(). Devuelve el perímetro del rectángulo (perímetro = 2 * (alto + ancho))
	 */
	public double perimetro() {
		return 2 * (double)(alto+ancho);
	}

	/*
	 * agrandar(int factor). Aumentará el alto y el ancho por el factor que nos indiquen, este deberá ser
	 * positivo
	 */
	public Rectangulo agrandar(int factorAgrandar) {

		if (factorAgrandar<0) {
			return null;
		}

		this.alto*=factorAgrandar;
		this.ancho*=factorAgrandar;

		return new Rectangulo(this.alto, this.ancho);
	}

	/*
	 * ✓ agrandar(int ancho, int alto). Aumentará el alto y el ancho en los valores indicados, estos no podrán
	 * ser negativos.
	 */
	public Rectangulo agrandar(int ancho, int alto) {

		if (ancho<0 || alto<0) {
			return null;
		}

		this.alto+=alto;
		this.ancho+=ancho;

		return new Rectangulo(this.alto, this.ancho);
	}

	/*
	 * Métodos get y set. Los métodos set debe validar que no sean valores negativos.
	 */
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho<0) {
			System.out.println("No introduzcas valores negativos");
		}
		else {
			this.ancho = ancho;	
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto<0) {
			System.out.println("No introduzcas valores negativos");
		}
		else {
			this.alto = alto;	
		}	
	}

	/*
	 * ✓ Método toString, cuyo formato de salida sea similar a:
	 * Objeto tipo rectángulo
	 * Ancho: 20
	 * Alto: 18
	 */
	@Override
	public String toString() {
		return "Objeto tipo rectángulo" +
				"\nAncho: " + this.ancho +
				"\nAlto: " + this.alto;
	}

	/*
	 * ✓ Método para poder comparar rectángulos, consideraremos que dos rectángulos son iguales, si
	 * coincide su ancho y su alto.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RectanguloOpcional other = (RectanguloOpcional) obj;
		return alto == other.alto && ancho == other.ancho;
	}
}
