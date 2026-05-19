package test;

import modelo.*;

public class TestConsola {

	public static void main(String[] args) {

		// Prueba Clase Punto
		System.out.println("--- CLASE PUNTO ---");
		Punto punto1 = new Punto(100,100);
		Punto punto2 = new Punto(200,200);

		System.out.println("Punto 1: " + punto1);
		System.out.println("Punto 2: " + punto2);
		System.out.println("Distancia del punto 1 al punto 2: " + punto1.distancia(punto2) + " Km");
		System.out.println("Distancia del punto 1 al punto 2: " + punto1.distancia(200,200) + " Km\n");

		// Prueba Clase Billetes
		System.out.println("--- CLASE BILLETE ---");
		BilleteTren billete1 = new BilleteTren(punto1, punto2, EnumDescuentos.UNIVERSITARIO);
		BilleteTrenFamiliar billeteFamiliar1 = new BilleteTrenFamiliar(punto1, punto2, EnumDescuentos.UNIVERSITARIO, "David");

		System.out.println(billete1 + "\n");
		System.out.println("Precio real del billete: " + billete1.getPrecio() + " €");
		System.out.println("Precio desglosado en euros/céntimos: " + billete1.getPrecioString() + "\n");


		System.out.println(billeteFamiliar1 + "\n");
		System.out.println("Precio real del billete familiar: " + billeteFamiliar1.getPrecio() + " €");
		System.out.println("Precio desglosado en euros/céntimos: " + billeteFamiliar1.getPrecioString());
	}

}
