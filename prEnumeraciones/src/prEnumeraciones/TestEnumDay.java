package prEnumeraciones;

public class TestEnumDay {

	/**
	 * Variable de instancia
	 */
	private Day dia;
	
	/**
	 *  Constructor
	 * @param dia
	 */
	public TestEnumDay(Day dia) {
		this.dia = dia;
	}
	
	
	/**
	 *  Imprime una l�nea sobre el DIA usando switch
	 */
	public void diaEs() {
		switch (dia) {
		case LUNES:
			System.out.println("Los lunes son feos."); break;
		case VIERNES:
			System.out.println("Los viernes son mejores."); break;
		case SABADO:
		case DOMINGO:
			System.out.println("Los fines de semana son mejores.");
			break;
		default:
			System.out.println("Los d�as entre semana son regulares.");
			break;
		}
	}

	/**
	 * Metodo principal
	 */
	public static void main(String[] args) {
		String str = "Lunes";
		
			
		TestEnumDay t1 = new TestEnumDay(Day.valueOf(str.toUpperCase()));
		
		t1.diaEs();
		
		TestEnumDay t2 = new TestEnumDay(Day.MIERCOLES);
		t2.diaEs();
		
		TestEnumDay t3 = new TestEnumDay(Day.valueOf("VIERNES"));
		t3.diaEs();
	}
}









