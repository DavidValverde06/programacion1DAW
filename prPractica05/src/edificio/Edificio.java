package edificio;

public class Edificio {

	/**
	 * Variables de instancia
	 */
	private Direccion dirEdificio; // Composición
	private int numHabitaciones;
	private int numPlantas;
	private float areaEdificio;

	/*
	 * Constructor que recibe como parámetro todos los datos de un edificio
	 */
	public Edificio(Direccion dirEdificio, int numHabitaciones, int numPlantas, float areaEdificio) {
		super();
		this.dirEdificio = dirEdificio;
		this.numHabitaciones = numHabitaciones;
		this.numPlantas = numPlantas;
		this.areaEdificio = areaEdificio;
	}
	
	/*
	 * Constructor que recibe todos los datos del edificio, pero en caso de la direccion nos llegan
	 * los datos del objeto el cual creamos en el propio constructor
	 */
	public Edificio(String nombreCalle, int numero, int codPostal,
			int numHabitaciones, int numPlantas, float areaEdificio) {
		this(new Direccion(nombreCalle, numero, codPostal), numHabitaciones, numPlantas, areaEdificio);
//		System.out.println("Estoy en el constructor de edificios");
		
		/*this.dirEdificio = new Direccion(nombreCalle, numero, codPostal);
		this.numHabitaciones = numHabitaciones;
		this.numPlantas = numPlantas;
		this.areaEdificio = areaEdificio;*/
	}
	
	/**
	 * Getter's y setter's
	 */
	public Direccion getDirEdificio() {
		return dirEdificio;
	}

	public void setDirEdificio(Direccion dirEdificio) {
		this.dirEdificio = dirEdificio;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getNumPlantas() {
		return numPlantas;
	}

	public void setNumPlantas(int numPlantas) {
		this.numPlantas = numPlantas;
	}

	public float getAreaEdificio() {
		return areaEdificio;
	}

	public void setAreaEdificio(float areaEdificio) {
		this.areaEdificio = areaEdificio;
	}
	
	/**
	 * Calcula IBI de un edificio
	 */
	public float calculaIBI() {
		return this.areaEdificio*1.2f + this.numPlantas*100;
	}
	
	/*
	 * toString redefinido (redefinimos toString de la clase Object)
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + // Obtener el nombre de la clase
				"\n\tDirección: " + this.dirEdificio.toString() +
				"\n\tImpuesto de IBI: " + this.calculaIBI() + "€" +
				"\n\tNúmero de habitaciones: " + this.numHabitaciones +
				"\n\tNúmero de plantas: " + this.numPlantas + 
				"\n\tArea edificio: " + this.areaEdificio;
	}
	

}
