package modelo;

import java.time.LocalDate;

import fechas.LibFechas8;

public class Disco {

	/**
	 * Variables de instancia
	 */
	private int codigo;
	private String titulo;
	private String autor;
	private LocalDate fechaPubli;
	private double precio;

	
	/**
	 * Constructor
	 * @throws MiExcepcion 
	 */
	public Disco(int codigo, String titulo, String autor, String fechaPubli, double precio) 
			       throws MiExcepcion {
		super();
		
		if (!LibFechas8.isFechaCorrecta(fechaPubli))  // Validar que la fecha sea correcta
			throw new MiExcepcion("Fecha no válida");
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPubli = LibFechas8.convierteStringToLocalDate(fechaPubli);
		this.precio = precio;
	}


	/**
	 * Métodos getter's and setter's
	 */
	public int getCodigo() {return codigo;}
	public String getTitulo() {return titulo;}
	public String getAutor() {return autor;}
	public LocalDate getFechaPubli() {return fechaPubli;}
	public double getPrecio() {return precio;}
	
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setAutor(String autor) {this.autor = autor;}
	public void setFechaPubli(LocalDate fechaPubli) {this.fechaPubli = fechaPubli;}
	public void setPrecio(double precio) {this.precio = precio;}
	
	
	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		return "Disco [codigo=" + codigo + ", titulo=" + titulo + ", autor="
				+ autor + ", año=" + LibFechas8.getFechaShort(fechaPubli) + ", precio=" + precio + "]";
	}
	
}




