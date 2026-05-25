package modelo;

import java.text.*;
import java.util.*;

/**
 * A) CitaMedica, sobre una cita nos interesa conocer:
 * 
 * - La prioridad de la cita, siendo 0 la menos prioritaria y 3 la más prioritaria, las citas con prioridad
 * 1, 2 o 3 se considerarán urgentes.
 * 
 * - El número de la Seguridad Social y el nombre del paciente.
 * 
 * - El o los motivos por los que se solicita la cita, podrán ser varios, se guardarán en una colección.
 * 
 * - El especialista al que se deriva (Cardiología, Medicina Interna, ...)
 * 
 * - La hora de la visita (se guardará en formato Calendar).
 * 
 * Esta clase (ver ayuda final sobre manejo de horas) debe proporcionar, al menos, métodos para:
 * 
 * - Constructor sobrecargado, ya que se podrá especificar o no la prioridad, sino se especifica se
 * considerará prioridad 0.
 * 
 * - Método que devuelva el precio de la cita, el cual tendrá un precio base de 100€, dicha cantidad
 * se verá incrementada en 30€ si es para un especialista (cualquier médico que no sea de
 * “Medicina General”). Los precios anteriores además, se verán incrementados cuando se trate de
 * citas urgentes (prioridad de 1, 2 ó 3), las de prioridad 1 en 50€, las de prioridad 2 en 100€ y las
 * de prioridad 3 en 150€.
 * Por ejemplo una cita para Medicina General que no sea urgente, tendrá un coste de 100€, en
 * cambio, una urgente de prioridad 3 para Cardiología, tendrá un coste de 280€ (100 + 30 +
 * 150).
 * 
 * - Redefinición de toString, que devuelva la información de una cita, con un formato parecido a los
 * dos siguientes ejemplos:
 * 		1 - 12:50:00 - 987655 - Felipe Rodríguez - [Fuerte dolor abdominal] - Aparato digestivo - 180
 * 		0 - 09:12:45 - 32322 - María López - [Dolor cabeza, Mareos] - Cardiología - 130
 */
public class CitaMedica {

	/**
	 * Variables de instancia
	 */
	private int prioridadCita;
	private String numSeguridadSocial;
	private String nombrePaciente;
	private ArrayList<String> coleccionMotivos;
	private String especialista;
	private Calendar horaVisita;

	/**
	 * Constructor sobrecargado
	 */
	public CitaMedica(int prioridadCita, String numSeguridadSocial, String nombrePaciente,
			ArrayList<String> coleccionMotivos, String especialista, String horaVisita) {
		this.prioridadCita = prioridadCita;
		this.numSeguridadSocial = numSeguridadSocial;
		this.nombrePaciente = nombrePaciente;
		this.coleccionMotivos = coleccionMotivos;
		this.especialista = especialista;
		this.horaVisita = convierteHoraStringACalendar(horaVisita);
	}

	public CitaMedica(String numSeguridadSocial, String nombrePaciente,
			ArrayList<String> coleccionMotivos, String especialista, String horaVisita) {
		this.prioridadCita = 0;
		this.numSeguridadSocial = numSeguridadSocial;
		this.nombrePaciente = nombrePaciente;
		this.coleccionMotivos = coleccionMotivos;
		this.especialista = especialista;
		this.horaVisita = convierteHoraStringACalendar(horaVisita);
	}

	/**
	 * Getter's
	 */
	public int getPrioridadCita() {return prioridadCita;}
	public String getNumSeguridadSocial() {return numSeguridadSocial;}
	public String getNombrePaciente() {return nombrePaciente;}
	public ArrayList<String> getColeccionMotivos() {return coleccionMotivos;}
	public String getEspecialista() {return especialista;}
	public Calendar getHoraVisita() {return horaVisita;}

	/**
	 * Método que devuelva el precio de la cita, el cual tendrá un precio base de 100€, dicha cantidad
	 * se verá incrementada en 30€ si es para un especialista (cualquier médico que no sea de
	 * “Medicina General”).
	 * Los precios anteriores además, se verán incrementados cuando se trate de
	 * citas urgentes (prioridad de 1, 2 ó 3), las de prioridad 1 en 50€, las de prioridad 2 en 100€ y las
	 * de prioridad 3 en 150€.
	 * Por ejemplo una cita para Medicina General que no sea urgente, tendrá un coste de 100€, en
	 * cambio, una urgente de prioridad 3 para Cardiología, tendrá un coste de 280€ (100 + 30 +
	 * 150).
	 */
	public float devuelvePrecioCita() {
		float precio=100;
		if (!this.especialista.equalsIgnoreCase("Medicina General")) {
			precio+=30;
		}

		switch (this.prioridadCita) {
		case 0 -> precio+=0;
		case 1 -> precio+=50;
		case 2 -> precio+=100;
		case 3 -> precio+=150;
		default -> throw new IllegalArgumentException("Unexpected value: " + this.prioridadCita);
		}

		return precio;
	}

	/**
	 * Redefinición de toString, que devuelva la información de una cita, con un formato parecido a los
	 * dos siguientes ejemplos:
	 * 		1 - 12:50:00 - 987655 - Felipe Rodríguez - [Fuerte dolor abdominal] - Aparato digestivo - 180
	 * 		0 - 09:12:45 - 32322 - María López - [Dolor cabeza, Mareos] - Cardiología - 130
	 */
	@Override
	public String toString() {
		return this.prioridadCita + " - " + toStringHora(this.horaVisita) + " - " +
				this.numSeguridadSocial + " - " + this.nombrePaciente +
				" - " + this.coleccionMotivos.toString() + " - " +
				this.especialista + " - " + devuelvePrecioCita();
	}

	/**
	 * Método que convierte una hora tipo String en un objeto Calendar
	 * Si la hora no es válida, saltará la excepción, y devolverá la hora actual
	 * @param horaString
	 * @return
	 */
	public static Calendar convierteHoraStringACalendar(String horaString) {
		Calendar hora = Calendar.getInstance();
		SimpleDateFormat formatoHora =
				new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
		Date horaDate=null;

		try {
			formatoHora.setLenient(false);
			horaDate = formatoHora.parse(horaString);
			hora.setTime(horaDate);
		}
		catch (ParseException e) {
			System.out.println("Formato de hora no válido");
		}

		return hora;
	}

	/**
	 * Método que devuelve la forma de la visita formateada
	 * @return
	 */
	public static String toStringHora(Calendar hora) {
		DecimalFormat patron = new DecimalFormat("00");

		return patron.format(hora.get(Calendar.HOUR_OF_DAY))+":"+
		patron.format(hora.get(Calendar.MINUTE))+":"+
		patron.format(hora.get(Calendar.SECOND));
	}

}
