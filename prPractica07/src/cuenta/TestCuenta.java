package cuenta;

import java.time.LocalDate;

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

		
		System.out.println("\n=== CUENTA EMPRESARIAL ===");
		CuentaEmpresarial cuenta3 = new CuentaEmpresarial(345678912, "Alejandro", 5000.00f, 6767,"Amazon" , 0, 0, LocalDate.now());

		System.out.println(cuenta3+"\n");
		cuenta3.registrarReintegro(2000);

		System.out.println(cuenta3+"\n");
		cuenta3.registrarReintegro(2000);
		cuenta3.registrarIngreso(10000);

		System.out.println(cuenta3+"\n");
		cuenta3.reiniciarTotales();

		System.out.println(cuenta3+"\n");
		
		
		System.out.println("=== CAJERO ===");
		Cajero cajero1 = new Cajero(1, 1, 1, 1);
		System.out.println(cajero1);
		
		System.out.println(cajero1.disponible() + " €");
	}


}
