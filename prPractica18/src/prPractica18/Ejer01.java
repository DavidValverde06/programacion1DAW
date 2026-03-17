package prPractica18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ejer01 extends JFrame implements FocusListener {

	private static final long serialVersionUID = -2739471212745483337L;

	public Ejer01() {

		super("Ejemplo con FocusListener");

		Container cp = this.getContentPane();

		// El panel principal será un BorderLayout, en el que tendremos:
		JPanel panelPrincipal = new JPanel(new BorderLayout());

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
		String[] listaArray = new String[15];
		for (int cont=0;cont<listaArray.length;cont++) {
			listaArray[cont] = "Lista item #" + cont;
		}

		JList<String> miJList = new JList<>(listaArray);
		JScrollPane scrollPanelCentro = new JScrollPane(miJList);

		// En el sur un JTextArea, contenida en un JScrollPane, al JTextArea le he dado un tamaño de 10x5.		
		JTextArea textAreaSur = new JTextArea(10,5);
		JScrollPane scrollPanelSur = new JScrollPane(textAreaSur);

		// Añadir el control de foco a todos los componentes de la ventana, excepto a los contenedores
		tfCampoTexto.addFocusListener(this);
		jlEtiqueta.addFocusListener(this);
		miCombo.addFocusListener(this);
		bBoton.addFocusListener(this);
		miJList.addFocusListener(this);
		textAreaSur.addFocusListener(this);


		// Añadir todo al Panel Principal
		panelPrincipal.add(panelNorte,BorderLayout.NORTH);
		panelPrincipal.add(scrollPanelCentro,BorderLayout.CENTER);
		panelPrincipal.add(scrollPanelSur,BorderLayout.SOUTH);

		cp.add(panelPrincipal,BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Ejer01 ventana = new Ejer01();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * En cuanto al funcionamiento de la aplicación, lo que vamos a controlar es el evento de foco
	 * (FocusEvent), así que vais a tener que implementar la interfaz FocusListener. Vamos a añadir el control
	 * de foco (addFocusListener), a todos los componentes que tenemos en la ventana, excepto a los
	 * contenedores.
	 * 
	 * - Cuando un componente gane el foco, añadiremos (método append) al JTextArea un texto en el que
	 * ponga “Foco ganado” e información del componente que ha generado el evento, método
	 * getComponent(), sobre el parámetro que os llega al método (FocusEvent e), que en realidad es el
	 * componente que generado el evento.
	 * 
	 * - De la misma forma cuando un componente pierda el foco, haréis lo mismo, pero cambiando el
	 * texto de “Foco ganado” por “Foco perdido”.
	 * 
	 * - Observar que el caso de la etiqueta no hace absolutamente nada, este componente no genera
	 * eventos tipo FocusEvent.
	 * 
	 * - Asimismo, comprobar también que cada vez que cambiáis de componente, se producen dos
	 * eventos, el que genera el componente que pierde el foco, y el que genera el componente que lo
	 * gana. Si os ayuda, podéis poner “escribes” en la consola, para que comprobéis como se van
	 * sucediendo los eventos, aunque creo que en este caso, no es necesario, ya que lo estáis mostrando
	 * en el JTextArea.
	 * 
	 * - Observar también que el método getComponent os devuelve mucha información del componente,
	 * en el caso del JComboBox, incluso la opción que habéis elegido.
	 */
	@Override
	public void focusGained(FocusEvent e) {

		System.out.println("Foco ganado: " + e.getComponent());
	}

	@Override
	public void focusLost(FocusEvent e) {

		System.out.println("Foco perdido: " + e.getComponent());
	}

}
