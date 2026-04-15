package vista;

import java.awt.*;
import javax.swing.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private JLabel labelCuadradoMagico;
	private JButton bValidar, bGenerar, bLimpiar;
	private JTextField[][] cuadradoMagico;

	/**
	 * Constructor
	 */
	public Vista() {

		this.setLayout(new BorderLayout(20,20));

		// Crear un objeto de la clase DialogoInicio
		DialogoInicio dialogo = new DialogoInicio();

		prepararPanelEtiqueta(dialogo); // Panel Etiqueta

		JPanel panelCuadrado = new JPanel(); // Panel Cuadrado Mágico

		prepararPanelBotones(); // Panel Botones

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
}
