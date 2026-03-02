package videojuegos;

public class TestVentaVideojuegos {

	public static void main(String[] args) {

		Juego juego1 = new Juego("EA Sports FC", Plataforma.XBOX, 41);
		Juego juego2 = new Juego("Mario Kart", Plataforma.NINTENDO, 26);
		Juego juego3 = new Juego("Dragon Ball", Plataforma.XBOX, 19);
		Juego juego4 = new Juego("Super Mario Bros", Plataforma.NINTENDO, 44);
		Juego juego5 = new Juego("Final Fantasy", Plataforma.PLAYSTATION, 40);

		
		System.out.println(juego1 + "\n");
		
		String[] juegosMasVendidos = {juego1.getNombre(),juego2.getNombre(),juego3.getNombre(),juego4.getNombre(),juego5.getNombre()};
		
		Ventas venta1 = new Ventas(juegosMasVendidos);
		
		System.out.println(venta1);
	}

}
