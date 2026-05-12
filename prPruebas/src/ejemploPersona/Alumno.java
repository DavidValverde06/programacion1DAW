package ejemploPersona;

/**
 * Clase Alumno, contiene la información y los métodos para manejarla sobre un alumno
 */
public class Alumno {

	/*
	 * Variables de clase
	 */
	private static long idProximoAlumno=2900114500L; // Esta variable guardara el id del siguiente alumno

	public static final float SEGUROESCOLAR_MENOR=1.12f;
	public static final float SEGUROESCOLAR_MAYOR=10.90f;


	/*
	 * Variables de instancia
	 */
	private long idAlumno; // Identficador del alumno, será único
	private String nombre;
	private byte edad;
	private String curso; // 1º DAW, 2º SMR, ...

	/*
	 * Constructor
	 */
	public Alumno(String nombreAlumno, byte edadAlumno, String cursoAlumno) {

		// Asignaremos a las variables de instancia el valor de los parametros recibidos
		this.nombre = nombreAlumno;
		this.edad = edadAlumno;
		this.curso = cursoAlumno;
		//		idProximoAlumno++; Incrementamos la variable de clase en 1, para asignar el número a este alumno
		Alumno.idProximoAlumno++;

		this.idAlumno = idProximoAlumno;
	}

	public Alumno(String nombreAlumno, byte edadAlumno) {

		this(nombreAlumno,edadAlumno, "Sin asignar");

		//		this.nombre = nombreAlumno;
		//		this.edad = edadAlumno;
		//		this.curso = cursoAlumno;
	}

	public Alumno() {

	}

	/**
	 *  Métodos getter's
	 */
	public long getIdAlumno() {
		return this.idAlumno;
	}
	public String getNombre() {
		return this.nombre;
	}
	public byte getEdad() {
		return this.edad;
	}
	public String getCurso() {
		return this.curso;
	}

	/**
	 *  Métodos setter's (permiten modificar el valor de las variables de instancia)
	 */
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Redefinicion del metodo toString que ya está definido en la clase Object
	 */
	@Override
	public String toString() {
		return  "\n\tId: " + this.idAlumno +
				"\n\tNombre: " + this.nombre +
				"\n\tEdad: " + this.edad +
				"\n\tCurso: " + this.curso +
				"\n";
	}

	/*
	 * Método para saber si un alumno es mayor o menor de edad
	 */
	public boolean esMayorDeEdad() {
		if (this.edad>=18) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Método que calcula el coste de la matricula
	 */
	public float costeMatricula() {
		
		float coste = 300;
		
		if (esMayorDeEdad()) {
			coste += SEGUROESCOLAR_MAYOR;
		}
		else {
			coste += SEGUROESCOLAR_MENOR;
		}
		
		return coste;
	}

}
