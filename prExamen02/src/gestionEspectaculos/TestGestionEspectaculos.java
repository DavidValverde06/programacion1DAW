package gestionEspectaculos;

/**
 * @author David Valverde Barea
 */
public class TestGestionEspectaculos {

	public static void main(String[] args) {

		// Clase utilidades
		System.out.println("=== CLASE UTILIDADES ===");
		System.out.println(Utilidades.formateaDuracion(150));
		System.out.println(Utilidades.formateaDuracion(60));
		System.out.println(Utilidades.formateaDuracion(50));

		System.out.println("\n"+Utilidades.calcularDescuento(1000,15)+"€");

		System.out.println("\n"+Utilidades.convertirMoneda(200, 1.09));


		// Clase Organizador
		System.out.println("\n=== CLASE ORGANIZADOR ===");
		Organizador organizador1 = new Organizador("B11122234", "Espectáculos del Sur", true);
		Organizador organizador2 = new Organizador("A98765432", "Eventos Galadriel");

		System.out.println(organizador1);
		System.out.println(organizador2);

		
		// Clase Lugar
		System.out.println("\n=== CLASE LUGAR ===");
		Lugar lugar1 = new Lugar("Teatro Cervantes de Málaga", 1134, 8000);
		Lugar lugar2 = new Lugar("Teatro Real de Madrid", 1746, 12000);
		Lugar lugar3 = new Lugar("Auditorio Edgar Neville Málaga", 391, 2500);

		System.out.println(lugar1);
		System.out.println(lugar2);
		System.out.println(lugar3);

		
		// Clase Espectaculo (Conciertos y ObrasDeTeatro)
		System.out.println("\n=== CLASE ESPECTACULO (CONCIERTOS Y OBRAS DE TEATRO) ===");
		Conciertos concierto1 = new Conciertos("Rosalía", organizador1, lugar1, 120, false);
		Conciertos concierto2 = new Conciertos("Grandes del Góspel", organizador2, lugar2, 90, true);

		System.out.println(concierto1+"\n");
		System.out.println(concierto2+"\n");

		ObrasDeTeatro obra1 = new ObrasDeTeatro("Los miserables", organizador1, lugar1, 140, "Musical");
		ObrasDeTeatro obra2 = new ObrasDeTeatro("La función que sale mal", organizador2, lugar3, 110, "Comedia");

		System.out.println(obra1+"\n");
		System.out.println(obra2);

		
		// Clase Entrada
		System.out.println("\n=== CLASE ENTRADA ===");
		Entrada entrada1 = new Entrada(981, concierto1, "Normal");
		Entrada entrada2 = new Entrada(76, obra1, "VIP");
		Entrada entrada3 = new Entrada(128, concierto2, "Reducida");
		Entrada entrada4 = new Entrada(807, obra2, "VIP");

		System.out.println(entrada1+"\n");
		System.out.println(entrada2+"\n");
		System.out.println(entrada3+"\n");
		System.out.println(entrada4);

		System.out.println("\nFIN EXAMEN");
	}

}
