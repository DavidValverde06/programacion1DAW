package test;

import java.util.*;
import modelo.*;

public class TestConsola {

	public static void main(String[] args) {

		SortedSet<String> motivosConsulta = new TreeSet<>();
		motivosConsulta.add("Sin especificar");
		motivosConsulta.add("Protocolo Infarto");

		/**
		 * Por ejemplo una cita para Medicina General que no sea urgente, tendrá un coste de 100€, en
		 * cambio, una urgente de prioridad 3 para Cardiología, tendrá un coste de 280€ (100 + 30 +
		 * 150).
		 */
		CitaMedica cita1 = new CitaMedica(3, 1234, "Paco", motivosConsulta, "Cardiologia", "09:34:58");

		System.out.println(cita1);
	}

}
