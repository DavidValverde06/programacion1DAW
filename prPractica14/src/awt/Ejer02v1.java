package awt;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejer02v1 {

	public static void main(String[] args) {

		JFrame f = new JFrame("Ejercicio 02v1");

		Container contenPane = f.getContentPane();

		contenPane.add(new JButton("Norte"),BorderLayout.NORTH);
		contenPane.add(new JButton("Sur"),BorderLayout.SOUTH);
		contenPane.add(new JButton("Centro"),BorderLayout.CENTER);
		contenPane.add(new JButton("Este"),BorderLayout.EAST);
		contenPane.add(new JButton("Oeste"),BorderLayout.WEST);

		f.pack();

		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
