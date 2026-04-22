package ejercicioo13;

import java.awt.BorderLayout;

import javax.swing.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -7485048689846247369L;

	/**
	 * Variables de instancias
	 */
	private JCheckBox chPermisoEscritura, chPermisoLectura, chEsDirectorio, chEstaOculto;
	private JComboBox<String> miComboFicheros;

	/**
	 * Métodos Getter
	 */
	public JCheckBox getChPermisoEscritura() {return chPermisoEscritura;}
	public JCheckBox getChPermisoLectura() {return chPermisoLectura;}
	public JCheckBox getChEsDirectorio() {return chEsDirectorio;}
	public JCheckBox getChEstaOculto() {return chEstaOculto;}
	public JComboBox<String> getMiComboFicheros() {return miComboFicheros;}

	/**
	 * Constructor
	 */
	public Vista() {

		JPanel panelNorte = new JPanel();
		chPermisoEscritura = new JCheckBox("Permiso de escritura");
		chPermisoLectura = new JCheckBox("Permiso de lectura");
		chEsDirectorio = new JCheckBox("Es directorio");
		chEstaOculto = new JCheckBox("Está oculto");
		
		panelNorte.add(chPermisoEscritura);
		panelNorte.add(chPermisoLectura);
		panelNorte.add(chEsDirectorio);
		panelNorte.add(chEstaOculto);
		
		this.add(panelNorte, BorderLayout.NORTH);
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {

	}

}
