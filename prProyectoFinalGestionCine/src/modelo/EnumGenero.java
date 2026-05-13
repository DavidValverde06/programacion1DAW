package modelo;

public enum EnumGenero {

	DRAMA("Drama"),
	COMEDIA("Ciencia"),
	ACCION("Accion"),
	TERROR("Terror"),
	CIENCIA_FICCION("Ciencia ficción"),
	AVENTURA("Aventura"),
	ROMANCE("Romance"),
	THRILLER("Thriller"),
	ANIMACION("Animacion"),
	BIOGRAFIA("Biografia");

	/**
	 * Variables de instancia
	 */
	private String genero;

	/**
	 * Consructor
	 */
	private EnumGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Getter
	 */
	public String getGenero() {
		return genero;
	}
}
