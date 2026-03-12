package prPractica17;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ejer01 extends JFrame {

	private static final long serialVersionUID = -4348439484158558922L;

	public Ejer01() {

		super("Examen de Java");

		// Panel Contenedor
		Container cp = this.getContentPane();

		/**
		 * El panel contenedor del JFrame tiene un borde vacío alrededor, por eso nos queda más espaciado
		 * con respecto al borde de la ventana.
		 */
		((JComponent) cp).setBorder(new EmptyBorder(10,30,10,30));

		// Panel Norte
		JPanel panelNorte = new JPanel();
		panelNorte.add(new JLabel("Esto es un ejercicio de JAVA"),JLabel.CENTER);

		// -------------------------------------------------------------------------------------------------------
		// Panel Centro
		JPanel panelCentro = new JPanel(new GridLayout(1,2));

		JPanel panelCentroIzquierdo = new JPanel(new GridLayout(1,2));

		JPanel panelBotones = new JPanel(new GridLayout(3,1));
		JButton b1 = new JButton("Botón 1");
		JButton b2 = new JButton("Botón 2");
		JButton b3 = new JButton("Botón 3");

		String [] arrayLista = new String[15];
		for (int i=0; i<arrayLista.length; i++) {
			arrayLista[i] = "Item número "+(i+1);
		}

		JList<String> miLista = new JList<String>(arrayLista);

		JScrollPane panelLista = new JScrollPane(miLista);

		panelBotones.add(b1);
		panelBotones.add(b2);
		panelBotones.add(b3);
		panelCentroIzquierdo.add(panelBotones);
		panelCentroIzquierdo.add(panelLista);

		JPanel panelCentroDerecho = new JPanel(new GridLayout(4,1));

		JLabel lEdad = new JLabel("Marca tu edad:");

		ButtonGroup grupoBotones = new ButtonGroup();
		JRadioButton jrb1 = new JRadioButton("Menor de 20",false);
		JRadioButton jrb2 = new JRadioButton("Mayor de 20 y menor de 35",true);
		JRadioButton jrb3 = new JRadioButton("Mayor de 35",false);

		grupoBotones.add(jrb1);
		grupoBotones.add(jrb2);
		grupoBotones.add(jrb3);

		panelCentroDerecho.add(lEdad);
		panelCentroDerecho.add(jrb1);
		panelCentroDerecho.add(jrb2);
		panelCentroDerecho.add(jrb3);

		/**
		 * El panel contenedor de la edad, es un buen panel para que probéis a ponerles distintos bordes,
		 * consultar el apartado 7 del tema 9, y la ayuda de Java. Aquí os dejo algunos ejemplos, que podéis
		 * probar, algunos ya veréis que son horribles, otros, no quedan mal. Vais quitando comentarios, y
		 * los vais probando. Probar vosotros otras combinaciones.
		 */

		// PRUEBA DE BORDES SOBRE EL panelEdad

		// EtcherBorder --> Crea una linea resaltada o hundida.
		// panelEdad.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		// TitledBorder --> Crea un borde añadiendo un tilulo a otro borde.
		// panelEdad.setBorder(new TitledBorder("Marca tu edad"));
		// panelEdad.setBorder(new TitledBorder(new LineBorder(Color.blue,3,true),"Titulo"));

		// LineBorder --> Dibuja una linea de diferentes grosores..
		// panelEdad.setBorder(new LineBorder(Color.red,5));

		// MatteBorder --> Crea un borde usando un color o una imagen.
		// panelEdad.setBorder(new MatteBorder(5,15,30,30,Color.LIGHT_GRAY));

		// BevelBorder --> Presenta al componente alzado o hundido.
		// panelEdad.setBorder(new BevelBorder(BevelBorder.RAISED));

		// SoftBevelBorder --> Mas suave que BevelBorder.
		// panelEdad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));

		// EmptyBorder --> Borde para añadir espacio vacio.
		// panelEdad.setBorder(new EmptyBorder(5,15,30,30));

		// CompoundBorder --> Compone dos bordes en uno solo
		// panelEdad.setBorder(
		// new CompoundBorder(new EtchedBorder(),
		// new LineBorder(Color.red,3)));

		/**
		 * En la captura de pantalla que os he puesto, el panel de la edad tiene el siguiente borde:
		 */
		panelCentroDerecho.setBorder(
				new CompoundBorder(
						new TitledBorder("Borde compuesto"),
						new BevelBorder(BevelBorder.RAISED)));

		// Añadir paneles al Panel Centro
		panelCentro.add(panelCentroIzquierdo);
		panelCentro.add(panelCentroDerecho);
		// -------------------------------------------------------------------------------------------------------

		// Panel Sur
		JPanel panelSur = new JPanel();

		JComboBox<String> miCombo = new JComboBox<>();
		for (int cont=0;cont<15;cont++) {
			miCombo.addItem("Elección " + (cont+1));
		}

		JTextField tfObservacion = new JTextField(15);

		// Añadir componentes al Panel Sur
		panelSur.add(miCombo);
		panelSur.add(new JLabel("Observación:"));
		panelSur.add(tfObservacion);

		// Añadir paneles al Panel Contenedor (cp)
		cp.add(panelNorte,BorderLayout.NORTH);
		cp.add(panelCentro,BorderLayout.CENTER);
		cp.add(panelSur,BorderLayout.SOUTH);
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
