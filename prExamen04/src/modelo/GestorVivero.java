package modelo;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;

public class GestorVivero {

	/**
	 * Variables de instancia
	 */
	private TreeMap<String, Planta> coleccionPlantas;

	/**
	 * Cosntructor
	 */
	public GestorVivero(String nombreFichero) {
		this.coleccionPlantas = new TreeMap<>();

		String cadena;
		Path rutaFichero = Path.of("./files/" + nombreFichero + ".txt");

		try (BufferedReader flujoLectura = new BufferedReader(
				new FileReader(
						rutaFichero.toFile()))) {

			while ((cadena = flujoLectura.readLine()) != null) {
				String[] partes = cadena.split(",");

				if (partes.length == 6) {
					PlantaEstandar planta = new PlantaEstandar(partes[0], partes[1], Double.valueOf(partes[2]),
							Integer.valueOf(partes[3]), partes[4], Boolean.valueOf(partes[5]));

					coleccionPlantas.put(partes[0].trim(),planta);
				}

				if (partes.length == 7) {

					SortedSet<RegistroMantenimiento> historialMantenimiento = new TreeSet<>();

					String[] historial = partes[6].split("-");

					Bonsai bonsai = new Bonsai(partes[0], partes[1], Double.valueOf(partes[2]),
							Integer.valueOf(partes[3]), Integer.valueOf(partes[4]), EnumEstiloBonsai.valueOf(partes[5]),
							historialMantenimiento);

					bonsai.añadirMantenimientoHistorial(historial[0], EnumTipoIntervencion.valueOf(historial[1]), historial[2]);

					coleccionPlantas.put(partes[0].trim(),bonsai);
				}
			}
		}
		catch (FileNotFoundException e) {
		}
		catch (IOException e) {
		}
	}

	public GestorVivero(TreeMap<String, Planta> coleccionPlantas) {
		this.coleccionPlantas = coleccionPlantas;
	}

	/**
	 * Getter y Setter
	 */
	public TreeMap<String, Planta> getColeccionPlantas() {return coleccionPlantas;}
	public void setColeccionPlantas(TreeMap<String, Planta> coleccionPlantas) {this.coleccionPlantas = coleccionPlantas;}

	/**
	 * Método añadir una nueva planta o plantas a nuestro vivero
	 */
	public void añadirNuevaPlanta(Planta planta) {
		boolean encontrado=false;
		for (Entry<String, Planta> plantaExistente : coleccionPlantas.entrySet()) {
			if (planta.getIdPlanta().equals(plantaExistente.getValue().getIdPlanta())) {
				int stockActual = plantaExistente.getValue().getStockDisponible();
				plantaExistente.getValue().setStockDisponible(stockActual++);
				encontrado=true;
			}

		}
		if (encontrado==false) {
			coleccionPlantas.put(planta.getIdPlanta(), planta);
		}
	}

	public void añadirNuevaPlanta(Planta planta, int numEjemplares) {
		boolean encontrado=false;
		for (Entry<String, Planta> plantaExistente : coleccionPlantas.entrySet()) {
			if (planta.getIdPlanta().equals(plantaExistente.getValue().getIdPlanta())) {
				int stockActual = plantaExistente.getValue().getStockDisponible();
				plantaExistente.getValue().setStockDisponible(stockActual+=numEjemplares);
				encontrado=true;
			}
		}
		if (encontrado==false) {
			coleccionPlantas.put(planta.getIdPlanta(), planta);
		}
	}

	/**
	 * Método para vender plantas
	 * @throws MiExcepcion 
	 */
	public boolean venderPlanta(String idPlanta, int numPlantasVender) throws MiExcepcion {
		if (buscarPlanta(idPlanta).getStockDisponible() > 0) {
			coleccionPlantas.remove(idPlanta, coleccionPlantas.get(idPlanta));
			return true;
		}
		else {
			throw new MiExcepcion("No queda stock de esa planta");
		}
	}

	/**
	 * Método para buscar plantas por ID
	 * @throws MiExcepcion 
	 */
	public Planta buscarPlanta(String idPlanta) throws MiExcepcion {
		if (coleccionPlantas.containsKey(idPlanta)) {
			return coleccionPlantas.get(idPlanta);
		}
		else {
			throw new MiExcepcion("No se encontró ninguna planta con el ID " + idPlanta);
		}
	}

	/**
	 * String getCatalogo()
	 */
	public String getCatalogo() {
		String cadena = "";
		for (Entry<String, Planta> planta : coleccionPlantas.entrySet()) {
			cadena += "\n" + planta.getValue().toStringLineal();
		}

		return "=== CATÁLOGO DEL VIVERO ===" + cadena;
	}

	/**
	 * Método que devuelve una coleccion tipo List, con todas las plantas
	 */
	public List<Planta> todasLasPlantas() {
		List<Planta> plantas = new ArrayList<>();

		return plantas;
	}

	/**
	 * Método que devuelve una coleccion tipo List, con todos los bonsáis
	 */
	public List<Planta> todosLosBonsais() {
		List<Planta> bonsais = new ArrayList<>();

		return bonsais;
	}

	/**
	 * Método que devuelve una coleccion tipo List, con todas las plantas estandar
	 */
	public List<Planta> todasLasPlantasEstandar() {
		List<Planta> plantasEstandar = new ArrayList<>();

		return plantasEstandar;
	}

	/**
	 * Método que vuelca a un fichero llamado "CatalogoResumen.txt", el resumen de catálogo 
	 */
	public void vuelcaCatalogoResumen() {
		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(new File("./files/CatalogoResumen.txt")))) {
			flujoEscritura.write(getCatalogo());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
