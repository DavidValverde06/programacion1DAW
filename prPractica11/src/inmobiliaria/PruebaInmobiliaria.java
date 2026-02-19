package inmobiliaria;

public class PruebaInmobiliaria {

	public static void main(String[] args) {

		// === Crear propiedades ===
		Propiedad local = new Propiedad(23, TipoPropiedad.LOCAL, 70.0, "El local no tiene baño e instalaciones de agua, luz y teléfono", "C/Infante, 45", 60000.0);
		Vivienda viviendaCasa = new Vivienda(12, TipoPropiedad.VIVIENDA, 100.0, "Perfectas condiciones", "C/Patata, 56", 240000.0, TipoVivienda.CASA, 2, 3);
		FincaRustica fincaRustica = new FincaRustica(2, TipoPropiedad.FINCA, 400.0, "Espacioso", "C/Ensalada, 15", 400000.0, TipoTerreno.OLIVOS, true, false, true);

		// === Crear inmobiliaria ===
		Inmobiliaria inmobiliaria = new Inmobiliaria();

		System.out.println("=== AÑADIR PROPIEDADES ===");
		System.out.println("Añadir local: " + (inmobiliaria.añade(local)?"Añadida":"No se ha podido añadir"));
		System.out.println("Añadir vivienda: " + (inmobiliaria.añade(viviendaCasa)?"Añadida":"No se ha podido añadir"));
		System.out.println("Añadir finca: " + (inmobiliaria.añade(fincaRustica)?"Añadida":"No se ha podido añadir"));

		// === Ordenar por precio ===
		System.out.println("\n=== LISTA ORDENADA POR PRECIO ===");
		System.out.println(inmobiliaria.getPropiedadOrdenPrecioString());

		// Intentar añadir una propiedad duplicada
		System.out.println("Añadir el mismo local otra vez: " + (inmobiliaria.añade(local)?"Añadida":"No se ha podido añadir"));

		System.out.println("\n=== MOSTRAR TODAS LAS PROPIEDADES (ordenadas por código) ===");
		System.out.println(inmobiliaria);

		// === Buscar por código ===
		System.out.println("=== BUSCAR POR CÓDIGO ===");
		System.out.println("Buscar código 12: " + inmobiliaria.buscar(12));
		System.out.println("Buscar código 99 (no existe): " + inmobiliaria.buscar(99));

		// === Buscar por objeto ===
		System.out.println("\n=== BUSCAR POR OBJETO ===");
		System.out.println("Buscar viviendaCasa: " + inmobiliaria.buscar(viviendaCasa));
		System.out.println("Buscar nueva propiedad no añadida: " +
				inmobiliaria.buscar(new Propiedad(50, TipoPropiedad.LOCAL, 30, "X", "Y", 10000)));

		// === Borrar por código ===
		System.out.println("\n=== BORRAR POR CÓDIGO ===");
		System.out.println("Borrar código 23: " + inmobiliaria.borra(23));
		System.out.println("Borrar código 23 otra vez (ya borrado): " + inmobiliaria.borra(23));

		// === Borrar por objeto ===
		System.out.println("\n=== BORRAR POR OBJETO ===");
		System.out.println("Borrar viviendaCasa: " + inmobiliaria.borra(viviendaCasa));
		System.out.println("Borrar viviendaCasa otra vez: " + inmobiliaria.borra(viviendaCasa));

		System.out.println("\n=== PROPIEDADES RESTANTES ===");
		System.out.println(inmobiliaria);

		// === Ordenar por precio ===
		System.out.println("\n=== LISTA ORDENADA POR PRECIO ===");
		System.out.println(inmobiliaria.getPropiedadOrdenPrecioString());
	}
}
