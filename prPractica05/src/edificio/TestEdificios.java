package edificio;

/**
 * Clase que testea el funcionamiento de las clases Direccion, Edificio, Casa, Colegio y Guarderia
 * 
 * @author DavidValverde
 */
public class TestEdificios {

	public static void main(String[] args) {

		Direccion dir1 = new Direccion("Avda. Europa", 126, 29210);
		Direccion dir2 = new Direccion("Calle alameda", 2, 29200);
		
		System.out.println(dir1);
		
		System.out.println(dir2);
		
		System.out.println(); // Salto de línea
		
		Edificio edificio1 = new Edificio(dir1, 10, 3, 1000);
		Edificio edificio2 = new Edificio("Calle Lucena", 5, 29200, 3, 1, 100);
		
		System.out.println(edificio1);
		System.out.println();
		System.out.println(edificio2);
	}

}
