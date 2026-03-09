package prPractica16;

import javax.swing.*;

public class Ejer01 extends JFrame {

	private static final long serialVersionUID = 6137086986741242863L;

	public Ejer01() {

	}

	public static void main(String[] args) {

		Ejer01 ventana = new Ejer01();

		//		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
