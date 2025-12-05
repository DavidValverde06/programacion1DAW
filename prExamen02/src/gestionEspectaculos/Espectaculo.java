package gestionEspectaculos;

import java.util.Objects;

public abstract class Espectaculo {

	/**
	 * Variables de instancia
	 */
	private String titulo;
	private Organizador organizador;
	private Lugar lugar;
	private int duracion; // En minutos

	/**
	 * Constructor
	 */
	public Espectaculo(String titulo, Organizador organizador, Lugar lugar, int duracion) {
		this.titulo = titulo;
		this.organizador = organizador;
		this.lugar = lugar;
		this.duracion = duracion;
	}

	/**
	 * Getter's y setter's
	 */
	public String getTitulo() {
		return titulo;
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * Método impuestoLocal()
	 */
	public float impuestoLocal() {
		float resultado=0;
		if (this.lugar.getAforo()<500) {
			resultado+=200;
		}
		else if (this.lugar.getAforo()<1000) {
			resultado+=400;
		}
		else {
			resultado+=600;
		}
		return resultado;
	}

	/**
	 * equals redefinido
	 */
	@Override
	public boolean equals(Object objeto) {
		Espectaculo otroEspectaculo = (Espectaculo)objeto;

		return Objects.equals(lugar, otroEspectaculo.lugar) && Objects.equals(organizador, otroEspectaculo.organizador) && Objects.equals(titulo, otroEspectaculo.titulo);
	}

	/**
	 * Método abstracto calcularPrecioBaseEntrada()
	 */
	public abstract float calcularPrecioBaseEntrada();

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
				"\n\tTítulo: " + this.titulo +
				"\n\tOrganizador: " + this.organizador.toString() +
				"\n\tLugar: " + this.lugar.toString() +
				"\n\tImpuestos locales: " + impuestoLocal() + "€" +
				"\n\tPrecio base entradas: " + calcularPrecioBaseEntrada() + "€" +
				"\n\tDuración: " + Utilidades.formateaDuracion(this.duracion);
	}


}
