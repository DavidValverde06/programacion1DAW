package juego7Media_Ejer16;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {

		Juego7Media miJuego = new Juego7Media();

		System.out.println(Arrays.deepToString(miJuego.getBaraja()));

		int [] array = {12,3,4,5};

		for (int elemento:array) {
			System.out.print(elemento + " ");
		}
	}

}
