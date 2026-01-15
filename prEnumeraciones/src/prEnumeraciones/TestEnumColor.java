package prEnumeraciones;

import java.util.Arrays;

public class TestEnumColor {

	public static void main(String[] args) {
		

		Color c1 = Color.ROJO;
		
		Color c2 = Color.NEGRO;

		//Color c3 = Color.VIOLETA;
		
//		Color c4 = Color.ROSA;
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.ordinal());

		System.out.println(Arrays.toString(Color.values()));
		
		Color miColor = Color.valueOf("ROSA");
		System.out.println(miColor);
		
		try {
			Color miColor2 = Color.valueOf("NARANJA");
			System.out.println(miColor2);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Color inexistente");
		}
	}

}
