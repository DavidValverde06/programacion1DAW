package jamones;

public class TestJamones {

	public static void main(String[] args) {
		try {
			Granja granja1 = new Granja("Granja Polla Pollez");
			
			Cerdos cerdo1 = new Cerdos("6767", granja1, 14, false, 'M', "Cebo");
			Cerdos cerdo2 = new Cerdos("6666", granja1, 1000, true, 'H', "Nabo Nabez");

			cerdo2.setRaza(true);
			
			System.out.println(granja1+"\n");

			System.out.println(cerdo1+"\n");
			
			System.out.println(cerdo2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
