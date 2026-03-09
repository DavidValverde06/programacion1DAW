package awt;

import java.awt.*;
import javax.swing.*;

public class Ejer03v1 {

	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame("Ejercicio 03v1");

		Container contenPane = f.getContentPane();

		JButton botonPanel1 = new JButton("Panel1");
		JButton botonPanel2 = new JButton("Panel2");
		JButton botonSur = new JButton("Sur");

		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(botonPanel1);
		p.add(botonPanel2);

		contenPane.add(new JButton("Norte"),BorderLayout.NORTH);
		contenPane.add(botonSur,BorderLayout.SOUTH);
		contenPane.add(new JButton("Este"),BorderLayout.EAST);
		contenPane.add(new JButton("Centro"),BorderLayout.CENTER);
		contenPane.add(p,BorderLayout.WEST);

		f.pack();

		f.setVisible(true);

		f.setLocationRelativeTo(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread.sleep(5000);

		botonSur.setVisible(false);

		f.pack();
	}

}
