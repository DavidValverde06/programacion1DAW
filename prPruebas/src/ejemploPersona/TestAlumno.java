package ejemploPersona;

public class TestAlumno {

	public static void main(String[] args) {

		Alumno a1 = new Alumno("Pepe", (byte)18, "1º DAW");
		
		Alumno a2 = new Alumno("Maria", (byte)16, "4º ESO");
		
		System.out.println("Alumno 1: " + a1.toString());
		
		System.out.println("Alumno 2: " + a2.toString());
		
		Alumno a3 = new Alumno("Juan Carlos", (byte)22, "2º DAW");
		
		System.out.println("Alumno 3: " + a3);
		
		System.out.println("El alumno 2 se llama: " + a2.getNombre());
		
		a2.setNombre("La peruana");
		
		System.out.println("El alumno 2 se llama: " + a2.getNombre() + "\n");

		System.out.println(a1.esMayorDeEdad()?"Es mayor de edad":"Es menor de edad");
		
		System.out.println("\nEl alumno " + a1.getNombre() + " pagará por su matricula "  + a1.costeMatricula() + " €");
		System.out.println("El alumno " + a2.getNombre() + " pagará por su matricula "  + a2.costeMatricula() + " €");
		
	}

}
