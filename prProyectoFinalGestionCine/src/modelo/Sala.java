package modelo;

public class Sala {

	/**
	 * Variables de instancia
	 */
	private int num_sala;
	private int capacidad;
	private EnumTipoSala tipo;

	/**
	 * Constructor
	 */
	public Sala(int num_sala, int capacidad, EnumTipoSala tipo) {
		this.num_sala = num_sala;
		this.capacidad = capacidad;
		this.tipo = tipo;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public int getNum_sala() {
		return num_sala;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public EnumTipoSala getTipo() {
		return tipo;
	}

	// Setter's
	public void setNum_sala(int num_sala) {
		this.num_sala = num_sala;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setTipo(EnumTipoSala tipo) {
		this.tipo = tipo;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Sala número " + num_sala + "\n" + tipo +  "\nCapacidad: " + capacidad + " personas";
	}
}
