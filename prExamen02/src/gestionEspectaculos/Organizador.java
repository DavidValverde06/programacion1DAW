package gestionEspectaculos;

import java.util.Objects;

public class Organizador {

	/**
	 * Variables de instancia
	 */
	private String cif;
	private String nombre;
	private boolean descuentoVip;

	/**
	 * Constructor
	 */
	public Organizador(String cif, String nombre, boolean descuentoVip) {
		this.cif = cif;
		this.nombre = nombre;
		this.descuentoVip = descuentoVip;
	}

	public Organizador(String cif, String nombre) {
		this.cif = cif;
		this.nombre = nombre;
		this.descuentoVip = false;
	}

	/**
	 * Getter's y setter's
	 */
	public String getCif() {
		return cif;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isDescuentoVip() {
		return descuentoVip;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescuentoVip(boolean descuentoVip) {
		this.descuentoVip = descuentoVip;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return this.cif + " - " + this.nombre + " (" + (this.descuentoVip?"Sí aplica descuentos VIP":"No aplica descuentos VIP") + ")";
	}

	/**
	 * equals redefinido
	 * 
	 * Dos organizadores son iguales si coincide el CIF
	 */
	@Override
	public boolean equals(Object objeto) {
		Organizador otroOrganizador = (Organizador)objeto;

		return Objects.equals(cif, otroOrganizador.cif);
	}
}
