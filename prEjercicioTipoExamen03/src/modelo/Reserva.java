package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * E) Clase Reserva, sobre una reserva queremos guardar, el alojamiento reservado, las fechas de inicio y de
 * fin de la reserva, el número de noches, y el nombre, DNI y teléfono de la persona que la realiza. Esta clase
 * deberá aportar, al menos, los siguientes métodos:
 * 
 * • Constructor, se deberá validar, que la fecha de inicio sea correcta, la de fin la calcularemos a partir del
 * número de noches indicado. Además, el DNI se podrá dejar en blanco, pero si se indica, este deberá
 * estar validado correctamente. Si la fecha o el DNI no son correctos, se debe lanzar una excepción, por
 * tanto, el objeto no se creará.
 * 
 * • Métodos get, set.
 * 
 * • Método que nos devuelva un String con la temporada de la reserva, esta podrá ser Baja, Media o Alta.
 * Se considera temporada alta los meses de julio y agosto, media los meses de septiembre, octubre,
 * febrero, marzo, abril y mayo, y temporada baja los meses de noviembre, diciembre y enero.
 * 
 * • Un método que nos devuelva el factor a aplicar a una reserva, en función de su temporada, este factor
 * será de 1 en temporada baja, de 1.5 en temporada media, y de 2 en temporada alta. Es decir, a modo
 * de ejemplo la misma reserva costará el doble en temporada alta que baja.
 * 
 * • Un método que nos calcule el precio final de una reserva, teniendo en cuenta el alojamiento, el número
 * de noches de la reserva, y la temporada.
 * 
 * • Método para poder comparar reservas, dos reservas se considerarán iguales si coincide la fecha de
 * inicio y el alojamiento.
 * 
 * • Método toString, con un formato de salida similar a:
 * 		Datos alquiler:
 * 				Alojamiento: Casa Conchita
 * 				Fecha inicio: 15/08/2025
 * 				Fecha fin: 21/08/2025
 * 				Número de noches: 6
 * 				Cliente: Manuel Campos
 * 				DNI: 31171876E
 * 				Teléfono contacto: 600200800
 * 				Precio final: 684.0€ (Temporada Alta)
 */
public class Reserva {

	/**
	 * Variables de instancia
	 */
	private Alojamiento alojamientoReservado;
	private LocalDate fechaInicio, fechaFin;
	private int numNoches;
	private String nombre,dni,telefono;

	/**
	 * Constructor
	 * 
	 * Se deberá validar, que la fecha de inicio sea correcta, la de fin la calcularemos a partir del
	 * número de noches indicado. Además, el DNI se podrá dejar en blanco, pero si se indica, este deberá
	 * estar validado correctamente. Si la fecha o el DNI no son correctos, se debe lanzar una excepción, por
	 * tanto, el objeto no se creará.
	 * 
	 * @throws MiExcepcion
	 */
	public Reserva(Alojamiento alojamientoReservado, String fechaInicio, int numNoches,
			String nombre, String dni, String telefono) throws MiExcepcion {

		if (LibFechas8.isFechaCorrecta(fechaInicio) == false) {
			throw new MiExcepcion("Fecha no válida");
		}
		if (dni.matches("[0-9]{9}[A-Z]{1}")) {
			throw new MiExcepcion("DNI no válido");
		}
		this.alojamientoReservado = alojamientoReservado;
		this.fechaInicio = LibFechas8.convierteStringToLocalDate(fechaInicio);
		this.fechaFin = LibFechas8.sumaDias(this.fechaInicio, numNoches);
		this.numNoches = numNoches;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Reserva(Alojamiento alojamientoReservado, String fechaInicio, int numNoches,
			String nombre, String telefono) throws MiExcepcion {

		if (LibFechas8.isFechaCorrecta(fechaInicio) == false) {
			throw new MiExcepcion("Fecha no válida");
		}

		this.alojamientoReservado = alojamientoReservado;
		this.fechaInicio = LibFechas8.convierteStringToLocalDate(fechaInicio);
		this.fechaFin = LibFechas8.sumaDias(this.fechaInicio, numNoches);
		this.numNoches = numNoches;
		this.nombre = nombre;
		this.dni = "";
		this.telefono = telefono;
	}

	/**
	 * Getter y Setter
	 */
	public Alojamiento getAlojamientoReservado() {return alojamientoReservado;}
	public void setAlojamientoReservado(Alojamiento alojamientoReservado) {this.alojamientoReservado = alojamientoReservado;}

	public LocalDate getFechaInicio() {return fechaInicio;}
	public void setFechaInicio(LocalDate fechaInicio) {this.fechaInicio = fechaInicio;}

	public LocalDate getFechaFin() {return fechaFin;}
	public void setFechaFin(LocalDate fechaFin) {this.fechaFin = fechaFin;}

	public int getNumNoches() {return numNoches;}
	public void setNumNoches(int numNoches) {this.numNoches = numNoches;}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}

	public String getTelefono() {return telefono;}
	public void setTelefono(String telefono) {this.telefono = telefono;}

	/**
	 * Método que nos devuelva un String con la temporada de la reserva, esta podrá ser Baja, Media o Alta.
	 * Se considera temporada alta los meses de julio y agosto, media los meses de septiembre, octubre,
	 * febrero, marzo, abril y mayo, y temporada baja los meses de noviembre, diciembre y enero.
	 */
	public String temporadaReserva() {
		if (fechaInicio.getMonthValue() == 7 || fechaInicio.getMonthValue() == 8) {
			return "Alta";
		}
		else if (fechaInicio.getMonthValue() == 11 || fechaInicio.getMonthValue() == 12 || fechaInicio.getMonthValue() == 1) {
			return "Baja";
		}
		else {
			return "Media";
		}
	}

	/**
	 * Un método que nos devuelva el factor a aplicar a una reserva, en función de su temporada, este factor
	 * será de 1 en temporada baja, de 1.5 en temporada media, y de 2 en temporada alta. Es decir, a modo
	 * de ejemplo la misma reserva costará el doble en temporada alta que baja.
	 */
	public float factorReserva() {
		if (temporadaReserva().equals("Alta")) {
			return 2f;
		}
		else if (temporadaReserva().equals("Media")) {
			return 1.5f;
		}
		else {
			return 1f;
		}
	}

	/**
	 * Un método que nos calcule el precio final de una reserva, teniendo en cuenta el alojamiento, el número
	 * de noches de la reserva, y la temporada. 
	 */
	public float precioFinalReserva() {
		return alojamientoReservado.calculaPrecioAlojamiento(numNoches) * factorReserva();
	}

	/**
	 * equals y hashCode
	 * 
	 * Método para poder comparar reservas, dos reservas se considerarán iguales si coincide la fecha de
	 * inicio y el alojamiento. 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(alojamientoReservado, fechaInicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(alojamientoReservado, other.alojamientoReservado)
				&& Objects.equals(fechaInicio, other.fechaInicio);
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Datos alquiler:" +
				"\n\tAlojamiento: " + alojamientoReservado.getNombre() +
				"\n\tFecha inicio: " + fechaInicio +
				"\n\tFecha fin: " + fechaFin +
				"\n\tNúmero de noches: " + numNoches +
				"\n\tCliente: " + nombre +
				"\n\tDNI: " + dni +
				"\n\tTeléfono contacto: " + telefono +
				"\n\tPrecio final: " + precioFinalReserva() + "€ (Temporada " + temporadaReserva() +")";
	}

}
