package awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejer02v2 {

	public static void main(String[] args) {

		JFrame f = new JFrame("Ejercicio 02v2");

		Container contenPane = f.getContentPane();
		
		// Especificar un espaciado entre componentes al Gestor de esquemas
		contenPane.setLayout(new BorderLayout(10,30));
		
		JButton bCentro = new JButton("Centro");
		bCentro.setPreferredSize(new Dimension(100,100));

		// Cambiar color de la fuente (foreground) y de fondo (background)
		bCentro.setForeground(Color.YELLOW);
		bCentro.setBackground(Color.BLUE);
		
		JPanel pCentro = new JPanel();

		
		contenPane.add(new JButton("Norte"),BorderLayout.NORTH);
		contenPane.add(new JButton("Sur"),BorderLayout.SOUTH);
		contenPane.add(new JButton("Este"),BorderLayout.EAST);
		contenPane.add(new JButton("Oeste"),BorderLayout.WEST);
		pCentro.add(bCentro);
		contenPane.add(pCentro);
		
		// Pedir ajuste de los componentes al contenedor
		f.pack();

		// Mostrar contenido
		f.setVisible(true);

		// Cambiar tamaño de pantalla
		f.setResizable(false);
		
		// Programa el cierre de la ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
