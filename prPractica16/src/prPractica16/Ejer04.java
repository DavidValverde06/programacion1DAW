package prPractica16;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ejer04 extends JFrame {

	private static final long serialVersionUID = -6497527245908428377L;

	public Ejer04() {

		super("Mi menú");

		Container cp = this.getContentPane();

		// Color de fondo (Naranja)
		cp.setBackground(Color.orange);

		// Menú
		JMenuBar miMenu = new JMenuBar();

		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu ver = new JMenu("Ver");
		JMenu ayuda = new JMenu("Ayuda");

		JMenuItem normal = new JMenuItem("Normal");
		JMenuItem disenioPagina = new JMenuItem("Diseño de página");
		JMenuItem esquema = new JMenuItem("Esquema");

		JMenu subMenuBarraHerramientas = new JMenu("Barra de herramientas");
		JCheckBoxMenuItem formato = new JCheckBoxMenuItem("Formato",true);
		JCheckBoxMenuItem estandar = new JCheckBoxMenuItem("Estándar",false);
		JCheckBoxMenuItem dibujo = new JCheckBoxMenuItem("Dibujo",true);

		subMenuBarraHerramientas.add(formato);
		subMenuBarraHerramientas.add(estandar);
		subMenuBarraHerramientas.add(dibujo);

		JMenuItem mapaDocumento = new JMenuItem("Mapa del documento");

		JMenuItem zoom = new JMenuItem("Zoom");

		zoom.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		ver.add(normal);
		ver.add(disenioPagina);
		ver.add(esquema);
		ver.addSeparator(); // Añade un línea separadora al menú
		ver.add(subMenuBarraHerramientas);
		ver.add(mapaDocumento);
		ver.addSeparator(); // Añade un línea separadora al menú
		ver.add(zoom);

		// Añadir menús a la barra de menú
		miMenu.add(archivo);
		miMenu.add(edicion);
		miMenu.add(ver);
		miMenu.add(ayuda);

		this.setJMenuBar(miMenu);

		// Panel Principal
		JPanel panelPrincipal = new JPanel();

		JComboBox<String> comboBoxFonts = new JComboBox<>();
		comboBoxFonts.addItem("Courier New");
		comboBoxFonts.addItem("Times New Roman");
		comboBoxFonts.addItem("Arial");

		comboBoxFonts.setSelectedIndex(0);

		JCheckBox chNegrita = new JCheckBox("Negrita",true);
		JCheckBox chCursiva = new JCheckBox("Cursiva",true);
		JCheckBox chSubrayado = new JCheckBox("Subrayado",false);

		// Cambiar el tipo de letra y tamaño de "Negrita"
		chNegrita.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		chNegrita.setForeground(Color.gray);

		//		Font font = chSubrayado.getFont();
		//		Map attributes = font.getAttributes();
		//		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		//		chSubrayado.setFont(font.deriveFont(attributes));

		// Añadir componentes al Panel Principal
		panelPrincipal.add(comboBoxFonts);
		panelPrincipal.add(chNegrita);
		panelPrincipal.add(chCursiva);
		panelPrincipal.add(chSubrayado);

		// Color de fondo (Naranja)
		panelPrincipal.setBackground(Color.orange);
		chNegrita.setBackground(Color.orange);
		chCursiva.setBackground(Color.orange);
		chSubrayado.setBackground(Color.orange);

		// Añadir el Panel Principal al Panel Contenedor (cp)
		cp.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer04 ventana = new Ejer04();

		//		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(500, 300);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
