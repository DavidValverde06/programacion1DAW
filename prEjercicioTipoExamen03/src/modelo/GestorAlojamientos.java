package modelo;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase GestorAlojamientos, en esta clase almacenaremos dos colecciones:
 * 
 * • Una con los Alojamientos disponibles que se almacenarán en una colección tipo List.
 * • Y otra con las Reservas realizadas y que esté ordenada por Alojamiento, y si este se repite por Fecha
 * de inicio, no podremos tener reservas repetidas.
 * 
 * Esta clase nos debe proporcionar los siguientes métodos:
 * 
 * • Constructor, estará sobrecargado, ya que podremos crear las dos colecciones vacías, o bien los
 * alojamientos cargarlos desde un fichero de los facilitados en el examen. Tenéis 3 ficheros desde los
 * que podéis sacar datos de alojamientos, uno de texto (Alojamientos.txt), otro con una serie de objetos
 * tipo Alojamiento (Alojamientos.dat), y otro con una colección tipo List, con una serie de alojamientos
 * en su interior (ACollection.dat). Podéis elegir el archivo que queráis.
 * 
 * • Métodos get y set.
 * 
 * • Un método que permita añadir un nuevo alojamiento a la colección de alojamientos.
 * 
 * • Un método que permita añadir una nueva reserva a la colección de reservas. No se podrá realizar una
 * reserva si su fecha de inicio es anterior a la fecha actual, así como si se solapa con alguno de los días
 * (aunque sea de salida) de otra reserva previa.
 * 
 * • Un método sobrecargado que nos devuelva una colección con los nombres de todos los alojamientos
 * de la ubicación especificada, y si no se especifica ubicación, se devolverá la colección con los nombres
 * de todos los alojamientos disponibles.
 * 
 * • Un método que nos permita buscar un alojamiento a partir de su nombre.
 */
public class GestorAlojamientos {

	/**
	 * Variables de instancia
	 */
	private List<Alojamiento> alojamientosDisponibles;
	private SortedSet<Reserva> reservasRealizadas;

	/**
	 * Constructor sobrecargado
	 * 
	 * Estará sobrecargado, ya que podremos crear las dos colecciones vacías, o bien los
	 * alojamientos cargarlos desde un fichero de los facilitados en el examen.
	 * 
	 * Tenéis 3 ficheros desde los que podéis sacar datos de alojamientos, uno de texto (Alojamientos.txt),
	 * otro con una serie de objetos tipo Alojamiento (Alojamientos.dat), y otro con una colección tipo List,
	 * con una serie de alojamientos en su interior (ACollection.dat). Podéis elegir el archivo que queráis.
	 */

	public GestorAlojamientos() {
		this.alojamientosDisponibles = new ArrayList<>();
		this.reservasRealizadas = new TreeSet<>(new ComparatorNombreFechaInicio());
	}

	public GestorAlojamientos(String nombreFichero) {
		this.alojamientosDisponibles = new ArrayList<>();
		this.reservasRealizadas = new TreeSet<>(new ComparatorNombreFechaInicio());

		try (BufferedReader flujoLecturaAlojamientos = new BufferedReader(
				new FileReader(Path.of("./src/files/" + nombreFichero).toFile()))) {

			String cadena;
			while ((cadena = flujoLecturaAlojamientos.readLine()) != null) {
				String[] partes = cadena.split(",");

				String nombre = partes[0].trim();
				EnumUbicaciones ubicacion = EnumUbicaciones.valueOf(partes[1].trim());
				float precioBase = Float.parseFloat(partes[2].trim());

				// Casa Rural
				if (partes.length == 4) {
					int numHabitaciones = Integer.parseInt(partes[3].trim());
					this.alojamientosDisponibles.add(new CasaRural(nombre, ubicacion, precioBase, numHabitaciones));
				}
				// Apartamento Rural
				if (partes.length == 5) {
					boolean tieneCocina = Boolean.parseBoolean(partes[3].trim());
					boolean tieneParking = Boolean.parseBoolean(partes[4].trim());
					this.alojamientosDisponibles.add(new ApartamentoRural(nombre, ubicacion, precioBase, tieneCocina, tieneParking));
				}
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter y Setter
	 */
	public List<Alojamiento> getAlojamientosDisponibles() {return alojamientosDisponibles;}
	public void setAlojamientosDisponibles(List<Alojamiento> alojamientosDisponibles) {this.alojamientosDisponibles = alojamientosDisponibles;}

	public SortedSet<Reserva> getReservasRealizadas() {return reservasRealizadas;}
	public void setReservasRealizadas(SortedSet<Reserva> reservasRealizadas) {this.reservasRealizadas = reservasRealizadas;}

	/**
	 * Un método que permita añadir un nuevo alojamiento a la colección de alojamientos.
	 */
	public boolean añadirAlojamiento(Alojamiento alojamiento) {
		return this.alojamientosDisponibles.add(alojamiento);
	}

	/**
	 * Un método que permita añadir una nueva reserva a la colección de reservas. No se podrá realizar una
	 * reserva si su fecha de inicio es anterior a la fecha actual, así como si se solapa con alguno de los días
	 * (aunque sea de salida) de otra reserva previa.
	 */
	public boolean añadirReserva(Reserva reserva) throws MiExcepcion {
		if (reserva.getFechaInicio().isBefore(LocalDate.now())) {
			throw new MiExcepcion("La fecha de reserva no puede ser anterior a la fecha actual");
		}

		for (Reserva existente : reservasRealizadas) {
			if (existente.getAlojamientoReservado().equals(reserva.getAlojamientoReservado())) {

				boolean solapa =
						!(reserva.getFechaFin().isBefore(existente.getFechaInicio()) ||
								reserva.getFechaInicio().isAfter(existente.getFechaFin()));

				if (solapa) {
					return false;
				}
			}
		}

		return reservasRealizadas.add(reserva);
	}

	/**
	 * Un método sobrecargado que nos devuelva una colección con los nombres de todos los alojamientos
	 * de la ubicación especificada, y si no se especifica ubicación, se devolverá la colección con los nombres
	 * de todos los alojamientos disponibles.
	 */
	public List<String> getNombresAlojamientos() {
		List<String> lista = new ArrayList<>();

		for (Alojamiento alojamiento : alojamientosDisponibles) {
			lista.add(alojamiento.getNombre());
		}
		return lista;
	}

	public List<String> getNombresAlojamientos(String ubicacion) {
		List<String> lista = new ArrayList<>();

		for (Alojamiento alojamiento : alojamientosDisponibles) {
			if (alojamiento.getUbicacion().name().equalsIgnoreCase(ubicacion)) {
				lista.add(alojamiento.getNombre());
			}
		}
		return lista;
	}

	/**
	 * Un método que nos permita buscar un alojamiento a partir de su nombre.
	 */
	public Alojamiento buscarAlojamiento(String nombre) {
		for (Alojamiento alojamiento : alojamientosDisponibles) {
			if (alojamiento.getNombre().equalsIgnoreCase(nombre)) {
				return alojamiento;
			}
		}
		return null;
	}

}
