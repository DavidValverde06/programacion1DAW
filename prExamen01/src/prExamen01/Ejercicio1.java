package prExamen01;

public class Ejercicio1 {

	public static void main(String[] args) {

		int capacidadLitros=0,contMinutos=0;

		while (capacidadLitros!=800) {

			contMinutos++;

			System.out.print("\nMinuto " + contMinutos + ": ");

			if (capacidadLitros<500) { // Se llena rápido
				capacidadLitros+=130;
				System.out.print("Se rellena rápido. Nivel = " + capacidadLitros);
			}
			else if (capacidadLitros<=800) { // Se llena lento
				capacidadLitros+=50;
				System.out.print("Relleno lento. Nivel = " + capacidadLitros);
			}
			else {
				capacidadLitros-=10; // Se vacía
				System.out.print("Se vacía. Nivel = " + capacidadLitros);
			}
		}

		System.out.println("\nEl depósito está estabilizado en " + capacidadLitros + " litros tras " + contMinutos + " minutos.");

	}

}
