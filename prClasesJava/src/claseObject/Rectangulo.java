package claseObject;

public class Rectangulo implements Cloneable {
	
	/**
	 * Variables de instancia
	 */
	private int ancho;
	private int alto;
	private String nombre;
	
	
	/**
	 * Constructor
	 */
	public Rectangulo(int an, int al) {
		this.ancho = an;
		this.alto = al;
	}
	
	
	/**
	 * M�todo que incrementa el ancho en una unidad
	 */
	public void incrementaAncho() {this.ancho++;}
	
	
	/**
	 * M�todo que incrementa el alto en una unidad
	 */
	public void incrementaAlto() {this.alto++;}
	
	
	/**
	 * Redefinición de toSring
	 */
	@Override
	public String toString() {
		return "RECTANGULO: " +
				"\n\tAlto: "+this.alto +
				"\n\tAncho: "+this.ancho +
				"\n\tNombre: "+this.nombre;
	}
	
	
	/**
	 * Redefinición del método clone de la clase Object
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public Rectangulo clone() {
		Rectangulo objeto=null;
		try {
			objeto = (Rectangulo) super.clone();
		} 
		catch (CloneNotSupportedException e) {
			System.out.println("Error al duplicar");
		}
		return objeto;
	}

	
	/*
	@Override
	public Rectangulo clone() throws CloneNotSupportedException {
	
		return (Rectangulo) super.clone();
		
	}
	*/

	/**
	 * M�todos get y set
	 */
	public int getAncho() {return ancho;}
	public int getAlto() {return alto;}
	public String getNombre() {return nombre;}

	public void setAncho(int ancho) {this.ancho = ancho;}
	public void setAlto(int alto) {this.alto = alto;}
	public void setNombre(String nombre) {this.nombre = nombre;}
}
