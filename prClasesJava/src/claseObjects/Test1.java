package claseObjects;

import java.util.Objects;

public class Test1 {

	public static void main(String[] args) {

		Persona p1 = null;
		Persona p2 = new Persona("María", 30);
		Persona p3 = new Persona("Luis",36);
		Persona p4 = new Persona("María", 30);
		
		// ------------------------------------------------------------------------------
		// La clase Objects aporta seguridad en datos nulos
		// ------------------------------------------------------------------------------
		
		System.out.println("--- Prueba de equals ---");
		// Esta sentencia daría error al comparar ya que p1 es null y nos daría "NullPointerExcepcion"
//		if (p1.equals(p2)) 
//			System.out.println("Personas iguales");
//		else 
//			System.out.println("Personas distintas");
		
		// En cambio si la comparación la hacemos con el método de la clase Objects, no
		// nos daría problemas, el cual, a su vez, llama al de la clase Persona puesto 
		// que lo hemos redefinido
		if (Objects.equals(p1, p2))
			System.out.println("Personas iguales");
		else 
			System.out.println("Personas distintas");
		
		if (Objects.equals(p2, p3))
			System.out.println("Personas iguales");
		else 
			System.out.println("Personas distintas");
		
		if (Objects.equals(p2, p4))
			System.out.println("Personas iguales");
		else 
			System.out.println("Personas distintas");
		
		// De forma análoga podemos trabajar con el método toString
		System.out.println("\n--- Prueba de equals ---");
		System.out.println(p2.toString());
		
		// Esta sentencia daría error, al ser p1 un null
		// System.out.println(p1.toString()); 
		
		// En cambio, con el método toString de la clase Objects, no nos daría error,
		// y además le podríamos poner un texto para los casos en que esté a null
		System.out.println(Objects.toString(p1));
		System.out.println(Objects.toString(p1, "Dato nulo"));
		System.out.println(Objects.toString(p2, "Dato nulo"));
		System.out.println(Objects.toString(p2));
		
		// Este método nos da la misma información del objeto que proporciona el método
		// toString de la clase Object cuando no se ha redefinido en la clase en
		// cuestión. Es decir, información sobre la clase, paquete y dirección de memoria
		System.out.println(Objects.toIdentityString(p2));
		
		// ------------------------------------------------------------------------------
		// La clase Objects también aporta métodos para el control de nulos
		// ------------------------------------------------------------------------------
	
		// Control de nulos en validaciones
	//	Objects.requireNonNull(p1);  // Esta sentencia nos dará error, "NullPointerException2
		                             // ya que p1 es null
		Objects.requireNonNull(p2);
		
		// Verificación de nulos en validaciones
		if (p1==null) // Esta forma queda un poco más "fea", aunque perfectamente válida
			System.out.println("p1 está a null");
		
		if (Objects.isNull(p1))  // Planteamiento más "profesional"
			System.out.println("p1 está a null");
		
		if (Objects.nonNull(p2))
			System.out.println("p2 no es nulo");
	}

}





