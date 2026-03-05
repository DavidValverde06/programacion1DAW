package prExamen03;

public class TestExamen {

	public static void main(String[] args) {

		// CLASES ASISTENTES

		// Asistentes Generales
		AsistenteGeneral asistente1 = new AsistenteGeneral("24000111L", "Pedro", "02/03/2011", "02/03/2026", true);
		AsistenteGeneral asistente2 = new AsistenteGeneral("23999888X", "Beatriz", "02/03/2001", "27/02/2026", false);
		System.out.println("=== Asistentes ===");
		System.out.println(asistente1 + "\n");
		System.out.println(asistente2 + "\n");

		// Asistentes VIP
		AsistenteVIP asistente3 = new AsistenteVIP("25123123P", "Lucía", "02/03/1996", "01/02/2026", "Pack camiseta + tasa");
		System.out.println(asistente3 + "\n");

		// Asistentes Expositor
		AsistenteExpositor asistente4 = new AsistenteExpositor("25777444V", "Sebastián", "02/03/1988", "17/02/2026", "Integram S.L");
		System.out.println(asistente4 + "\n");

		// CLASE TALLER
		Taller taller1 = new Taller("Pixel Art", "Miriam García", EnumTematica.COMIC, 22);
		System.out.println("=== Talleres ===");
		System.out.println(taller1 + "\n");
		System.out.println(taller1.toStringDetallado() + "\n");

		System.out.println("Añadir alumno al taller: " + ((taller1.admitirAlumno(asistente1)==true)?"Añadido":"Error, no se ha podido añadir"));
		System.out.println("Añadir alumno al taller: " + ((taller1.admitirAlumno(asistente2)==true)?"Añadido":"Error, no se ha podido añadir"));

		// Intentando añadir el mismo alumno
		System.out.println("\nIntendo de añadir el mismo alumno al taller: ");
		System.out.println("Añadir alumno al taller: " + ((taller1.admitirAlumno(asistente2)==true)?"Añadido":"Error, no se ha podido añadir"));


		System.out.println("\n" + taller1.toStringDetallado() + "\n");

		// CLASE AGENDA TALLERES
		System.out.println("\n=== Agenda Talleres ===");
		AgendaTalleres agenda1 = new AgendaTalleres();
		System.out.println(agenda1 + "\n");

		System.out.println(agenda1.generarInformaOcupacion() + "\n");

		// Asignar taller
		System.out.print("Asignar taller (prueba del método asignarTaller()): ");
		System.out.println((agenda1.asignarTaller(1, 1, taller1)==true)?"Añadido":"No se pudo añadir, ya existe un taller");

		System.out.println("\n" + agenda1.generarInformaOcupacion() + "\n");

		System.out.println("Prueba del método buscarTalleresPorTematica():");
		for (Taller taller : agenda1.buscarTalleresPorTematica(EnumTematica.VIDEOJUEGOS)) {
			System.out.println("\t" + taller);
		}

		// CLASE GESTION EVENTO
		System.out.println("\n=== Gestión Evento");
		GestionEvento gestion1 = new GestionEvento();

		System.out.println("Añadir asistentes: ");
		System.out.println(gestion1.añadirAsistentes(asistente1)==true?"Añadido":"No se pudo añadir");
		System.out.println(gestion1.añadirAsistentes(asistente2)==true?"Añadido":"No se pudo añadir");
		System.out.println(gestion1.añadirAsistentes(asistente3)==true?"Añadido":"No se pudo añadir");
		System.out.println(gestion1.añadirAsistentes(asistente4)==true?"Añadido":"No se pudo añadir");

		System.out.println("\n" + gestion1 + "\n");

		System.out.println("Comprobacion de que existe el asistente 4: ");
		System.out.println(gestion1.compruebaInscripcion(asistente4)?"Existe":"No existe");

		System.out.println("\nPrueba de borrar un asistente: ");
		System.out.println(gestion1.borraInscripcion(asistente4)==true?"Borrado":"No se pudo borrar");
		System.out.println(gestion1.borraInscripcion(asistente4)==true?"Borrado":"No se pudo borrar");

		System.out.println("Comprobacion de que existe el asistente 4: ");
		System.out.println(gestion1.compruebaInscripcion(asistente4)?"Existe":"No existe");

		System.out.println("\n" + gestion1);
	}

}
