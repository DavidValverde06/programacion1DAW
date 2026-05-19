package test;

import modelo.*;

public class TestConsola {

	public static void main(String[] args) {

		Punto punto1 = new Punto(100,100);
		Punto punto2 = new Punto(200,200);

		System.out.println(punto1.distancia(punto2) + " km\n");

		BilleteTren billete1 = new BilleteTren(punto1, punto2, EnumDescuentos.UNIVERSITARIO);

		System.out.println(billete1.getPrecio() + " €");

		System.out.println(billete1.getPrecioString());

		System.out.println();

		BilleteTrenFamiliar billeteFamiliar1 = new BilleteTrenFamiliar(punto1, punto2, EnumDescuentos.UNIVERSITARIO, "David");

		System.out.println(billeteFamiliar1.getPrecio() + " €");
		System.out.println(billeteFamiliar1.getPrecioString());
	}

}
