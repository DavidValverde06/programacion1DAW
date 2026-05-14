package modelo;

import java.util.Objects;

public class Sala {

	/**
	 * Variables de instancia
	 */
	private int id_sala; // PK
	private int num_sala;
	private int capacidad;
	private EnumTipoSala tipo;

	/**
	 * Constructor
	 */
	public Sala(int codigo, int num_sala, int capacidad, EnumTipoSala tipo) {
		this.id_sala = codigo;
		this.num_sala = num_sala;
		this.capacidad = capacidad;
		this.tipo = tipo;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public int getCodigo() {return id_sala;}
	public int getNum_sala() {return num_sala;}
	public int getCapacidad() {return capacidad;}
	public EnumTipoSala getTipo() {return tipo;}

	// Setter's
	public void setCodigo(int codigo) {this.id_sala = codigo;}
	public void setNum_sala(int num_sala) {this.num_sala = num_sala;}
	public void setCapacidad(int capacidad) {this.capacidad = capacidad;}
	public void setTipo(EnumTipoSala tipo) {this.tipo = tipo;}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(capacidad, id_sala, num_sala, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return capacidad == other.capacidad && id_sala == other.id_sala && num_sala == other.num_sala
				&& tipo == other.tipo;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Sala [id_sala=" + id_sala + ", num_sala=" + num_sala + ", capacidad=" + capacidad + ", tipo=" + tipo
				+ "]";
	}

}
