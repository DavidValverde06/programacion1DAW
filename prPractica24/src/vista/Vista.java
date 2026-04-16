package vista;

import java.awt.*;
import javax.swing.*;
import controlador.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private JLabel labelCuadradoMagico;
	private JButton bValidar, bGenerar, bLimpiar;
	private JTextField[][] tfCuadradoMagico;

	/**
	 * Métodos getter
	 */
	public JLabel getLabelCuadradoMagico() {return labelCuadradoMagico;}
	public JButton getbValidar() {return bValidar;}
	public JButton getbGenerar() {return bGenerar;}
	public JButton getbLimpiar() {return bLimpiar;}
	public JTextField[][] getTfCuadradoMagico() {return tfCuadradoMagico;}

	/**
	 * Constructor
	 */
	public Vista() {

		this.setLayout(new BorderLayout(20,20));

		// Crear un objeto de la clase DialogoInicio
		DialogoInicio dialogo = new DialogoInicio();

		prepararPanelEtiqueta(dialogo); // Panel Etiqueta
		prepararPanelCuadrado(dialogo); // Panel Cuadrado Mágico
		prepararPanelBotones(); // Panel Botones

	}

	/**
	 * Preparar Panel Cuadrado
	 */
	private void prepararPanelCuadrado(DialogoInicio dialogo) {
		JPanel panelCentral = new JPanel();
		JPanel panelCuadrado = new JPanel(new GridLayout(dialogo.getDimension(),dialogo.getDimension()));
		Font fuente = new Font("Times New Roman", Font.BOLD, 12);
		tfCuadradoMagico = new JTextField[dialogo.getDimension()][dialogo.getDimension()];

		for (int cont1=0;cont1<tfCuadradoMagico.length;cont1++) {
			for (int cont2=0;cont2<tfCuadradoMagico.length;cont2++) {
				tfCuadradoMagico[cont1][cont2] = new JTextField(2);

				tfCuadradoMagico[cont1][cont2].setFont(fuente);
				tfCuadradoMagico[cont1][cont2].setHorizontalAlignment(SwingConstants.RIGHT);
				panelCuadrado.add(tfCuadradoMagico[cont1][cont2]);
			}
		}

		panelCentral.add(panelCuadrado);
		this.add(panelCentral, BorderLayout.CENTER);
	}

	/**
	 * Preparar Panel Botones
	 */
	private void prepararPanelBotones() {
		JPanel panelBotones = new JPanel();
		bValidar = new JButton("Validar");
		bGenerar = new JButton("Generar");
		bLimpiar = new JButton("Limpiar");

		panelBotones.add(bValidar);
		panelBotones.add(bGenerar);
		panelBotones.add(bLimpiar);

		this.add(panelBotones, BorderLayout.SOUTH);
	}

	/**
	 * Preparar Panel Etiqueta
	 * @param dialogo
	 */
	private void prepararPanelEtiqueta(DialogoInicio dialogo) {
		JPanel panelEtiqueta = new JPanel();
		labelCuadradoMagico = new JLabel("Cuadrado mágico de " + dialogo.getDimension(), JLabel.CENTER);
		Font fuente = new Font("Times New Roman", Font.BOLD, 18);
		labelCuadradoMagico.setFont(fuente);

		panelEtiqueta.add(labelCuadradoMagico);

		this.add(panelEtiqueta, BorderLayout.NORTH);
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {
		this.bGenerar.addActionListener(ctr);
		this.bValidar.addActionListener(ctr);
		this.bLimpiar.addActionListener(ctr);
	}
}
