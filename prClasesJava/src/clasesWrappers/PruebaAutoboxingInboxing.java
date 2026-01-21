package clasesWrappers;

public class PruebaAutoboxingInboxing {

	public static void main(String[] args) {
		
		// Primer ejemplo
		Integer num1 = 12;
		Integer num2 = 15;
		
		int sumaTipoPrimitivo = num1 + num2;
		Integer sumaTipoWrapper = num1 + num2;

		System.out.println("Suma en tipo primitivo: "+sumaTipoPrimitivo);
		System.out.println("Suma en objeto: "+sumaTipoWrapper);
		
		// Segundo ejemplo
		Integer int1=100;
		Integer int2=100;
		
		if (int1==int2)
			System.out.println("Son iguales!");
		else
			System.out.println("Son diferentes! ¿?");
		
		// Tercer ejemplo
		Integer int3=128;
		Integer int4=128;
		
		if (int3==int4)
			System.out.println("Son iguales!");
		else
			System.out.println("Son diferentes! ¿?");
		
		// Cuato ejemplo
		Integer int5=150;
		Integer int6=150;
		
		if (int5==int6)
			System.out.println("Son iguales!");
		else
			System.out.println("Son diferentes! ¿?");
		
		if (int5.equals(int6))
			System.out.println("Son iguales!");
		else
			System.out.println("Son diferentes! ¿?");
		
		//Forma correcta de validar
		if (int5.intValue()==int6.intValue())
			System.out.println("Son iguales!");
		else
			System.out.println("Son diferentes! ¿?");
		
		Integer numWrapper = 20;
		int num = numWrapper;  // Unboxing: convierte Integer a int automáticamente
	}

}
