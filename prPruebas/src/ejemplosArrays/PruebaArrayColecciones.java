package ejemplosArrays;

import java.util.Arrays;

public class PruebaArrayColecciones {

	public static void main(String[] args) {

		int [] arrayPrimitivo = {1,2,3,4,5};
		
		Integer [] arrayObjetoInteger = new Integer[5];

		for (int cont=0;cont<arrayObjetoInteger.length;cont++) {
			arrayObjetoInteger[cont] = Integer.valueOf(arrayPrimitivo[cont]);
		}
		
		System.out.println(Arrays.toString(arrayPrimitivo)+"\n");
		System.out.println(Arrays.toString(arrayObjetoInteger));
	}

}
