package test;

import java.sql.SQLException;
import modelo.*;

public class TestConsola2 {

	public static void main(String[] args) {
		
		DAODisco ob = null;
		
		try {
			ob = new DAODisco();
			
			// ------------------------------------------------------
			// Prueba del avance por las filas de la tabla
			// ------------------------------------------------------
			System.out.println(ob.getPrimero().toString());
			System.out.println(ob.getSiguiente().toString());

			System.out.println(ob.getUltimo().toString());
			System.out.println(ob.getAnterior().toString());
			System.out.println(ob.getAnterior().getPrecio());
			System.out.println(ob.getSiguiente().toString());
			System.out.println(ob.getSiguiente().toString());
		
			
			// -----------------------------------------------------
			// Obtener en una colecci�n todos los discos
			// -----------------------------------------------------
			System.out.println("------------------");
			System.out.println(ob.getAll());
			System.out.println("------------------");
			System.out.println(ob.getSiguiente()+"\n");
			
			
			// -----------------------------------------------------
			// Buscar un disco
			// -----------------------------------------------------
			System.out.println("Disco buscado 3: "+ob.buscaCodigo(3));
			System.out.println("Disco buscado 88: "+ob.buscaCodigo(88));
			System.out.println("Navegacion general: "+ob.getSiguiente()+"\n");
			
			// ------------------------------------------------------
			// Insertar un disco
			// ------------------------------------------------------
			Disco d1 = new Disco(8,"Titulo 8","Autor8","26/03/2002",24.95);
			ob.insertaDisco(d1);
			
			System.out.println("Disco añadido"+d1);

			// NOTA: Si paso una fecha no valida devolvera una excepcion
//			Disco d2 = new Disco(18,"Titulo 18","Autor18","36/03/2002",24.95);
//			ob.insertaDisco(d2);

			// ------------------------------------------------------
			// Modificar un disco
			// ------------------------------------------------------
			Disco d2 = new Disco(8,"El pequeño ruiseñor", "Joselito","21/05/1992",24.95);
			ob.modificaDisco(d2);
			
			System.out.println("Disco modificado "+d2);
		
			
			// ------------------------------------------------------
			// Borrar un disco
			// ------------------------------------------------------
			ob.eliminaDisco(8);
			System.out.println("El disco 8 ha sido borrado");
		}
		catch (MiExcepcion e) {
			System.out.println(e.getMessage());
		}
		catch (SQLException e) {
			ob.printSQLException(e);
		}
		catch (Exception e) {
			e.printStackTrace();;
		}
	}

}
