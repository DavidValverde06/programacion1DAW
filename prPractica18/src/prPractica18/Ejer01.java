package prPractica18;

import java.awt.*;
import javax.swing.*;

public class Ejer01 extends JFrame {

	private static final long serialVersionUID = -2739471212745483337L;

	public Ejer01() {
		super("Ejemplo con FocusListener");

		Container cp = this.getContentPane();

		// El panel principal será un BorderLayout, en el que tendremos:
		JPanel panelPrincipal = new JPanel();
		
		// En la parte norte un panel con un campo de texto, una etiqueta, un combo y un botón.
		JPanel panelNorte = new JPanel();
		JTextField tfCampoTexto = new JTextField("Campo de texto");
		JLabel jlEtiqueta = new JLabel("Una etiqueta");
		
		String[] opcionesCombo = new String[15];
		for (int cont=0;cont<opcionesCombo.length;cont++) {
			opcionesCombo[cont] = "Selecciona item #" + cont;
		}
		JComboBox<String> miCombo = new JComboBox<>(opcionesCombo);
		JButton bBoton = new JButton("Botón");

		panelNorte.add(tfCampoTexto);
		panelNorte.add(jlEtiqueta);
		panelNorte.add(miCombo);
		panelNorte.add(bBoton);

		// En el centro un JList, contenido en un JScrollPane.
		JPanel panelCentro = new JPanel();
		
		// En el sur un JTextArea, contenida en un JScrollPane, al JTextArea le he dado un tamaño de 10x5.
		JPanel panelSur = new JPanel();
		
		JTextArea atPanelSur = new JTextArea(10,5);
		JScrollPane scrollPanelSur = new JScrollPane();
		
		panelPrincipal.add(panelNorte,BorderLayout.NORTH);
		panelPrincipal.add(panelCentro,BorderLayout.CENTER);
		panelPrincipal.add(panelSur,BorderLayout.SOUTH);
		cp.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer01 ventana = new Ejer01();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
