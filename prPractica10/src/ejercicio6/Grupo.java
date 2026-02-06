package ejercicio6;

import java.util.*;

public class Grupo {

	/**
	 * Variables de instancia
	 */
	private List<Alumno> miGrupo;
	
	/**
	 * Constructor
	 */
	public Grupo() {
		this.miGrupo = new LinkedList<>();
	}
	
	/**
	 * Método que añade un alumno
	 * @param alum
	 * @return
	 */
	public boolean añadeAlumno(Alumno alum) {
		return this.miGrupo.add(alum);
	}

	
	public List<Alumno> getMiGrupo() {
		return miGrupo;
	}

	public void setMiGrupo(List<Alumno> miGrupo) {
		this.miGrupo = miGrupo;
	}
	
	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		String cad = "\nLISTA DE CLASE" + 
	                 "\n--------------\n";
		
		for (Alumno alumnoClase: miGrupo) {
			cad = cad + alumnoClase.toString();
		}
		       
		return cad;
	}
}




