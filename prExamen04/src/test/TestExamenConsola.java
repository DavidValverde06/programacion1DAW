package test;

import java.util.*;
import modelo.*;

public class TestExamenConsola {

	public static void main(String[] args) {

		System.out.println("=== Registro Mantenimiento ===");

		try {
			RegistroMantenimiento mantenimiento1 = new RegistroMantenimiento("12/05/2026",
					EnumTipoIntervencion.PODA_DE_FORMACION, "Era necesaria para mejorar la estética");
			RegistroMantenimiento mantenimiento2 = new RegistroMantenimiento("15/01/2025",
					EnumTipoIntervencion.TRASPLANTE, "Se cambia a una maceta mayor, y también su ubicación");
			RegistroMantenimiento mantenimiento3 = new RegistroMantenimiento("15/01/2024",
					EnumTipoIntervencion.TRASPLANTE, "Se cambia a una maceta mayor, y también su ubicación");

			System.out.println(mantenimiento1);
			System.out.println(mantenimiento2 + "\n");

			System.out.println("\n=== Plantas (Plantas Estandar y Bonsáis) ===");
			SortedSet<RegistroMantenimiento> historialMantenimiento = new TreeSet<RegistroMantenimiento>();
			historialMantenimiento.add(mantenimiento1);
			historialMantenimiento.add(mantenimiento2);

			PlantaEstandar planta1 = new PlantaEstandar("EST010", "Geranio Común", 5.5, 40, "Exterior", true);
			PlantaEstandar planta2 = new PlantaEstandar("EST015", "Amapola Común", 5.5, 1, "Exterior", true);
			PlantaEstandar planta3 = new PlantaEstandar("BON013", "Haya Europea", 38, 8, "Interior", false);

			Bonsai bonsai1 = new Bonsai("BON002", "Pino Blanco Japones", 280.0, 2, 25,
					EnumEstiloBonsai.CHOKKAN, historialMantenimiento);

			bonsai1.añadirMantenimientoHistorial(mantenimiento3);
			bonsai1.añadirMantenimientoHistorial("12/05/2023",EnumTipoIntervencion.INJERTO,"Era necesario un injerto");

			System.out.println(planta1 + "\n");
			System.out.println(planta3 + "\n");
			System.out.println(bonsai1 + "\n");

			historialMantenimiento.removeAll(historialMantenimiento);

			System.out.println(bonsai1 + "\n");

			System.out.println("\n=== Gestor Vivero ===");

			GestorVivero miVivero = new GestorVivero("Plantas");

			miVivero.añadirNuevaPlanta(planta2);

			System.out.println("\n" + miVivero.getCatalogo());

			miVivero.añadirNuevaPlanta(planta1);
			miVivero.añadirNuevaPlanta(planta2);

			System.out.println("\n" + miVivero.getCatalogo());

			miVivero.vuelcaCatalogoResumen();
		}
		catch (MiExcepcion e) {
			System.out.println(e.getMessage());
		}
	}

}
