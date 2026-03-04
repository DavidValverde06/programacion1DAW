package ligaFutbol;

import java.time.LocalDate;

public class TestEquipoFutbol {

	public static void main(String[] args) {

		Equipo equipo1 = new Equipo("Antequera CF");
		Equipo equipo2 = new Equipo("Real Madrid");
		Equipo equipo3 = new Equipo("Atletico de Bilbao");

		
		System.out.println("=== Clase Equipo ===");
		
		System.out.println(equipo1);
		
		System.out.println("\ntoStringLineal: \n" + equipo1.toStringLineal());
		
		System.out.println("\n=== Clase Partido ===");
		
		Partido partido1 = new Partido(equipo2, equipo3, LocalDate.of(2026, 3, 4), 2, 1);
		
		System.out.println(partido1);
		
		System.out.println("\nResultado en forma de quiniela: " + partido1.resultadoEquipoQuiniela());
	}

}
