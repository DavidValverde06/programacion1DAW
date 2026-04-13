package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import test.MainCuadradoMagico;

public class DialogoInicio extends JDialog implements ActionListener{

	private static final long serialVersionUID = 7301259959233833865L;

	/**
	 * Variables de instancia
	 */
	private JComboBox<Integer> miComboTamanioCuadrado;
	private JButton bComenzar, bSalir;
	private int dimension;

	/**
	 * Métodos getter
	 */
	public JComboBox<Integer> getMiComboTamanioCuadrado() {return miComboTamanioCuadrado;}
	public JButton getbComenzar() {return bComenzar;}
	public JButton getbSalir() {return bSalir;}
	public int getDimension() {return dimension;}

	/**
	 * Constructor
	 */
	public DialogoInicio() {

		/**
		 * Poner el dialogo modal y darle titulo
		 */
		this.setModal(true);
		this.setTitle("Dimensión del cuadrado");
		this.setLayout(new BorderLayout(20,20));

		Font fuente = new Font("Times New Roman", Font.ITALIC, 18);

		JPanel panelPrincipal = new JPanel();

		/**
		 * Preparar panel informacion
		 */
		JPanel panelInfo = prepararPanelInfo(fuente);

		/**
		 * Preparar panel dimension
		 */
		JPanel panelDimension = prepararPanelDimension(fuente);

		/**
		 * Preparar panel botones
		 */
		JPanel panelBotones = prepararPanelBotones();

		/**
		 * Añadir paneles al dialogo
		 */
		panelPrincipal.add(panelInfo,BorderLayout.NORTH);
		panelPrincipal.add(panelDimension,BorderLayout.CENTER);
		panelPrincipal.add(panelBotones,BorderLayout.SOUTH);

		this.add(panelPrincipal);

		/**
		 * Añadir control a los botones
		 */
		bComenzar.addActionListener(this);
		bSalir.addActionListener(this);

		/**
		 * Establecer tamaño, pack, ...
		 */
		// this.setLocationRelativeTo(null);
		this.setLocation(500, 250);
		this.setPreferredSize(new Dimension(450,220));
		this.pack();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Preparar Panel Botones
	 * @return
	 */
	private JPanel prepararPanelBotones() {
		JPanel panelBotones = new JPanel();
		bComenzar = new JButton("Comenzar");
		bSalir = new JButton("Salir");

		panelBotones.add(bComenzar);
		panelBotones.add(bSalir);

		return panelBotones;
	}

	/**
	 * Preparar Panel Dimension
	 * @param fuente
	 * @return
	 */
	private JPanel prepararPanelDimension(Font fuente) {
		JPanel panelDimension = new JPanel();
		JLabel etiquetaDimensionCuadrado = new JLabel("Seleccione la dimensión del cuadrado");
		etiquetaDimensionCuadrado.setFont(fuente);

		Integer[] arrayDimensionCuadrado = {3,5,7,9,11,15};
		miComboTamanioCuadrado = new JComboBox<Integer>(arrayDimensionCuadrado);

		panelDimension.add(etiquetaDimensionCuadrado);
		panelDimension.add(miComboTamanioCuadrado);
		return panelDimension;
	}

	/**
	 * Preparar Panel Info
	 * @param fuente
	 * @return
	 */
	private JPanel prepararPanelInfo(Font fuente) {
		JPanel panelInfo = new JPanel();
		JLabel etiquetaInfo = new JLabel("<html><div style='text-align: center;'>A continuación debe seleccionar la dimensión que<br> tendrá el cuadrado mágico , dicha dimensión deberá<br> ser un número entero positivo e impar</div></html>");
		etiquetaInfo.setFont(fuente);
		panelInfo.add(etiquetaInfo);
		return panelInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getbComenzar()) {
			dimension = (int)miComboTamanioCuadrado.getSelectedItem();
			this.setVisible(false);
		}
		else {
			System.exit(0);
		}

	}
}
