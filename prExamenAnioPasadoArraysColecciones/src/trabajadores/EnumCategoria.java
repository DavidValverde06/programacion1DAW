package trabajadores;

public enum EnumCategoria {

	PROGRAMADOR_JUNIOR(1500), 
	PROGRAMADOR_SENIOR(1600),
	JEFE_DE_EQUIPO(2500),
	ANALISTA(2800),
	JEFE_DE_PROYECTO(3000);

	/**
	 * Variables de instancia
	 */
	private int salarioBase;

	/**
	 * Constructor
	 */
	private EnumCategoria(int salarioBase) {
		this.salarioBase = salarioBase;
	}

	/**
	 * Getter
	 */
	public int getSalarioBase() {
		return salarioBase;
	}	
}
