package trabajadores;

public enum EnumPlus {

	ACTIVIDAD(50),
	ASISTENCIA(30),
	FLEXIBILIDAD(60), 
	BENEFICIOS_EXTRAS(100),
	FORMACION(80),
	RESIDENCIA(200),
	TRABAJO_FIN_DE_SEMANA(250),
	NOCTURNIDAD(100);

	/**
	 * Variables de instancia
	 */
	private int importeIncrementaSalario;

	/**
	 * Constructor
	 */
	private EnumPlus(int importeIncrementaSalario) {
		this.importeIncrementaSalario = importeIncrementaSalario;
	}

	/**
	 * Getter
	 */
	public int getImporteIncrementaSalario() {
		return importeIncrementaSalario;
	}
}
