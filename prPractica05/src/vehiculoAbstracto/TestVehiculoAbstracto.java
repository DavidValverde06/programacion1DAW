package vehiculoAbstracto;

import java.awt.Color;

public class TestVehiculoAbstracto {

	public static void main(String[] args) {

		System.out.println("===== 🏍 MOTOCICLETAS =====");

		Motocicleta moto1 = new Motocicleta();
		moto1.setCilindrada((short)125);
		moto1.setPotencia((short)10);
		moto1.setNumOcupantes((byte)2);
		System.out.println("\nMoto 1:");
		System.out.println(moto1);
		System.out.println("Impuesto: " + moto1.impuesto() + " €");

		Motocicleta moto2 = new Motocicleta(Color.RED, (short)600, (short)70);
		moto2.setNumOcupantes((byte)2);
		System.out.println("\nMoto 2:");
		System.out.println(moto2);
		System.out.println("Impuesto: " + moto2.impuesto() + " €");

		System.out.println("\n===== 🚚 CAMIONES =====");

		Camion camion1 = new Camion((byte)6);
		camion1.setColorVehiculo(Color.BLUE);
		camion1.setCilindrada((short)3000);
		camion1.setPotencia((short)200);
		camion1.setNumEjes((byte)3);
		System.out.println("\nCamión 1:");
		System.out.println(camion1);
		System.out.println("Impuesto: " + camion1.impuesto() + " €");

		Camion camion2 = new Camion(Color.BLACK, (byte)8, (short)5000, (short)300, (byte)4);
		System.out.println("\nCamión 2:");
		System.out.println(camion2);
		System.out.println("Impuesto: " + camion2.impuesto() + " €");
	}

}
