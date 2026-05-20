package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import controlador.*;
import modelo.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -493684082323923421L;

	/**
	 * Variables de instancia
	 */
	private JButton bCalcular,bCancelar,bVender;
	private JTextField tfCoordenadaOrigenX,tfCoordenadaOrigenY,tfCoordenadaDestinoX,tfCoordenadaDestinoY;
	private JComboBox<EnumDescuentos> comboDescuentos;
	private JCheckBox chBilleteFamiliar;
	private JLabel labelNumeroDistancia,labelNumeroPrecioBillete,labelDescuentoBillete;

	/**
	 * Constructor
	 */
	public Vista() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		// Preparar Titulo
		prepararPanelTitulo(panelPrincipal);

		// Preparar Panel Coordenadas Origen Destino
		prepararPanelCoordenadasOrigenDestino(panelPrincipal);

		// Preparar Panel Posibles Descuentos
		prepararPanelPosiblesDescuentos(panelPrincipal);

		// Preparar Panel Distancia Precio Pagar
		prepararPanelDistanciaPrecioPagar(panelPrincipal);

		// Preparar Panel Botones
		prepararPanelBotones(panelPrincipal);

		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

		this.add(panelPrincipal);
	}

	/**
	 * Método para preparar el panel Botones
	 */
	private void prepararPanelBotones(JPanel panelPrincipal) {
		JPanel panelBotones = new JPanel(new GridLayout(1,3,5,5));

		bCalcular = new JButton("Calcular");
		bCancelar = new JButton("Cancelar");
		bVender = new JButton("Vender billete");

		panelBotones.add(bCalcular);
		panelBotones.add(bCancelar);
		panelBotones.add(bVender);

		panelPrincipal.add(panelBotones);
	}

	/**
	 * Método para preparar el panel Distancia Precio Pagar
	 */
	private void prepararPanelDistanciaPrecioPagar(JPanel panelPrincipal) {
		JPanel panelDistanciaPrecioPagar = new JPanel(new GridLayout(2,1));
		panelDistanciaPrecioPagar.setLayout(new BoxLayout(panelDistanciaPrecioPagar, BoxLayout.Y_AXIS));
		ponerBordePanel(panelDistanciaPrecioPagar, "Distancia y precio a pagar");

		// Subpanel Distancia
		JPanel subpanelDistancia = new JPanel();

		JLabel lDistanciaTexto = new JLabel("Distancia: ");
		lDistanciaTexto.setHorizontalAlignment(JTextField.RIGHT);

		labelNumeroDistancia = new JLabel("0.0");
		lDistanciaTexto.setHorizontalAlignment(JTextField.LEFT);

		JLabel lDistanciaKilometro = new JLabel("km");
		lDistanciaKilometro.setHorizontalAlignment(JTextField.LEFT);

		subpanelDistancia.add(lDistanciaTexto);
		subpanelDistancia.add(labelNumeroDistancia);
		subpanelDistancia.add(lDistanciaKilometro);

		// Subpanel Precio
		JPanel subpanelPrecio = new JPanel();

		JLabel lPrecioBilleteTexto = new JLabel("Precio Billete: ");
		lPrecioBilleteTexto.setHorizontalAlignment(JTextField.RIGHT);

		labelNumeroPrecioBillete = new JLabel("0 € y 0 céntimos");
		labelNumeroPrecioBillete.setHorizontalAlignment(JTextField.LEFT);

		subpanelPrecio.add(lPrecioBilleteTexto);
		subpanelPrecio.add(labelNumeroPrecioBillete);

		// Añadir todo al panel Distancia Precio Pagar;
		panelDistanciaPrecioPagar.add(subpanelDistancia);
		panelDistanciaPrecioPagar.add(subpanelPrecio);

		panelPrincipal.add(panelDistanciaPrecioPagar);
	}

	/**
	 * Método para preparar el panel Posibles Descuentos
	 */
	private void prepararPanelPosiblesDescuentos(JPanel panelPrincipal) {
		JPanel panelPosiblesDescuentos = new JPanel();
		ponerBordePanel(panelPosiblesDescuentos, "Posibles descuentos");

		JLabel lTipoDescuento = new JLabel("Tipo descuento");
		comboDescuentos = new JComboBox<>(EnumDescuentos.values());
		chBilleteFamiliar = new JCheckBox("Billete familiar");
		JLabel lDescuento = new JLabel("Descuento a aplicar: ");
		labelDescuentoBillete = new JLabel("0");
		JLabel lDescuentoPorcentaje = new JLabel("%");

		panelPosiblesDescuentos.add(lTipoDescuento);
		panelPosiblesDescuentos.add(comboDescuentos);
		panelPosiblesDescuentos.add(chBilleteFamiliar);
		panelPosiblesDescuentos.add(lDescuento);
		panelPosiblesDescuentos.add(labelDescuentoBillete);
		panelPosiblesDescuentos.add(lDescuentoPorcentaje);

		panelPrincipal.add(panelPosiblesDescuentos);
	}

	/**
	 * Método para preparar el panel Coordenadas Origen Destino
	 */
	private void prepararPanelCoordenadasOrigenDestino(JPanel panelPrincipal) {
		JPanel panelCoordenadasOrigenDestino = new JPanel();
		panelCoordenadasOrigenDestino.setLayout(new BoxLayout(panelCoordenadasOrigenDestino, BoxLayout.Y_AXIS));
		ponerBordePanel(panelCoordenadasOrigenDestino, "Indique las coordenadas origen/destino");

		// Primer Panel (Coordenadas Origen)
		JPanel panelCoordenadas1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel lCoordenadasOrigen = new JLabel("Coordenadas de origen:  ");

		JLabel lPrimeraX = new JLabel("X");
		tfCoordenadaOrigenX = new JTextField(4);
		tfCoordenadaOrigenX.setText("0");
		tfCoordenadaOrigenX.setHorizontalAlignment(JTextField.LEFT);

		JLabel lPrimeraY = new JLabel("Y");
		tfCoordenadaOrigenY = new JTextField(4);
		tfCoordenadaOrigenY.setText("0");
		tfCoordenadaOrigenY.setHorizontalAlignment(JTextField.LEFT);

		panelCoordenadas1.add(lCoordenadasOrigen);
		panelCoordenadas1.add(lPrimeraX);
		panelCoordenadas1.add(tfCoordenadaOrigenX);
		panelCoordenadas1.add(lPrimeraY);
		panelCoordenadas1.add(tfCoordenadaOrigenY);

		// Segundo Panel (Coordenadas Destino)
		JPanel panelCoordenadas2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel lCoordenadasDestino = new JLabel("Coordenadas de destino:");

		JLabel lSegundaX = new JLabel("X");
		tfCoordenadaDestinoX = new JTextField(4);
		tfCoordenadaDestinoX.setText("0");
		tfCoordenadaDestinoX.setHorizontalAlignment(JTextField.LEFT);

		JLabel lSegundaY = new JLabel("Y");
		tfCoordenadaDestinoY = new JTextField(4);
		tfCoordenadaDestinoY.setText("0");
		tfCoordenadaDestinoY.setHorizontalAlignment(JTextField.LEFT);

		panelCoordenadas2.add(lCoordenadasDestino);
		panelCoordenadas2.add(lSegundaX);
		panelCoordenadas2.add(tfCoordenadaDestinoX);
		panelCoordenadas2.add(lSegundaY);
		panelCoordenadas2.add(tfCoordenadaDestinoY);

		panelCoordenadasOrigenDestino.add(panelCoordenadas1);
		panelCoordenadasOrigenDestino.add(panelCoordenadas2);

		panelPrincipal.add(panelCoordenadasOrigenDestino);
	}

	/**
	 * Método para preparar el panel Titulo
	 */
	private void prepararPanelTitulo(JPanel panelPrincipal) {
		JPanel panelTitulo = new JPanel();

		JLabel lTitulo = new JLabel("VENTA DE BILLETES DE TREN",JLabel.CENTER);

		Font fuente = new Font("Times New Roman", Font.BOLD, 18);

		lTitulo.setFont(fuente);

		panelTitulo.add(lTitulo);

		panelPrincipal.add(panelTitulo);
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		panel.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5),new TitledBorder(textoDelBorde)));
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	public JButton getbCalcular() {
		return bCalcular;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public JButton getbVender() {
		return bVender;
	}

	public JTextField getTfCoordenadaOrigenX() {
		return tfCoordenadaOrigenX;
	}

	public JTextField getTfCoordenadaOrigenY() {
		return tfCoordenadaOrigenY;
	}

	public JTextField getTfCoordenadaDestinoX() {
		return tfCoordenadaDestinoX;
	}

	public JTextField getTfCoordenadaDestinoY() {
		return tfCoordenadaDestinoY;
	}

	public JComboBox<EnumDescuentos> getComboDescuentos() {
		return comboDescuentos;
	}

	public JCheckBox getChBilleteFamiliar() {
		return chBilleteFamiliar;
	}

	public JLabel getLabelNumeroDistancia() {
		return labelNumeroDistancia;
	}

	public JLabel getLabelNumeroPrecioBillete() {
		return labelNumeroPrecioBillete;
	}

	public JLabel getLabelDescuentoBillete() {
		return labelDescuentoBillete;
	}

	public void setbCalcular(JButton bCalcular) {
		this.bCalcular = bCalcular;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public void setbVender(JButton bVender) {
		this.bVender = bVender;
	}

	public void setTfCoordenadaOrigenX(JTextField tfCoordenadaOrigenX) {
		this.tfCoordenadaOrigenX = tfCoordenadaOrigenX;
	}

	public void setTfCoordenadaOrigenY(JTextField tfCoordenadaOrigenY) {
		this.tfCoordenadaOrigenY = tfCoordenadaOrigenY;
	}

	public void setTfCoordenadaDestinoX(JTextField tfCoordenadaDestinoX) {
		this.tfCoordenadaDestinoX = tfCoordenadaDestinoX;
	}

	public void setTfCoordenadaDestinoY(JTextField tfCoordenadaDestinoY) {
		this.tfCoordenadaDestinoY = tfCoordenadaDestinoY;
	}

	public void setComboDescuentos(JComboBox<EnumDescuentos> comboDescuentos) {
		this.comboDescuentos = comboDescuentos;
	}

	public void setChBilleteFamiliar(JCheckBox chBilleteFamiliar) {
		this.chBilleteFamiliar = chBilleteFamiliar;
	}

	public void setLabelNumeroDistancia(JLabel labelNumeroDistancia) {
		this.labelNumeroDistancia = labelNumeroDistancia;
	}

	public void setLabelNumeroPrecioBillete(JLabel labelNumeroPrecioBillete) {
		this.labelNumeroPrecioBillete = labelNumeroPrecioBillete;
	}

	public void setLabelDescuentoBillete(JLabel labelDescuentoBillete) {
		this.labelDescuentoBillete = labelDescuentoBillete;
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {
		// Botones
		bCalcular.addActionListener(ctr);
		bCancelar.addActionListener(ctr);
		bVender.addActionListener(ctr);

		// CheckBox
		chBilleteFamiliar.addActionListener(ctr);

		// ComboBox
		comboDescuentos.addItemListener(ctr);
	}

}
