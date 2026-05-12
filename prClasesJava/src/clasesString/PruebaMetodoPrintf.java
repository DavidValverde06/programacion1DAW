package clasesString;

public class PruebaMetodoPrintf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String provincia = "M�laga";
		int numeroInt = 23;
		double numeroDouble = 12.67456;
		
		System.out.printf("El n�mero %d continua el texto%n",numeroInt);
		
		System.out.printf("La cadena es %10s, el n�mero es %7d y el n�mero real %5.2f%n",
				provincia,numeroInt, numeroDouble);
	}

}
