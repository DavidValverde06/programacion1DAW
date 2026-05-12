package test;

import modelo.Disco;
import modelo.MiExcepcion;

public class TestConsola1 {

	public static void main(String[] args) {
		
		Disco d1 = null;
		
		// -----------------------------------------------
		// Prueba clase disco
		try {
			d1 = new Disco(20,"Disco 20","Autor disco 20", "19/11/2024",27);
			System.out.println(d1);
		} catch (MiExcepcion e) {
			//e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println(d1);
	}

}
