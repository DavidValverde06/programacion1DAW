package test;

import java.io.*;
import java.nio.charset.*;
import java.sql.*;
import java.util.*;
import modelo.*;

public class Test {

	private static DAOPelicula daoPelicula;
	private static DAOSesion daoSesion;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			daoPelicula = new DAOPelicula();
			daoSesion = new DAOSesion();

			cargarDatosIniciales();

			int opcion;
			do {
				opcion = menuPrincipal();
				switch (opcion) {
				case 1 -> menuPeliculas();
				case 2 -> menuConsultas();
				case 3 -> comprarEntrada();
				case 0 -> System.out.println("Hasta luego!");
				default -> System.out.println("Opcion no valida");
				}
			} while (opcion != 0);

			daoPelicula.cierraConexion();

		} catch (ClassNotFoundException | SQLException | MiExcepcion e) {
			e.printStackTrace();
		}
	}

	// ─────────────────────────────────────
	//  MENUS
	// ─────────────────────────────────────

	private static int menuPrincipal() {
		System.out.println("\n=============================");
		System.out.println("    GESTION CINE - MENU");
		System.out.println("=============================");
		System.out.println(" 1. Gestion de Peliculas");
		System.out.println(" 2. Consultas");
		System.out.println(" 3. Comprar entrada");
		System.out.println(" 0. Salir");
		System.out.println("=============================");
		System.out.print("Elige una opcion: ");
		return sc.nextInt();
	}

	private static void menuPeliculas() throws SQLException, MiExcepcion {
		int opcion;
		do {
			System.out.println("\n─────────────────────────────");
			System.out.println("     GESTION DE PELICULAS");
			System.out.println("─────────────────────────────");
			System.out.println(" 1. Ver todas las peliculas");
			System.out.println(" 2. Buscar pelicula por ID");
			System.out.println(" 3. Añadir pelicula");
			System.out.println(" 4. Modificar pelicula");
			System.out.println(" 5. Eliminar pelicula");
			System.out.println(" 0. Volver");
			System.out.println("─────────────────────────────");
			System.out.print("Elige una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> verTodasPeliculas();
			case 2 -> buscarPelicula();
			case 3 -> añadirPelicula();
			case 4 -> modificarPelicula();
			case 5 -> eliminarPelicula();
			case 0 -> System.out.println("Volviendo al menu principal...");
			default -> System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

	private static void menuConsultas() throws SQLException {
		int opcion;
		do {
			System.out.println("\n─────────────────────────────");
			System.out.println("          CONSULTAS");
			System.out.println("─────────────────────────────");
			System.out.println(" 1. Sesiones de una pelicula");
			System.out.println(" 2. Sesiones de hoy");
			System.out.println(" 3. Sesiones por tipo de sala");
			System.out.println(" 0. Volver");
			System.out.println("─────────────────────────────");
			System.out.print("Elige una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> consultaSesionesPelicula();
			case 2 -> consultaSesionesHoy();
			case 3 -> consultaSesionesSala();
			case 0 -> System.out.println("Volviendo al menu principal...");
			default -> System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

	// ─────────────────────────────────────
	//  OPERACIONES CRUD
	// ─────────────────────────────────────

	private static void verTodasPeliculas() throws SQLException, MiExcepcion {
		List<Pelicula> lista = daoPelicula.getAll();
		if (lista.isEmpty()) {
			System.out.println("No hay peliculas en la base de datos.");
		} else {
			System.out.println("\n--- LISTADO DE PELICULAS ---");
			for (Pelicula p : lista)
				System.out.println(p + "\n");
		}
	}

	private static void buscarPelicula() throws SQLException, MiExcepcion {
		System.out.print("Introduce el ID de la pelicula: ");
		int id = sc.nextInt();
		Pelicula p = daoPelicula.buscaCodigo(id);
		if (p == null)
			System.out.println("No se encontro ninguna pelicula con ID " + id);
		else
			System.out.println("\n" + p);
	}

	private static void añadirPelicula() throws SQLException {
		sc.nextLine();
		System.out.print("ID: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Titulo: ");
		String titulo = sc.nextLine();
		System.out.println("Genero (DRAMA, COMEDIA, ACCION, TERROR, CIENCIA_FICCION, AVENTURA, ROMANCE, THRILLER, ANIMACION, BIOGRAFIA): ");
		EnumGenero genero = EnumGenero.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Duracion (minutos): ");
		int duracion = Integer.parseInt(sc.nextLine());
		System.out.println("Clasificacion (CLASIFICACION_TP, CLASIFICACION_7, CLASIFICACION_12, CLASIFICACION_16, CLASIFICACION_18): ");
		EnumClasificacion clasificacion = EnumClasificacion.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Director: ");
		String director = sc.nextLine();
		System.out.print("Año: ");
		int anio = Integer.parseInt(sc.nextLine());

		Pelicula p = new Pelicula(id, titulo, genero, duracion, clasificacion, director, anio);
		daoPelicula.insertaPelicula(p);
		System.out.println("Pelicula añadida correctamente.");
	}

	private static void modificarPelicula() throws SQLException, MiExcepcion {
		System.out.print("Introduce el ID de la pelicula a modificar: ");
		int id = sc.nextInt();
		Pelicula p = daoPelicula.buscaCodigo(id);

		if (p == null) {
			System.out.println("No se encontro ninguna pelicula con ID " + id);
			return;
		}

		System.out.println("Pelicula encontrada: " + p.getTitulo());
		sc.nextLine();
		System.out.print("Nuevo titulo (" + p.getTitulo() + "): ");
		String titulo = sc.nextLine();
		System.out.println("Nuevo genero (" + p.getGenero() + "): ");
		EnumGenero genero = EnumGenero.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Nueva duracion (" + p.getDuracion() + "): ");
		int duracion = Integer.parseInt(sc.nextLine());
		System.out.println("Nueva clasificacion (" + p.getClasificacion() + "): ");
		EnumClasificacion clasificacion = EnumClasificacion.valueOf(sc.nextLine().toUpperCase());
		System.out.print("Nuevo director (" + p.getDirector() + "): ");
		String director = sc.nextLine();
		System.out.print("Nuevo año (" + p.getAnio() + "): ");
		int anio = Integer.parseInt(sc.nextLine());

		p.setTitulo(titulo);
		p.setGenero(genero);
		p.setDuracion(duracion);
		p.setClasificacion(clasificacion);
		p.setDirector(director);
		p.setAnio(anio);

		daoPelicula.modificaPelicula(p);
		System.out.println("Pelicula modificada correctamente.");
	}

	private static void eliminarPelicula() throws SQLException, MiExcepcion {
		System.out.print("Introduce el ID de la pelicula a eliminar: ");
		int id = sc.nextInt();
		Pelicula p = daoPelicula.buscaCodigo(id);

		if (p == null) {
			System.out.println("No se encontro ninguna pelicula con ID " + id);
			return;
		}

		System.out.println("¿Seguro que quieres eliminar: " + p.getTitulo() + "? (s/n): ");
		sc.nextLine();
		String confirmacion = sc.nextLine();

		if (confirmacion.equalsIgnoreCase("s")) {
			daoPelicula.eliminaPelicula(id);
			System.out.println("Pelicula eliminada correctamente.");
		} else {
			System.out.println("Operacion cancelada.");
		}
	}

	// ─────────────────────────────────────
	//  COMPRAR ENTRADA
	// ─────────────────────────────────────

	private static void comprarEntrada() throws SQLException {

		sc.nextLine(); // limpiar buffer

		// Datos del cliente
		System.out.println("\n--- DATOS DEL CLIENTE ---");
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellidos = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();

		// Mostrar todas las sesiones disponibles
		System.out.println("\n--- SESIONES DISPONIBLES ---");
		imprimirTabla(daoSesion.todasLasSesiones());

		// Elegir sesion
		System.out.print("\nIntroduce el ID de la sesion que deseas: ");
		int idSesion = Integer.parseInt(sc.nextLine());

		// Obtener datos completos de esa sesion
		var modeloSesion = daoSesion.getDatosSesion(idSesion);

		if (modeloSesion.getRowCount() == 0) {
			System.out.println("No se encontro la sesion con ID " + idSesion);
			return;
		}

		// Recoger datos de la sesion
		String titulo   = modeloSesion.getValueAt(0, 0).toString();
		String fecha    = modeloSesion.getValueAt(0, 1).toString();
		String hora     = modeloSesion.getValueAt(0, 2).toString();
		String sala     = modeloSesion.getValueAt(0, 3).toString();
		String tipoSala = modeloSesion.getValueAt(0, 4).toString();
		String precio   = modeloSesion.getValueAt(0, 5).toString();

		// Contenido del ticket
		String contenido =
				"========================================\n" +
						"           ENTRADA DE CINE              \n" +
						"========================================\n" +
						"  Cliente:    " + nombre + " " + apellidos + "\n" +
						"  Email:      " + email + "\n" +
						"----------------------------------------\n" +
						"  Pelicula:   " + titulo + "\n" +
						"  Fecha:      " + fecha + "\n" +
						"  Hora:       " + hora + ":00h\n" +
						"  Sala:       " + sala + " (" + tipoSala + ")\n" +
						"  Precio:     " + precio + " EUR\n" +
						"----------------------------------------\n" +
						"      Disfrute de la pelicula!          \n" +
						"========================================\n";

		// Guardar en fichero
		String nombreFichero = "./entradas/entrada_" + nombre + "_sesion" + idSesion + ".txt";

		try (PrintWriter pw = new PrintWriter(
				new FileWriter(nombreFichero, StandardCharsets.UTF_8))) {
			pw.print(contenido);
			System.out.println("\nEntrada generada en: " + nombreFichero);
			System.out.println("\n" + contenido);
		} catch (IOException e) {
			System.out.println("Error al generar la entrada: " + e.getMessage());
		}
	}

	// ─────────────────────────────────────
	//  CONSULTAS
	// ─────────────────────────────────────

	private static void consultaSesionesPelicula() throws SQLException {
		System.out.print("Introduce el ID de la pelicula: ");
		int id = sc.nextInt();
		imprimirTabla(daoSesion.sesionesDeUnaPelicula(id));
	}

	private static void consultaSesionesHoy() throws SQLException {
		imprimirTabla(daoSesion.sesionesDeHoy());
	}

	private static void consultaSesionesSala() throws SQLException {
		System.out.println("Tipo de sala (SALA_NORMAL, SALA_VIP, SALA_3D): ");
		sc.nextLine();
		String tipo = sc.nextLine().toUpperCase();
		imprimirTabla(daoSesion.sesionesPorTipoSala(tipo));
	}

	// ─────────────────────────────────────
	//  UTILIDAD - Imprimir DefaultTableModel
	// ─────────────────────────────────────

	private static void imprimirTabla(javax.swing.table.DefaultTableModel modelo) {
		if (modelo.getRowCount() == 0) {
			System.out.println("No se encontraron resultados.");
			return;
		}
		for (int i = 0; i < modelo.getColumnCount(); i++)
			System.out.printf("%-20s", modelo.getColumnName(i));
		System.out.println();
		System.out.println("-".repeat(20 * modelo.getColumnCount()));
		for (int fila = 0; fila < modelo.getRowCount(); fila++) {
			for (int col = 0; col < modelo.getColumnCount(); col++)
				System.out.printf("%-20s", modelo.getValueAt(fila, col));
			System.out.println();
		}
	}

	private static void cargarDatosIniciales() {

		try {
			Connection con = ConexionBaseDatos.getConnection();

			// Comprobar si la tabla pelicula ya tiene datos
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM cine.pelicula");
			rs.next();
			int numPeliculas = rs.getInt(1);

			if (numPeliculas == 0) {
				System.out.println("Cargando datos iniciales...");
				CargarTablasProyecto.cargaTablaPeliculas(con);
				CargarTablasProyecto.cargaTablaSalas(con);
				CargarTablasProyecto.cargaTablaSesiones(con);
				CargarTablasProyecto.cargaTablaClientes(con);
				System.out.println("Datos cargados correctamente.\n");
			} else {
				System.out.println("Datos ya existentes en la base de datos.\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}