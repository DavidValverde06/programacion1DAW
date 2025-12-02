package biblioteca;

public class TestBiblioteca {

	public static void main(String[] args) {
		Libro libro1 = new Libro(1234, "Orgullo y prejuicio", 1813);
		Libro libro2 = new Libro(5678, "Drácula", 1897);
		Libro libro3 = new Libro(9123, "El Gran Gatsby	", 1925);
		
		System.out.println(libro3+"\n");
		
		System.out.println(libro3.estaPrestado());
		
		libro3.presta();
		
		System.out.println(libro3.estaPrestado()+"\n");
		
		System.out.println(libro3+"\n");
		
		System.out.println(libro2+"\n");
		
		System.out.println(libro1+"\n");
		
		Revista revista1 = new Revista(4567,"Rolling Stone",2025,12);
		
		System.out.println(revista1+"\n");
		
		System.out.println(revista1.getTitulo()+"\n");
	}

}
