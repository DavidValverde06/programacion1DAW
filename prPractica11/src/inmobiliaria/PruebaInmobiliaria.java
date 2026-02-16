package inmobiliaria;

import java.util.*;

/**
 * Realiza una clase de prueba, llamado PuebaInmobiliaria, para comprobar el buen funcionamiento de
 * todas las clases anteriores. Como mínimo en esta clase se deben crear varios objetos de las clases
 * anteriores y mostrar finalmente un listado con todas las propiedades.
 */
public class PruebaInmobiliaria {

	public static void main(String[] args) {

		Propiedad local = new Propiedad(23, TipoPropiedad.LOCAL, 70.0,"El local no tiene baño e instalaciones de agua, luz y teléfono", "C/Infante, 45", 60000.0);
		Vivienda viviendaCasa = new Vivienda(24, TipoPropiedad.VIVIENDA, 100.0, "Perfectas condiciones", "C/Patata, 56", 240000.0, TipoVivienda.CASA);
		FincaRustica fincaRustica = new FincaRustica(25, TipoPropiedad.FINCA, 400.0, "Espacioso", "C/Ensalada, 15", 500000.0, TipoTerreno.OLIVOS);

		/**
		 * Pruebas Propiedad
		 */
		System.out.println("=== Pruebas Clase Propiedad ===");

		System.out.println(local);
		System.out.println("\n" + viviendaCasa);
		System.out.println("\n" + fincaRustica);

		/**
		 * Pruebas Inmobiliaria
		 */
		System.out.println("\n=== Pruebas Clase Inmobiliaria ===");

		Set<Propiedad> miColeccion = new HashSet<Propiedad>();
		miColeccion.add(local);
		miColeccion.add(viviendaCasa);
		miColeccion.add(fincaRustica);
		
		Inmobiliaria miInmobiliaria1 = new Inmobiliaria(miColeccion);
		Inmobiliaria miInmobiliaria2 = new Inmobiliaria();


		System.out.println(miInmobiliaria1);
		System.out.println("\n" + miInmobiliaria2);
	}

}
