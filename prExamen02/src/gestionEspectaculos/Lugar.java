package gestionEspectaculos;

import java.util.Objects;

public class Lugar {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private int aforo;
	private float costeAlquiler;

	/**
	 * Constructor
	 */
	public Lugar(String nombre, int aforo, float costeAlquiler) {
		this.nombre = nombre;
		this.aforo = aforo;
		this.costeAlquiler = costeAlquiler;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public int getAforo() {
		return aforo;
	}

	public float getCosteAlquiler() {
		return costeAlquiler;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public void setCosteAlquiler(float costeAlquiler) {
		this.costeAlquiler = costeAlquiler;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return this.nombre + ", " + this.aforo + " localidades, coste alquiler: " + (int)this.costeAlquiler + "€";
	}

	/**
	 * equals redefinido
	 * 
	 * Dos lugares son iguales si coincide el nombre y el aforo
	 */
	@Override
	public boolean equals(Object objeto) {
		Lugar otroLugar = (Lugar) objeto;

		return aforo == otroLugar.aforo && Objects.equals(nombre, otroLugar.nombre);
	}
}
