package videojuegos;

/**
 * Clase Juego, sobre un Juego guardaremos su nombre, la plataforma en la que se vende, y las unidades
 * vendidas. Esta clase debe tener constructor, getter and setter, y toString con formato similar a:
 * 		EA Sports FC, plataforma XBOX, 41 unidades vendidas
 */
public class Juego {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private Plataforma plataforma;
	private int unidadesVendidas;

	/**
	 * Constructor
	 */
	public Juego(String nombre, Plataforma plataforma, int unidadesVendidas) {
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.unidadesVendidas = unidadesVendidas;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	/**
	 * toString redefinido
	 * 
	 * 		EA Sports FC, plataforma XBOX, 41 unidades vendidas
	 */
	@Override
	public String toString() {
		return this.nombre + ", plataforma " + this.plataforma + ", " + this.unidadesVendidas + " unidades vendidas";
	}
}
