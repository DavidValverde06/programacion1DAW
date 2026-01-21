package claseObjects;

import java.util.Objects;

public class Test5 {

	public static void main(String[] args) {

		int fromIndex = 8;
		int size = 5;
		int length = 15;

		System.out.println(Objects.checkFromIndexSize(fromIndex, size, length));

		// En este caso lanzará la excepción IndexOutOfBoundsException, al pasar el valor -1
		int fromIndex2 = -1;
	    int size2 = 5;
	    int length2 = 15;
	    System.out.println(Objects.checkFromIndexSize(fromIndex2, size2, length2));
	}

}

