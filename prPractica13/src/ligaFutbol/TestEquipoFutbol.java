package ligaFutbol;

public class TestEquipoFutbol {

	public static void main(String[] args) {

		Equipo equipo1 = new Equipo("Antequera CF", 3, 2, 1, 10 ,3);
		
		System.out.println("=== Clase Equipo ===");
		
		System.out.println(equipo1);
		
		System.out.println("\ntoStringLineal: \n" + equipo1.toStringLineal());
	}

}
