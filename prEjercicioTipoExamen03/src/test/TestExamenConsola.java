package test;

import modelo.*;

public class TestExamenConsola {

	public static void main(String[] args) {

		CasaRural casa1 = new CasaRural("Mi casa", EnumUbicaciones.ALMERÍA, 100, 2);

		ApartamentoRural apartamento1 = new ApartamentoRural("Mi apartamento", EnumUbicaciones.MÁLAGA, 80, true, true);

		System.out.println(casa1.calculaPrecioAlojamiento(4) + "€");
		System.out.println(casa1.calculaPrecioAlojamiento(12) + "€");
		System.out.println(casa1.calculaPrecioAlojamiento(8) + "€");

		System.out.println(apartamento1.calculaPrecioAlojamiento(1) + "€");

		CasaRural casaConchita = new CasaRural("Casa Conchita", EnumUbicaciones.GRANADA, 300, 6);

		try {
			Reserva reserva1 = new Reserva(casaConchita, "15/08/2026", 6, "Manuel Campos", "65598524V", "600200800");

			System.out.println(reserva1);
		}
		catch (MiExcepcion e) {
			System.out.println(e.getMessage());
		}

//		GestorAlojamientos gestor = new GestorAlojamientos("Alojamientos.txt");
//		
//		System.out.println(gestor.getAlojamientosDisponibles());
	}

}
