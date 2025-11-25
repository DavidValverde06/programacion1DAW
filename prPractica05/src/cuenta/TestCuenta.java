package cuenta;

public class TestCuenta {

	public static void main(String[] args) {

		Cuenta c1 = new Cuenta(1234565432, "José García Pozo", 10000);
        Cuenta c2 = new Cuenta(987654321, "María López", 5000);

        // Mostrar cuentas
        System.out.println(c1);
        System.out.println(c2);

        // Probar ingreso y reintegro
        c1.ingreso(2000);
        c2.reintegro(1000);

        System.out.println("\nDespués de operaciones:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("Acumulador banco: " + Cuenta.getAcumulador());

        // Probar saldo insuficiente
        c1.reintegro(15000);

        // Probar equals
        Cuenta c3 = new Cuenta(1234565432, "José García Pozo", 12000);
        System.out.println("\n¿c1 y c3 son iguales? " + c1.equals(c3));

        // Probar reseteaAcumuladorBanco
        System.out.println("Acumulador antes de reset: " + Cuenta.getAcumulador());
        c1.reseteaAcumuladorBanco();
        System.out.println("Acumulador después de reset: " + Cuenta.getAcumulador());

        // Probar setters
        c2.setNombreTitular("María López García");
        c2.setSaldo(7000);
        System.out.println("\nCuenta modificada con setters:");
        System.out.println(c2);
	}

}
