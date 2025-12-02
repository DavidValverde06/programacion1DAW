package cuenta;

public class TestCuenta {

	public static void main(String[] args) {

		System.out.println("=== CUENTA ===");
		
		Cuenta cuenta1 = new Cuenta(123456789, "David", 1300.00f, 1234);
		
		System.out.println(cuenta1+"\n");
		
		cuenta1.imposicion(500);
		
		System.out.println("Saldo actual: " + cuenta1.getSaldoActual() + "\n");
		
		System.out.println(cuenta1+"\n");
		
		cuenta1.reintegro(1900);
		
		System.out.println(cuenta1+"\n");
		
		System.out.println("=== CUENTA JOVEN ===");
		
		CuentaJoven cuenta2 = new CuentaJoven(912345678, "Noe", 1600.60f, 1111,(byte)18);
		
		System.out.println(cuenta2+"\n");
		
		cuenta2.reintegro(1700.00f);
		
		System.out.println(cuenta2+"\n");
		
		cuenta2.reintegro(600);
		
		System.out.println(cuenta2+"\n");
		
		System.out.println(cuenta2.validar(1121)?"PIN introducido correcto":"PIN introducido erróneo");
		System.out.println(cuenta2.validar(1111)?"PIN introducido correcto":"PIN introducido erróneo");

	}
	

}
