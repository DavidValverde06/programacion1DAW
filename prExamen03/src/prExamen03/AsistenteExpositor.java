package prExamen03;

public class AsistenteExpositor extends Asistente{

	/**
	 * Variables de instancia
	 */
	private String nombreEmpresa;

	/**
	 * Constructor
	 */
	public AsistenteExpositor(String dni, String nombre, String fechaNacimiento, String fechaInscripcion,
			String nombreEmpresa) {
		super(dni, nombre, fechaNacimiento, fechaInscripcion);
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreEmpresa() {return nombreEmpresa;}
	public void setNombreEmpresa(String nombreEmpresa) {this.nombreEmpresa = nombreEmpresa;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tNombre empresa: " + this.nombreEmpresa;
	}

	/**
	 * Método para calcular el precio de la inscripción
	 * 
	 * NO PAGA NADA
	 */
	@Override
	public double calcularPrecioInscripcion() {
		return 0;
	}
}
