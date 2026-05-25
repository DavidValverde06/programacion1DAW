package modelo;

import java.util.*;

/**
 * B) AgendaCitas, en esta clase recogeremos las distintas citas de la clínica en una colección tipo List. Los
 * métodos que debe proporcionar esta clase como mínimo serán:
 * - Constructor
 * 
 * - Métodos get y toString.
 * 
 * - Método que permita añadir una nueva cita.
 * 
 * - Un método que permita ordenar la agenda de citas siguiendo los siguientes criterios: en primer
 * lugar por prioridad (de mayor a menor), en caso de estar repetida por hora de la consulta (de
 * menor a mayor), y en caso de haber más de un paciente con la misma prioridad y hora, por el
 * nombre del paciente.
 * 
 * - Un método que permita obtener lo recaudado hasta el momento con las citas guardadas en la
 * colección
 */
public class AgendaCitas {

	/**
	 * Variables de instancia
	 */
	private List<CitaMedica> listaCitas;

	/**
	 * Constructor
	 */
	public AgendaCitas() {
		this.listaCitas = new ArrayList<>();
	}

	/**
	 * Getter's
	 */
	public List<CitaMedica> getListaCitas() {return listaCitas;}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "AgendaCitas [listaCitas=" + listaCitas + "]";
	}

	/**
	 * Método que permita añadir una nueva cita.
	 */
	public boolean añadirCita(CitaMedica citaMedica) {
		return listaCitas.add(citaMedica);
	}

	/**
	 * Un método que permita ordenar la agenda de citas siguiendo los siguientes criterios: en primer
	 * lugar por prioridad (de mayor a menor), en caso de estar repetida por hora de la consulta (de
	 * menor a mayor), y en caso de haber más de un paciente con la misma prioridad y hora, por el
	 * nombre del paciente.
	 */
	public List<CitaMedica> ordenarAgendaMedica() {
		List<CitaMedica> listadoOrdenado = new ArrayList<>(this.listaCitas);
		listadoOrdenado.sort(new ComparatorPrioridadHoraNombre());
		return listadoOrdenado;
	}

	/**
	 * Un método que permita obtener lo recaudado hasta el momento con las citas guardadas en la
	 * colección
	 */
	public float obtenerRecaudado() {
		float recaudado=0;
		for (CitaMedica citaMedica : listaCitas) {
			recaudado+=citaMedica.devuelvePrecioCita();
		}
		return recaudado;
	}

}
