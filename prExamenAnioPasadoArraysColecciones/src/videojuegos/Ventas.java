package videojuegos;

/**
 * Clase Ventas, en esta clase es donde vamos a simular la venta de diferentes videojuegos en diferentes
 * plataformas, para ello tendremos un array bidimensional con las posibles ventas, y otro array
 * unidimensional con los nombres de los videojuegos más vendidos. Desarrollaremos los siguientes
 * métodos:
 */
public class Ventas {

	/**
	 * Variables de instancia
	 */
	private int[][] posiblesVentas;
	private String[] juegosMasVendidos;

	/**
	 * Constructor, recibirá el array con los nombres de los juegos más vendidos, y se encargará de rellenar
	 * el array bidimensional con las posibles ventas, con valores aleatorios entre 0 y 49.
	 */
	public Ventas(String[] juegosMasVendidos) {
		this.juegosMasVendidos = juegosMasVendidos;
		this.posiblesVentas = new int[juegosMasVendidos.length][Plataforma.values().length];

		for (int filas=0;filas<this.posiblesVentas.length;filas++) {
			for (int columnas=0;columnas<this.posiblesVentas[filas].length;columnas++) {
				this.posiblesVentas[filas][columnas] = (int)(Math.random()*50);
			}
		}
	}

	/**
	 * Métodos getter’s and setter’s
	 */
	public int[][] getPosiblesVentas() {
		return posiblesVentas;
	}

	public void setPosiblesVentas(int[][] posiblesVentas) {
		this.posiblesVentas = posiblesVentas;
	}

	public String[] getJuegosMasVendidos() {
		return juegosMasVendidos;
	}

	public void setJuegosMasVendidos(String[] juegosMasVendidos) {
		this.juegosMasVendidos = juegosMasVendidos;
	}

	/**
	 * Método toString cuyo formato de salida sea similar al siguiente ejemplo:
	 * 
	 * 		SIMULACION VENTAS MENSUALES
	 *			PLAYSTATION 	XBOX 	NINTENDO 	PC
	 *			32 				43 		21 			39 		(EA Sports FC)
	 *			8 				8 		26 			41 		(Mario Kart)
	 *			5 				19 		18 			1 		(Dragon Ball)
	 *			23 				42 		44 			21 		(Super Mario Bros)
	 *			40 				0 		26 			3 		(Final Fantasy)
	 */
	@Override
	public String toString() {
		String cadena = "SIMULACION VENTAS MENSUALES\n";

		for (Plataforma plataforma : Plataforma.values()) {
			cadena += plataforma + "\t";
		}

		cadena += "\n";

		for (int filas=0;filas<this.posiblesVentas.length;filas++) {
			for (int columnas=0;columnas<this.posiblesVentas[filas].length;columnas++) {
				cadena += this.posiblesVentas[filas][columnas] + "\t";
			}
			cadena += "(" + this.juegosMasVendidos[filas] + ")\n";
		}

		return cadena;
	}

	/**
	 * Método getTotalVentasPlataforma(), método que nos devuelva un array unidimensional con las
	 * ventas de cada plataforma, sin importar cuál ha sido el videojuego vendido.
	 */
	public int getTotalVentasPlataforma() {

	}

	/**
	 * Método toStringVentasPlataforma(), método que os devuelva una cadena con información sobre
	 * las ventas de cada plataforma, sin importar cuál ha sido el videojuego vendido. Su formato de salida
	 * debe ser similar al siguiente ejemplo:
	 * 
	 */
	public String toStringVentasPlataforma() {

	}

	/**
	 * Método que nos devuelva las ventas de un determinado juego para una plataforma en concreto. El
	 * método estará sobrecargado, ya que la plataforma nos podrá llegar como valor enumerado o como
	 * cadena.
	 */
	public int getVentasJuego(Plataforma plataforma) { // Valor enumerado

	}
	
	public int getVentasJuego(String nombreJuego) { // Cadena

	}

	/**
	 * Método que nos devuelva un array de objetos de tipo Juego, con los n videojuegos más vendidos.
	 * A modo de ejemplo, si solicito al método que me devuelva los tres videojuegos más vendidos,
	 * siguiente los ejemplos anteriormente mostrados, me debería devolver una salida similar a:
	 * 
	 */
	public Juego[] numJuegosMasVendidos() {
		
	}
}
