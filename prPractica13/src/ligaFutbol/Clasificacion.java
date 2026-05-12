package ligaFutbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clasificacion {

	private List<Equipo> equipos;
	private List<Partido> partidos;

	public Clasificacion() {
		this.equipos = new ArrayList<>();
		this.partidos = new ArrayList<>();
	}

	/**
	 * Añadir un nuevo equipo
	 */
	public void añadirEquipo(Equipo equipo) {
		if (!equipos.contains(equipo)) {
			equipos.add(equipo);
		}
	}

	/**
	 * Buscar un equipo por nombre
	 */
	private Equipo buscarEquipo(String nombre) {
		for (Equipo e : equipos) {
			if (e.getNombreEquipo().equalsIgnoreCase(nombre)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Añadir un partido y actualizar estadísticas
	 */
	public void añadirPartido(Partido partido) {
		partidos.add(partido);

		Equipo local = buscarEquipo(partido.getEquipoLocal().getNombreEquipo());
		Equipo visitante = buscarEquipo(partido.getEquipoVisitante().getNombreEquipo());

		if (local == null || visitante == null) return; // seguridad

		int golesLocal = partido.getGolesLocal();
		int golesVisitante = partido.getGolesVisitante();

		// Actualizamos goles
		local.incrementaNumGolesMarcados(golesLocal);
		local.incrementaNumGolesRecibidos(golesVisitante);

		visitante.incrementaNumGolesMarcados(golesVisitante);
		visitante.incrementaNumGolesRecibidos(golesLocal);

		// Actualizamos resultados de partidos
		if (golesLocal > golesVisitante) {
			local.incrementaNumPartidosGanados();
			visitante.incrementaNumPartidosPerdidos();
		} else if (golesLocal == golesVisitante) {
			local.incrementaNumPartidosEmpatados();
			visitante.incrementaNumPartidosEmpatados();
		} else {
			local.incrementaNumPartidosPerdidos();
			visitante.incrementaNumPartidosGanados();
		}
	}

	/**
	 * Mostrar clasificación ordenada
	 */
	public void mostrarClasificacion() {
		List<Equipo> copia = new ArrayList<>(equipos);

		// Ordenar según criterio: puntos desc, diferencia goles desc, nombre asc
		Collections.sort(copia, (e1, e2) -> {
			int cmp = Integer.compare(e2.puntosAcumuladosEquipo(), e1.puntosAcumuladosEquipo());
			if (cmp != 0) return cmp;

			int difGoles1 = e1.getNumGolesMarcados() - e1.getNumGolesRecibidos();
			int difGoles2 = e2.getNumGolesMarcados() - e2.getNumGolesRecibidos();
			cmp = Integer.compare(difGoles2, difGoles1);
			if (cmp != 0) return cmp;

			return e1.getNombreEquipo().compareToIgnoreCase(e2.getNombreEquipo());
		});

		System.out.println("CLASIFICACION");
		System.out.println("PJ PG PE PP GF GC Puntos Equipo");
		for (Equipo e : copia) {
			System.out.println(e.toStringLineal());
		}
	}

	/**
	 * Mostrar partidos de una fecha concreta
	 */
	public void mostrarPartidosPorFecha(LocalDate fecha) {
		System.out.println("Partidos jugados el " + fecha);
		for (Partido p : partidos) {
			if (p.getFechaPartido().equals(fecha)) {
				System.out.println(p);
			}
		}
	}

}