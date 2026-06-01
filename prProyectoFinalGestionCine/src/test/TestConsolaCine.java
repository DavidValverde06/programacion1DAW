package test;

import java.io.*;
import java.sql.*;
import java.util.*;

import modelo.*;

public class TestConsolaCine {

	/**
	 * Variables de clase
	 */
	private static Scanner sc = new Scanner(System.in);
	private static DAOPelicula daoPeli;
	private static DAOSesion daoSesion;
	private static String usuario;
	private static String password;

	public static void main(String[] args) {

		try {
			// Pedir credenciales al inicio
			System.out.print("Usuario: ");
			usuario = sc.nextLine();
			System.out.print("Contraseña: ");
			password = sc.nextLine();

			// Establecer conexión con las credenciales introducidas
			ConexionBaseDatos.getConnection(usuario, password);
			System.out.println("Sesión iniciada correctamente");

			daoPeli = new DAOPelicula();
			daoSesion = new DAOSesion();

			cargarDatosIniciales(); // Carga datos desde ficheros si la BD se encuentra vacía

			int opcionMenu;

			do {
				opcionMenu = menuPrincipal();
				switch (opcionMenu) {
				case 0 -> System.out.println("\nSaliendo del programa ..."); // Salir del bucle y cerra conexión
				case 1 -> menuPeliculas();
				case 2 -> menuConsultas();
				case 3 -> comprarEntrada();
				default -> System.out.println("Opción no disponible en el menú\n");
				}
			}
			while (opcionMenu!=0);

			daoPeli.cierraConexion();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("ERROR\nCredenciales incorrectas o no se puede conectar a la base de datos");
			System.exit(0);
		}
		catch (MiExcepcion e) {
			e.printStackTrace();
		}
		catch (InputMismatchException e) {
			System.out.println("Error, introduce un valor númerico");
		}
	}

	// =============
	// Menús consola
	// =============

	/**
	 * Menú principal
	 */
	private static int menuPrincipal() {
		int opcion;
		System.out.println("\n--- GESTIÓN CINE ---");
		System.out.println("1. Gestion de Peliculas");
		System.out.println("2. Consultas");
		System.out.println("3. Comprar entrada");
		System.out.println("0. Salir\n");

		System.out.print("Elige una opción: ");
		opcion = sc.nextInt();

		return opcion;
	}

	/**
	 * Menú peliculas
	 */
	private static void menuPeliculas() throws SQLException, MiExcepcion {
		int opcion;

		do {
			System.out.println("\n--- GESTIÓN PELICULAS ---");
			System.out.println("1. Ver todas las peliculas");
			System.out.println("2. Buscar pelicula por ID");
			System.out.println("3. Añadir pelicula");
			System.out.println("4. Modificar pelicula");
			System.out.println("5. Eliminar pelicula");
			System.out.println("0. Volver atrás\n");

			System.out.print("Elige una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> verTodasPeliculas();
			case 2 -> buscarPelicula();
			case 3 -> añadirPelicula();
			case 4 -> modificarPelicula();
			case 5 -> eliminarPelicula();
			case 0 -> System.out.println("Volviendo al menu principal...");
			default -> System.out.println("Opcion no disponible");
			}
		}
		while (opcion!=0);
	}

	/**
	 * Menú consultas
	 */
	private static void menuConsultas() throws SQLException {
		int opcion;

		do {
			System.out.println("\n--- GESTIÓN CONSULTAS ---");
			System.out.println("1. Todas las sesiones");
			System.out.println("2. Sesiones de una pelicula");
			System.out.println("3. Sesiones de hoy");
			System.out.println("4. Sesiones por tipo de sala");
			System.out.println("0. Volver atrás\n");

			System.out.print("Elige una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> consultaTodasSesiones();
			case 2 -> consultaSesionesPelicula();
			case 3 -> consultaSesionesHoy();
			case 4 -> consultaSesionesSala();
			case 0 -> System.out.println("Volviendo al menu principal...");
			default -> System.out.println("Opcion no valida");
			}
		}
		while (opcion!=0);
	}

	// ================
	// Operaciones CRUD
	// ================

	/**
	 * Método que permite ver todas las peliculas disponibles
	 */
	private static void verTodasPeliculas() throws SQLException, MiExcepcion {
		List<Pelicula> lista = daoPeli.getAll();

		if (lista.isEmpty()) {
			System.out.println("No hay peliculas en la base de datos");
		}
		else {
			System.out.println("\n--- LISTADO DE PELICULAS ---");

			for (Pelicula p : lista)
				System.out.println(p + "\n");
		}
	}

	/**
	 * Método que permite buscar una pelicula por ID
	 */
	private static void buscarPelicula() throws SQLException, MiExcepcion {
		int id;
		System.out.print("Introduce el ID de la pelicula a buscar: ");
		id = sc.nextInt();

		Pelicula peli = daoPeli.buscaCodigo(id);

		if (peli == null) {
			System.out.println("No se encontro ninguna pelicula con ID " + id);
		}
		else {
			System.out.println("\n" + peli);
		}
	}

	/**
	 * Método que permite añadir una pelicula
	 */
	private static void añadirPelicula() throws SQLException {
		int id, duracion, anio;
		String titulo, director;
		EnumGenero genero;
		EnumClasificacion clasificacion;

		sc.nextLine(); // Limpiar

		// ID
		System.out.print("ID: ");
		id = Integer.parseInt(sc.nextLine());

		// Titulo
		System.out.print("Titulo: ");
		titulo = sc.nextLine();

		// Genero
		System.out.println("Genero (DRAMA, COMEDIA, ACCION, TERROR, CIENCIA_FICCION, AVENTURA, ROMANCE, THRILLER, ANIMACION, BIOGRAFIA): ");
		genero = EnumGenero.valueOf(sc.nextLine().toUpperCase());

		// Duracion (minutos)
		System.out.print("Duracion (minutos): ");
		duracion = Integer.parseInt(sc.nextLine());

		// Clasificación
		System.out.println("Clasificacion (CLASIFICACION_TP, CLASIFICACION_7, CLASIFICACION_12, CLASIFICACION_16, CLASIFICACION_18): ");
		clasificacion = EnumClasificacion.valueOf(sc.nextLine().toUpperCase());

		// Director
		System.out.print("Director: ");
		director = sc.nextLine();

		// Año
		System.out.print("Año: ");
		anio = Integer.parseInt(sc.nextLine());

		Pelicula peli = new Pelicula(id, titulo, genero, duracion, clasificacion, director, anio);
		daoPeli.insertaPelicula(peli);

		System.out.println("Pelicula añadida correctamente");
	}

	/**
	 * Método que permite modificar una pelicula
	 */
	private static void modificarPelicula() throws SQLException, MiExcepcion {
		int id;
		System.out.print("Introduce el ID de la pelicula a modificar: ");
		id = sc.nextInt();

		Pelicula peli = daoPeli.buscaCodigo(id);

		if (peli == null) {
			System.out.println("No se encontro ninguna pelicula con ID " + id);
			return;
		}

		System.out.println("Pelicula encontrada: " + peli.getTitulo());

		sc.nextLine(); // Limpiar

		System.out.print("Nuevo titulo (" + peli.getTitulo() + "): ");
		String titulo = sc.nextLine();

		System.out.println("Nuevo genero (" + peli.getGenero() + "): ");
		EnumGenero genero = EnumGenero.valueOf(sc.nextLine().toUpperCase());

		System.out.print("Nueva duracion (" + peli.getDuracion() + "): ");
		int duracion = Integer.parseInt(sc.nextLine());

		System.out.println("Nueva clasificacion (" + peli.getClasificacion() + "): ");
		EnumClasificacion clasificacion = EnumClasificacion.valueOf(sc.nextLine().toUpperCase());

		System.out.print("Nuevo director (" + peli.getDirector() + "): ");
		String director = sc.nextLine();

		System.out.print("Nuevo año (" + peli.getAnio() + "): ");
		int anio = Integer.parseInt(sc.nextLine());

		peli.setTitulo(titulo);
		peli.setGenero(genero);
		peli.setDuracion(duracion);
		peli.setClasificacion(clasificacion);
		peli.setDirector(director);
		peli.setAnio(anio);

		daoPeli.modificaPelicula(peli);
		System.out.println("Pelicula modificada correctamente.");
	}

	/**
	 * Método que permite eliminar una pelicula
	 */
	private static void eliminarPelicula() throws SQLException, MiExcepcion {
		int id;
		System.out.print("Introduce el ID de la pelicula a eliminar: ");
		id = sc.nextInt();

		Pelicula peli = daoPeli.buscaCodigo(id);

		if (peli == null) {
			System.out.println("No se encontro ninguna pelicula con ID " + id);
			return;
		}

		System.out.println("¿Seguro que quieres eliminar: " + peli.getTitulo() + "? (s/n): ");

		sc.nextLine(); // Limpiar

		String confirmacion = sc.nextLine();

		if (confirmacion.equalsIgnoreCase("s")) {
			daoPeli.eliminaPelicula(id);
			System.out.println("Pelicula eliminada correctamente");
		}
		else {
			System.out.println("Operación cancelada");
		}
	}

	// ================
	// Comprar entradas
	// ================

	/**
	 * Método para comprar una entrada que se guardara en un fichero
	 */
	private static void comprarEntrada() throws SQLException {
		sc.nextLine(); // Limpiar

		// Pedir datos del cliente
		System.out.println("\n--- DATOS CLIENTE ---");
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Apellidos: ");
		String apellidos = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		// Mostrar todas las sesiones disponibles
		System.out.println("\n--- SESIONES DISPONIBLES ---\n");
		imprimirTabla(daoSesion.todasLasSesiones());

		// Elegir sesion
		System.out.print("Introduce el ID de la sesion que deseas: ");
		int idSesion = Integer.parseInt(sc.nextLine());

		// Obtener datos completos de esa sesion
		var modeloSesion = daoSesion.getDatosSesion(idSesion);

		if (modeloSesion.getRowCount() == 0) {
			System.out.println("No se encontro la sesion con ID " + idSesion);
			return;
		}

		// Recoger datos de la sesion
		String titulo = modeloSesion.getValueAt(0, 0).toString();
		String fecha = modeloSesion.getValueAt(0, 1).toString();
		String hora = modeloSesion.getValueAt(0, 2).toString();
		String sala = modeloSesion.getValueAt(0, 3).toString();
		String tipoSala = modeloSesion.getValueAt(0, 4).toString();
		String precio = modeloSesion.getValueAt(0, 5).toString();

		// Contenido del ticket
		String contenidoEntrada;

		contenidoEntrada =
				"--- ENTRADA CINE ---\n" +
						"Cliente : " + nombre + " " + apellidos + "\n" +
						"Email: " + email + "\n\n" +
						"Pelicula: " + titulo + "\n" +
						"Fecha: " + fecha + "\n" +
						"Hora: " + hora + ":00h\n" +
						"Sala: " + sala + " (" + tipoSala + ")\n" +
						"Precio: " + precio + " EUR\n\n" +
						"¡Disfrute de la pelicula!";

		// Guardar en fichero
		String nombreFichero = "./entradas/entrada_" + nombre + "_sesion" + idSesion + ".txt";

		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(nombreFichero))) {

			flujoEscritura.write(contenidoEntrada);

			System.out.println("\nEntrada generada en: " + nombreFichero);
			System.out.println("\n" + contenidoEntrada);
		}
		catch (IOException e) {
			System.out.println("Error al generar la entrada: " + e.getMessage());
		}
	}

	// =========
	// Consultas
	// =========

	/**
	 * Método para consultar todas las sesiones
	 */
	private static void consultaTodasSesiones() throws SQLException {
		imprimirTabla(daoSesion.todasLasSesiones());
	}

	/**
	 * Método para consultar todas las sesiones de una pelicula buscando por ID
	 */
	private static void consultaSesionesPelicula() throws SQLException {
		int id;
		System.out.print("Introduce el ID de la pelicula: ");
		id = sc.nextInt();

		imprimirTabla(daoSesion.sesionesDeUnaPelicula(id));
	}

	/**
	 * Método para consultar todas las sesiones de una pelicula con fecha para hoy
	 */
	private static void consultaSesionesHoy() throws SQLException {
		imprimirTabla(daoSesion.sesionesDeHoy());
	}

	/**
	 * Método para consultar todas las sesiones de una pelicula buscando por tipo de sala
	 */
	private static void consultaSesionesSala() throws SQLException {
		String tipoSala;
		System.out.println("Tipo de sala (SALA_NORMAL, SALA_VIP, SALA_3D): ");

		sc.nextLine(); // Limpiar

		tipoSala = sc.nextLine().toUpperCase();

		imprimirTabla(daoSesion.sesionesPorTipoSala(tipoSala));
	}

	// =====================================
	// Imprimir DefaultTableModel
	// =====================================

	/**
	 * Método que imprime una tabla por consola
	 */
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

	/**
	 * Método que cuenta cuántas peliculas hay en la base de datos, si no hay 
	 * carga todos los datos desde los ficheros y si encuentra peliculas lanza un mensaje por
	 * consola diciendo que ya existen datos en la misma
	 */
	private static void cargarDatosIniciales() {

		try {
			Connection con = ConexionBaseDatos.getConnection(usuario, password);

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
				System.out.println("Datos cargados correctamente\n");
			}
			else {
				System.out.println("Datos ya existentes en la base de datos\n");
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
