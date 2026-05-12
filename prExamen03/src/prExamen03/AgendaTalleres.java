package prExamen03;

import java.util.SortedSet;
import java.util.TreeSet;

public class AgendaTalleres {

	// Listas de datos para la generación aleatoria
	private static final String[] NOM_TALLER = 
		{"Taller de Java", "Cosplay 101", "Arduino Avanzado", "Pixel Art", "Unity 3D", "Seguridad Web", "Historia del comic"};

	private static final String[] PONENTES = 
		{"Marina Molina", "Iñigo González", "Susan Japón", "Miriam García", "Frank Santaolalla", "Pepe Ferrer"};

	/**
	 * Variables de instancia
	 */
	private Taller[][] talleresProgramados;

	/**
	 * Constructor
	 */
	public AgendaTalleres() {

		this.talleresProgramados = new Taller[5][6];

		for (int fil=0;fil<talleresProgramados.length;fil++) {
			for (int col=0;col<talleresProgramados[fil].length;col++) {
				String nombreTalleres = getNomTaller()[(int)(Math.random()*NOM_TALLER.length)];
				String ponentes = getPonentes()[(int)(Math.random()*PONENTES.length)];
				EnumTematica tematica = EnumTematica.values()[(int)(Math.random()*EnumTematica.values().length)];
				int numeroMaxAsistentes = (int)(Math.random()*21)+10; // Entre 10 y 30

				int probabilidad = (int)(Math.random()*10);

				if (probabilidad<7) {
					Taller tallerRandom = new Taller(nombreTalleres, ponentes, tematica, numeroMaxAsistentes);
					talleresProgramados[fil][col] = tallerRandom;
				}
			}
		}

	}

	/**
	 * Getter's y setter's
	 */
	public Taller[][] getTalleresProgramados() {return talleresProgramados;}
	public void setTalleresProgramados(Taller[][] talleresProgramados) {this.talleresProgramados = talleresProgramados;}

	public static String[] getNomTaller() {return NOM_TALLER;}

	public static String[] getPonentes() {return PONENTES;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		String cadena = "* * * INFORMACIÓN DETALLADA DEL EVENTO * * *";
		for (int fil=0;fil<talleresProgramados.length;fil++) {
			cadena += "\nDía " + (fil+1);
			for (int col=0;col<talleresProgramados[fil].length;col++) {
				if (talleresProgramados[fil][col]!=null) {
					cadena += "\n\t" + talleresProgramados[fil][col];
				}
			}
		}
		return cadena;
	}

	/**
	 * Método que se encargará de colocar un taller en el hueco especificado (día y franja horaria),
	 * si está libre
	 */
	public boolean asignarTaller(int dia, int franja, Taller t) {
		boolean añadido=false;
		for (int fil=0;fil<talleresProgramados.length;fil++) {
			for (int col=0;col<talleresProgramados[fil].length;col++) {
				if (fil == dia-1 && col == franja-1 && talleresProgramados[fil][col]==null) {
					talleresProgramados[fil][col] = t;
					añadido=true;
				}
			}
		}
		if (añadido==true) {
			return true;
		}
		return false;
	}

	/**
	 * Método que devuelve un String con un formato más resumido de la agenda
	 */
	public String generarInformaOcupacion() {
		String cadena = "* * * ESTADO ACTUAL DE LA AGENDA * * *";
		for (int fil=0;fil<talleresProgramados.length;fil++) {
			cadena += "\nDía " + (fil+1) + ":";
			for (int col=0;col<talleresProgramados[fil].length;col++) {
				if (talleresProgramados[fil][col]==null) {
					cadena += " [---]";
				}
				if (talleresProgramados[fil][col]!=null) {
					cadena += " [" + talleresProgramados[fil][col].getNombreTaller() + "]";
				}
			}
		}
		return cadena;
	}

	/**
	 * Método que devuelve un conjunto ordenado de los talleres programados, cuya tematica
	 * coincida con la especificada. El orden del conjunto debe ser el orden natural (Comparable),
	 * que será por nombre del taller, y si este se repite por ponente;
	 */
	public SortedSet<Taller> buscarTalleresPorTematica(EnumTematica tematica) {
		SortedSet<Taller> listaTalleresOrdenada = new TreeSet<>();

		for (int fil=0;fil<talleresProgramados.length;fil++) {
			for (int col=0;col<talleresProgramados[fil].length;col++) {
				if (talleresProgramados[fil][col]!=null) {
					if (talleresProgramados[fil][col].getTematicaTaller().equals(tematica)) {
						listaTalleresOrdenada.add(talleresProgramados[fil][col]);
					}
				}
			}
		}

		return listaTalleresOrdenada;
	}
}
