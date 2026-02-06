package ejercicio6;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

	/**
	 * Variables de instancia
	 */
	private byte numClase;
	private String nombre, apellido1, apellido2;
	private Calendar fecNac1;  // Fecha que funciona con cualquier versión Java
	private LocalDate fecNac2; // Fecha a partir de Java8
	private String domicilio;
	private String dni;
	
	/**
	 * Constructor
	 * @param numClase
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param fecNac1
	 * @param fecNac2
	 * @param domicilio
	 * @param dni
	 */
	public Alumno(byte numClase, String nombre, String apellido1, String apellido2, 
			      String fecNac, String domicilio, String dni) {
		super();
		this.numClase = numClase;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.domicilio = domicilio;
		this.dni = dni;

		// Validar la fecha en cualquier versión (Calendar)
		if (LibreriaFechas.esFechaCorrecta(fecNac))  // Fecha correcta
			this.fecNac1 = LibreriaFechas.convierteFechaStringACalendar(fecNac);
		else  // Fecha incorrecta (guardaremos la fecha actual, posteriormente se modificará)
			this.fecNac1 = GregorianCalendar.getInstance();  
	
	    // NOTA!!! He intentado que si la fecha de nacimiento no era correcta lanzar
	    // una excepción, y guardar la fecha actual, pero no ha funcionado, ya
	    // que no crea el objeto y lo deja a NULL. Por lo que he investigado parece
	    // que por ahí los "atacantes" de nuestro código encuentran una vulnerabilida.
    	// Aunque el objeto se inicializa sólo parcialmente, el atacante todavía puede
	    // invocar métodos en ella (eludiendo as� la comprobación SecurityManager).

		if (LibreriaFechasJava8.isFechaCorrecta(fecNac))  //Fecha correcta
			this.fecNac2 = LibreriaFechasJava8.convierteStringToLocalDate(fecNac);
		else
			this.fecNac2 = LocalDate.now();
	}
	
	/**
	 * M�todos get y set
	 */
	public byte getNumClase() {return numClase;}
	public String getNombre() {return nombre;}
	public String getApellido1() {return apellido1;}
	public String getApellido2() {return apellido2;}
	public String getDomicilio() {return domicilio;}
	public String getDni() {return dni;}
	public Calendar getFecNac1() {return fecNac1;}
	public LocalDate getFecNac2() {return fecNac2;}
	
	public void setNumClase(byte numClase) {this.numClase = numClase;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido1(String apellido1) {this.apellido1 = apellido1;}
	public void setApellido2(String apellido2) {this.apellido2 = apellido2;}
	public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
	public void setDni(String dni) {this.dni = dni;}
	public void setFecNac1(Calendar fecNac1) {this.fecNac1 = fecNac1;}
	public void setFecNac2(LocalDate fecNac2) {this.fecNac2 = fecNac2;}

	
	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString(){
		return "ALUMNO "+this.numClase+": "+
	                     this.apellido1+" "+
				         this.apellido2+", "+
	                     this.nombre +
			   " -- Edad: "+ LibreriaFechas.getEdad(fecNac1) + "," +          
			   			  	 LibreriaFechasJava8.getEdad(fecNac2) + 
			   " -- Domicilio: "+this.domicilio +
			   " -- DNI: " + this.dni + "\n";
	}
	
	/**
	 * Método que devuelve la información de un alumno de forma más detallada
	 * @return
	 */
	public String toStringCompleto() {
		return "\nNúmero de clase: " + this.numClase +
			   "\nPrimer apellido: " + this.apellido1 +
			   "\nSegundo apellido: " + this.apellido2 +
			   "\nNombre: " + this.nombre +
			   "\nEdad: " +
			            LibreriaFechas.getEdad(fecNac1) + "," +
			   			LibreriaFechasJava8.getEdad(fecNac2) + 
			   
			   "\nFecha de nacimiento (cualquier versión): " +
			                LibreriaFechas.getFechaFull(fecNac1) + 
			   "\nFecha de nacimiento (versi�n 8): " + 
			                LibreriaFechasJava8.getFechaFull(fecNac2) +
			   "\nDomicilio: " + this.domicilio +
			   "\nDNI: " + this.dni + "\n";
	}

	/**
	 * Método que devuelve una cadena con la fecha de nacimiento y el nombre
	 */
	public String toStringFechaNombre() {
		
		return LibreriaFechasJava8.getFechaShort(fecNac2) + " " + 
		       this.apellido1 + " " + this.apellido2 + ", " + this.nombre;
		
	}

	/**
	 * Establecer el orden natural
	 * Por este orden: Apellido1 – Apellido2 – Nombre – DNI
	 */
	@Override
	public int compareTo(Alumno o) {
	
		int compara = this.apellido1.compareTo(o.getApellido1());
		if (compara!=0) // El apellido 1 es diferente
			return compara;
		
		compara = this.apellido2.compareTo(o.getApellido2());
		if (compara!=0) // El apellido 2 es diferente
			return compara;

		compara = this.nombre.compareTo(o.getNombre());
		if (compara!=0) // El nombre es diferente
			return compara;
		
		return this.dni.compareTo(o.getDni());

		
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}


	
	
	
}
