package ejercicioo13;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -7485048689846247369L;

	/**
	 * Variables de instancias
	 */
	private JCheckBox chPermisoEscritura, chPermisoLectura, chEsDirectorio, chEstaOculto;
	private JComboBox<String> miComboFicheros;
	private JLabel labelInformacion;
	private File ruta;

	/**
	 * Métodos Setter
	 */
	public void setChPermisoEscritura(JCheckBox chPermisoEscritura) {
		this.chPermisoEscritura = chPermisoEscritura;
	}
	public void setChPermisoLectura(JCheckBox chPermisoLectura) {
		this.chPermisoLectura = chPermisoLectura;
	}
	public void setChEsDirectorio(JCheckBox chEsDirectorio) {
		this.chEsDirectorio = chEsDirectorio;
	}
	public void setChEstaOculto(JCheckBox chEstaOculto) {
		this.chEstaOculto = chEstaOculto;
	}
	public void setMiComboFicheros(JComboBox<String> miComboFicheros) {
		this.miComboFicheros = miComboFicheros;
	}
	public void setLabelInformacion(JLabel labelInformacion) {
		this.labelInformacion = labelInformacion;
	}
	public void setRuta(File ruta) {
		this.ruta = ruta;
	}

	/**
	 * Métodos Getter
	 */
	public JCheckBox getChPermisoEscritura() {return chPermisoEscritura;}
	public JCheckBox getChPermisoLectura() {return chPermisoLectura;}
	public JCheckBox getChEsDirectorio() {return chEsDirectorio;}
	public JCheckBox getChEstaOculto() {return chEstaOculto;}
	public JComboBox<String> getMiComboFicheros() {return miComboFicheros;}
	public JLabel getLabelInformacion() {return labelInformacion;}
	public File getRuta() {return ruta;}

	/**
	 * Constructor
	 */
	public Vista() {
		this.setLayout(new BorderLayout());
		prepararPanelNorte();
		prepararPanelCentro();
		prepararPanelSur();
	}

	/**
	 * Método prepararPanelNorte()
	 */
	private void prepararPanelNorte() {
		JPanel panelNorte = new JPanel();
		chPermisoEscritura = new JCheckBox("Permiso de escritura");
		chPermisoLectura = new JCheckBox("Permiso de lectura");
		chEsDirectorio = new JCheckBox("Es directorio");
		chEstaOculto = new JCheckBox("Está oculto");

		chPermisoEscritura.setEnabled(false);
		chPermisoLectura.setEnabled(false);
		chEsDirectorio.setEnabled(false);
		chEstaOculto.setEnabled(false);

		panelNorte.add(chPermisoEscritura);
		panelNorte.add(chPermisoLectura);
		panelNorte.add(chEsDirectorio);
		panelNorte.add(chEstaOculto);

		this.add(panelNorte, BorderLayout.NORTH);
	}

	/**
	 * Método prepararPanelCentro()
	 */
	private void prepararPanelCentro() {
		JPanel panelCentro = new JPanel();
		JPanel panelRutas = new JPanel();
		miComboFicheros = new JComboBox<String>();
		ruta = new File("c:/");

		miComboFicheros.setModel(new DefaultComboBoxModel<String>(ruta.list()));

		actualizarCheck();

		panelRutas.add(miComboFicheros);
		panelCentro.add(panelRutas);

		this.add(panelCentro, BorderLayout.CENTER);
	}

	/**
	 * Método prepararPanelSur()
	 */
	private void prepararPanelSur() {
		JPanel panelSur = new JPanel();
		labelInformacion = new JLabel();
		panelSur.add(labelInformacion);

		this.add(panelSur, BorderLayout.SOUTH);
	}

	/**
	 * Método actualizarCheck()
	 */
	protected void actualizarCheck() {

		//		if (ruta.canWrite()==true) {
		//			chPermisoEscritura.setSelected(true);
		//		}
		//		else {
		//			chPermisoEscritura.setSelected(false);
		//		}

		chPermisoEscritura.setSelected(ruta.canWrite());

		chPermisoLectura.setSelected(ruta.canRead());

		chEsDirectorio.setSelected(!ruta.isFile()); // No funciona bien .isDirectory()

		chEstaOculto.setSelected(ruta.isHidden());
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {
		miComboFicheros.addActionListener(ctr);
	}

}
