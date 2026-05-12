package _12FicherosXML;

// import javax.xml.bind.annotation.*;  // Este paquete desaparecio en la version 11 de Java


// @XmlRootElement(name="socio")  // El elemento raiz se llamara socio
public class Socio {

	/**
	 * Variables de instancia
	 */
	private Integer identificacion;
	private String nombreSocio;
	private String direccion;
	private String fechaAlta;
	
	/**
	 * Constructor
	 * @param identificacion
	 * @param nombreSocio
	 * @param direccion
	 * @param fechaAlta
	 */
	public Socio(Integer identificacion, String nombreSocio, String direccion, String fechaAlta) {
		super();
		this.identificacion = identificacion;
		this.nombreSocio = nombreSocio;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
	}

	
	/**
	 * Methods getter's and setter's
	 */
	public Integer getIdentificacion() {return identificacion;}
	public String getNombreSocio() {return nombreSocio;}
	public String getDireccion() {return direccion;}
	public String getFechaAlta() {return fechaAlta;}

	public void setIdentificacion(Integer identificacion) {this.identificacion = identificacion;}
	public void setNombreSocio(String nombreSocio) {this.nombreSocio = nombreSocio;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	public void setFechaAlta(String fechaAlta) {this.fechaAlta = fechaAlta;}
	
	
	/**
	 * Redefinicion de toString
	 */
	@Override
	public String toString() {
		return "Socio [identificacion=" + identificacion + ", nombreSocio=" + nombreSocio + ", direccion=" + direccion
				+ ", fechaAlta=" + fechaAlta + "]";
	}

	
	
}
