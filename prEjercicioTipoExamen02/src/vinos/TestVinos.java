package vinos;

public class TestVinos {

	public static void main(String[] args) {

		// Probando métodos de la clase Metodos
		System.out.println("=== Clase Metodos ===");
		System.out.println("Conversor de hectolitros a litros");
		System.out.println(MetodosVinos.conversorHectolitros(100) + " litros");
		System.out.println(MetodosVinos.conversorHectolitros(1) + " litros\n");

		System.out.println("Desglose de dinero (euros y céntimos)");
		MetodosVinos.desglose(80);
		MetodosVinos.desglose(12.5f);

		// Probando Clase Enologo
		System.out.println("\n=== Clase Enologo");
		Enologo enologo1 = new Enologo("Juan García", 29, true);
		Enologo enologo2 = new Enologo("María González", 45, false);
		System.out.println(enologo1);
		System.out.println(enologo2+"\n");

		// Probando Clase Enologo
		System.out.println("\n=== Clase Cosecha");
		Cosecha cosecha1 = new Cosecha("Cortijo Los Juanes, verano 2015", false, false);
		Cosecha cosecha2 = new Cosecha("Finca La Soledad, otoño 2016");
		System.out.println(cosecha1+"\n");
		System.out.println(cosecha1.toStringLineal()+"\n");
		System.out.println(cosecha2+"\n");

		// Probando Clase Vino
		System.out.println("\n=== Clase Vino");
		
	}

}
