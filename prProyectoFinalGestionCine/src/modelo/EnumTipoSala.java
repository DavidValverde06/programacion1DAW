package modelo;

public enum EnumTipoSala {

	SALA_NORMAL("SALA_NORMAL"),
	SALA_VIP("SALA_VIP"),
	SALA_3D("SALA_3D");

	/**
	 * Variables de instancia
	 */
	private String genero;

	/**
	 * Consructor
	 */
	private EnumTipoSala(String genero) {
		this.genero = genero;
	}

	/**
	 * Getter
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return this.genero;
	}
}
