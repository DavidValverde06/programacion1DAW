package prEnumeraciones;

public class TestTransporte3 {

	public static void main(String[] args) {
		Transporte tp,tp2,tp3;
		
		//Obtenga todos los valores ordinales usando ordinal().
		System.out.println("Aquí están todas las constantes de Transporte " +
								"y sus valores ordinales: ");
		
		for (Transporte t:Transporte.values())
			System.out.println(t+ " "+t.ordinal());
		
		tp=Transporte.AVION;
		tp2=Transporte.TREN;
		tp3=Transporte.AVION;
		
		System.out.println();
		
		//Uso de CompareTo()
		if (tp.compareTo(tp2)<0)
			System.out.println(tp+ " llega antes que "+tp2);
		if (tp.compareTo(tp2)>0)
			System.out.println(tp2+ " llega antes que "+tp);
		if (tp.compareTo(tp3)==0)
			System.out.println(tp+ " es igual que "+tp3);

	}

}
