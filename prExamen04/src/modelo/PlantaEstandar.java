package modelo;

public class PlantaEstandar extends Planta {

	/**
	 * Variables de instancia
	 */
	private String plantaDe;
	private boolean requiereLuzDirecta;

	/**
	 * Constructor
	 */
	public PlantaEstandar(String idPlanta, String nombreComunPlanta, double precioBasePlanta, int stockDisponible,
			String plantaDeInterior, boolean requiereLuzDirecta) {
		super(idPlanta, nombreComunPlanta, precioBasePlanta, stockDisponible);
		this.plantaDe = plantaDeInterior;
		this.requiereLuzDirecta = requiereLuzDirecta;
	}

	/**
	 * Getter y Setter
	 */
	public String getPlantaDe() {return plantaDe;}
	public void setPlantaDe(String plantaDe) {this.plantaDe = plantaDe;}

	public boolean isRequiereLuzDirecta() {return requiereLuzDirecta;}
	public void setRequiereLuzDirecta(boolean requiereLuzDirecta) {this.requiereLuzDirecta = requiereLuzDirecta;}

	@Override
	public double calcularPrecioVenta() {
		double precioVenta = getPrecioBasePlanta();
		float aumento = (float)(precioVenta * (20/100f));
		return precioVenta += aumento;
	}

	@Override
	public String obtenerFichaCuidados() {
		return "--> Cuidados: Planta de " + plantaDe +
				". " + ((this.requiereLuzDirecta==true)?"Requiere sol directo.":"Mantener en sombra/semisombra.");
	}

}
