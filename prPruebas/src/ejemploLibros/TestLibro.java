package ejemploLibros;

/**
 * Clase que comprueba el buen funcionamiento de la clase Libro
 * Incluye el método main
 *
 * @author Rosario Olmedo 
 *
 */
public class TestLibro {
	public static void main(String[] args) {

		Libro b1=new Libro("Yerma","Federico Garcia Lorca",false);
		Libro b2=new Libro("Luces de Bohemia","Ram¢n del Valle Inclan",true);
		Libro b3=new Libro("Luces de Bohemia","Ram¢n del Valle Inclan",true);

		System.out.println(b1.toString());
		System.out.println(b2.toString());

		if (b1.isEstado()==false)
			System.out.println("El libro del objeto b1 está prestado");
		else
			System.out.println("El libro del objeto b1 está en la biblioteca");

		b1.setEstado(true);
		System.out.println(b1.toString());

		if (b1.equals(b2))
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");

		if (b2.equals(b3))
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");

	}
}
