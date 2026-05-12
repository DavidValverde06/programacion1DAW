package prPractica20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * B) En este segundo ejemplo, lo que haremos será escribir en un JTextArea, un texto que informe del
 * 		evento de teclado que se está generando cada vez que se pulse una tecla. Cuando lo programéis os
 * 		daréis cuenta, de que al igual que pasaba con los eventos de ratón, cada vez que se pulsa una tecla,
 * 		en realidad se generan 3 eventos. Además vamos a añadir que cuando la tecla pulsada, sea una ‘H’,
 * 		da igual que nos la tecleen en mayúscula o minúscula, además mostraremos HOLA!!!! en el
 * 		JTextArea. El control de los eventos de teclado tenéis que añadírselo al componente JTextArea.
 */
public class Ejer01v2 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1954900477898937278L;

	// Variables de instancia
	private JTextArea areaTexto;

	// Constructor
	public Ejer01v2() {

		super("Pruebas eventos KeyEvent");

		Container cp = this.getContentPane();

		areaTexto = new JTextArea(); 
		areaTexto.addKeyListener(this); // Añadir KeyListener al JTextArea
		areaTexto.setEditable(false); // Para que no se pueda escribir en el JTextArea

		JScrollPane panelPrincipal = new JScrollPane(areaTexto);

		cp.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer01v2 ventana = new Ejer01v2();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(300,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar()=='h' || e.getKeyChar()=='H') {
			areaTexto.append("HOLA!!!!\n");
		}
		areaTexto.append("Tecla pulsada y soltada -->" + e.getKeyChar() + "\n");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		areaTexto.append("Tecla pulsada\n");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		areaTexto.append("Tecla soltada\n");
	}

}
