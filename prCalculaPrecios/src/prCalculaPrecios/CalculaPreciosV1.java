/**
 * Clase para probar el redondeo de números usando tanto tipos primitivos,
 * como objetos de la clase BigDecimal
 * 
 * Los eventos del botón son programados con la interfaz ActionListener y los
 * de los JTextField con las interfaces ActionListener y FocusListener, ya que
 * la interfaz TextListener, solo funciona con componentes AWT (TextField y TextArea)
 * 
 */
package prCalculaPrecios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;

public class CalculaPreciosV1 extends JFrame {

	private static final long serialVersionUID = -1911010389852016299L;

	/**
	 * Variable de clase con el color amarillo claro
	 */
	private static Color amarilloClaro;

	/**
	 * Inicializador
	 */
	static {
		amarilloClaro = new Color(255,255,153);
	}


	/**
	 * Variables de instancia
	 */
	private JTextField tfPrecioUd, tfUnidades, tfTotalBruto, tfPorDto, tfDto, 
	tfTotalConDto, tfPorIVA, tfIVA, tfTotalConIVA;
	private JButton bCancelar;
	private boolean swExcepcion;   // Variable para controlar que cuando introduzcan
	// un dato incorrecto no salte dos veces la excpeci�n
	// con el mensaje (la de focus y la de action)



	/**
	 * Constructor
	 */
	public CalculaPreciosV1() {
		// Establecer un título
		super("Calculo de precios");

		// Obtener el panel contenedor
		Container gcp = this.getContentPane();

		// Crear un nuevo tipo de letra y una etiqueta 
		Font fuente = new Font("Serif", Font.BOLD, 28);
		JLabel etiqueta = new JLabel("Cálculo de precios",JLabel.CENTER);
		etiqueta.setFont(fuente);
		etiqueta.setForeground(Color.BLUE);

		// Preparar un panel para el botón Cancelar botones
		JPanel pBotones = new JPanel();
		bCancelar = new JButton("Cancelar");
		pBotones.add(bCancelar);

		// Colocar los componentes en el panel superior
		gcp.add(etiqueta,BorderLayout.NORTH);
		gcp.add(preparaPanelDatos(),BorderLayout.CENTER);
		gcp.add(pBotones, BorderLayout.SOUTH);

		// Llamar al método que da control a los componentes
		this.control();

		// Inicializar el swExcepcion a true
		swExcepcion = true;
	}

	/**
	 * A�adir control al boton y a los JTextField
	 */
	public void control() {
		ControlBotonYFoco cb = new ControlBotonYFoco();
		bCancelar.addActionListener(cb);

		tfPrecioUd.addFocusListener(cb);
		tfPrecioUd.addActionListener(cb);

		tfUnidades.addFocusListener(cb);
		tfUnidades.addActionListener(cb);

		tfPorDto.addFocusListener(cb);
		tfPorDto.addActionListener(cb);

		tfPorIVA.addFocusListener(cb);
		tfPorIVA.addActionListener(cb);

		// A estos componente les asigno el foco aunque están deshabilitados
		// para poder saltármelos cuando me muevo con el tabulador o con el intro
		tfTotalBruto.addFocusListener(cb);
		tfDto.addFocusListener(cb);
		tfTotalConDto.addFocusListener(cb);
		tfIVA.addFocusListener(cb);
		tfTotalConIVA.addFocusListener(cb);

		// Sino lo hubiese hecho, tendría que haber "inventado" un método parecido al siguiente
		// y que tendría que haber llamado desde la parte de programación de eventos
		/*	public void pasaFoco(Object objetoEvento) {

			if (objetoEvento == tfPrecioUd) 
				tfPrecioUd.transferFocus();  // Pasa el foco al siguiente componente
			else if (objetoEvento == tfUnidades)
				tfPorDto.requestFocus();   // Asigna el foco al componente indicado
			else if (objetoEvento == tfPorDto)
				tfPorIVA.requestFocus();
			else if (objetoEvento == tfPorIVA)
				tfPrecioUd.requestFocus();
		}
		 */
	}

	/**
	 * Método que prepara un panel con la parte que solicita los datos
	 */
	private JPanel preparaPanelDatos()
	{
		JPanel p = new JPanel(new GridLayout(9,2,5,5));	

		// Pedir memoria para los textField
		tfPrecioUd    = new JTextField("0.00");
		tfUnidades    = new JTextField("0.00");
		tfTotalBruto  = new JTextField("0.00");
		tfPorDto      = new JTextField("0.00");
		tfDto         = new JTextField("0.00");
		tfTotalConDto = new JTextField("0.00");
		tfPorIVA      = new JTextField("0.00");
		tfIVA         = new JTextField("0.00");
		tfTotalConIVA = new JTextField("0.00");

		// Alinear el contenido de los JTextFields a la derecha
		tfPrecioUd.setHorizontalAlignment(JTextField.RIGHT);
		tfUnidades.setHorizontalAlignment(JTextField.RIGHT);
		tfTotalBruto.setHorizontalAlignment(JTextField.RIGHT);
		tfPorDto.setHorizontalAlignment(JTextField.RIGHT);
		tfDto.setHorizontalAlignment(JTextField.RIGHT);
		tfTotalConDto.setHorizontalAlignment(JTextField.RIGHT);
		tfPorIVA.setHorizontalAlignment(JTextField.RIGHT);
		tfIVA.setHorizontalAlignment(JTextField.RIGHT);
		tfTotalConIVA.setHorizontalAlignment(JTextField.RIGHT);

		// Deshabilitar y cambiarle el color de la fuente los JTextFiedl que ser�n calculados
		deshabilitaJTextField(tfTotalBruto);
		deshabilitaJTextField(tfDto);
		deshabilitaJTextField(tfTotalConDto);
		deshabilitaJTextField(tfIVA);
		deshabilitaJTextField(tfTotalConIVA);

		// A�adir los componentes al panel
		p.add(new JLabel("Precio unidad  ",JLabel.RIGHT)); 		
		p.add(tfPrecioUd);
		p.add(new JLabel("Unidades  ",JLabel.RIGHT));			
		p.add(tfUnidades);
		p.add(new JLabel("Total Bruto  ",JLabel.RIGHT));		
		p.add(tfTotalBruto);
		p.add(new JLabel("% Descuento  ",JLabel.RIGHT));		
		p.add(tfPorDto);
		p.add(new JLabel("Importe descuento  ",JLabel.RIGHT));	
		p.add(tfDto);
		p.add(new JLabel("Total - Descuento  ",JLabel.RIGHT));	
		p.add(tfTotalConDto);
		p.add(new JLabel("% IVA  ",JLabel.RIGHT));				
		p.add(tfPorIVA);
		p.add(new JLabel("Importe IVA  ",JLabel.RIGHT));		
		p.add(tfIVA);
		p.add(new JLabel("TOTAL A PAGAR  ",JLabel.RIGHT));		
		p.add(tfTotalConIVA);

		JPanel p2 = new JPanel();
		p2.add(p);
		return p2;
	}

	/**
	 * Deshabilita y cambiar el color de la fuente los JTextFiedl que serán calculados
	 */
	private void deshabilitaJTextField(JTextField tf) {
		tf.setEditable(false); 
		tf.setForeground(Color.black); 
		tf.setBackground(Color.white);
	}



	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		CalculaPreciosV1 ventana = new CalculaPreciosV1();
		ventana.pack();
		ventana.setSize(350,350);
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**
	 * Clase que controla los eventos, implementa las interfaces:
	 *  -- Action -- para el botón y si se pulsa intro de los JTextField
	 *  -- Focus --- para cuando cambia de un JTextField a otro
	 * @author Administrador
	 *
	 */
	class ControlBotonYFoco implements ActionListener, FocusListener {

		/**
		 * Método de la interfaz ActionListener
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getSource()==bCancelar) { // Se ha pulsado el bot�n cancelar
				limpia();
			}
			else { // Se ha pulsado intro en un JTextField
				JTextField tfActivo = (JTextField)(e.getSource());
				try {
					if (tfActivo.getText().equals(""))
						tfActivo.setText("0.00");
					Double.parseDouble(tfActivo.getText()); // Si en el campo no hay un valor num�rico saltar� la excepci�n
					calcula();
					tfActivo.transferFocus();  // Pasa el foco al siguiente componente
				}
				catch(NumberFormatException e1) {
					if (swExcepcion) 
						error(tfActivo);  // Si no ha saltado la excepci�n antes, llamo al m�todo error
				}
			}
		}


		/** 
		 * M�todo que calcula los totales con objetos de la clase BigDecimal
		 * @throws NumberFormatException
		 */
		private void calcula() throws NumberFormatException {
			//	RoundingMode RM = RoundingMode.HALF_UP;
			RoundingMode RM = RoundingMode.HALF_EVEN;  // Modo de redondeo

			// La clase BigDecimal, nos permite indicar el modo de redondeo y cuantos decimales queremos
			// esto se consigue a través del método setScale
			// Por ejemplo .setScale(2,RM) redondea a 2 decimales en modo RoundingMode.HALF_EVEN

			BigDecimal precioUd    = new BigDecimal(Double.parseDouble(tfPrecioUd.getText()));
			BigDecimal unidades    = new BigDecimal(Double.parseDouble(tfUnidades.getText()));

			BigDecimal totalBruto  = precioUd.multiply(unidades).setScale(2,RM);  

			BigDecimal porDto      = new BigDecimal(Double.parseDouble(tfPorDto.getText()));
			BigDecimal totalDto    = totalBruto.multiply(porDto).setScale(2,RM).divide(new BigDecimal(100)).setScale(2,RM);
			BigDecimal totalConDto = totalBruto.subtract(totalDto).setScale(2,RM);

			BigDecimal porIVA      = new BigDecimal(Double.parseDouble(tfPorIVA.getText()));
			BigDecimal totalIVA    = totalConDto.multiply(porIVA).setScale(2,RM).divide(new BigDecimal(100)).setScale(2,RM);
			BigDecimal totalConIVA = totalConDto.add(totalIVA).setScale(2,RM);

			// Indicamos cu�l es el caracter que utilizaremos para separar los decimales
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');

			// Creamos un patr�n para formatear la salida con 2 decimales 
			DecimalFormat patron = new DecimalFormat("0.00",simbolos);

			tfPrecioUd.setText(String.valueOf(patron.format(precioUd)));
			tfUnidades.setText(String.valueOf(patron.format(unidades)));

			tfTotalBruto.setText(String.valueOf(patron.format(totalBruto)));

			tfPorDto.setText(String.valueOf(patron.format(porDto)));
			tfDto.setText(String.valueOf(patron.format(totalDto)));
			tfTotalConDto.setText(String.valueOf(patron.format(totalConDto)));	

			tfPorIVA.setText(String.valueOf(patron.format(porIVA)));
			tfIVA.setText(String.valueOf(patron.format(totalIVA)));
			tfTotalConIVA.setText(String.valueOf(patron.format(totalConIVA)));
		}


		/** 
		 * M�todo que calcula los totales con tipos primitivos
		 * @throws NumberFormatException
		 */
		/*		private void calcula() throws NumberFormatException {

			// redondea, es un método propio que redondea a los decimales indicados
			double precioUd    = this.redondea(Double.parseDouble(tfPrecioUd.getText()),2);
			double unidades    = this.redondea(Double.parseDouble(tfUnidades.getText()),2);
			double totalBruto  = this.redondea(precioUd * unidades,2);
			double porDto      = this.redondea(Double.parseDouble(tfPorDto.getText()),2);
			double totalDto    = this.redondea(totalBruto * porDto / 100,2);
			double totalConDto = this.redondea(totalBruto - totalDto,2);
			double porIVA      = this.redondea(Double.parseDouble(tfPorIVA.getText()),2);
			double totalIVA    = this.redondea(totalConDto * porIVA / 100,2);
			double totalConIVA = this.redondea(totalConDto + totalIVA,2);

			// Indicamos cual es el caracter que utilizaremos para separar los decimales
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');

			// Creamos un patrón para formatear la salida con 2 decimales 
			DecimalFormat patron = new DecimalFormat("0.00",simbolos);

			tfPrecioUd.setText(String.valueOf(patron.format(precioUd)));
			tfUnidades.setText(String.valueOf(patron.format(unidades)));

			tfTotalBruto.setText(String.valueOf(patron.format(totalBruto)));

			tfPorDto.setText(String.valueOf(patron.format(porDto)));
			tfDto.setText(String.valueOf(patron.format(totalDto)));
			tfTotalConDto.setText(String.valueOf(patron.format(totalConDto)));	

			tfPorIVA.setText(String.valueOf(patron.format(porIVA)));
			tfIVA.setText(String.valueOf(patron.format(totalIVA)));
			tfTotalConIVA.setText(String.valueOf(patron.format(totalConIVA)));
		}

		 */

		/**
		 * M�todo que redondea al número de decimales especificado
		 * Por ejemplo, si son 2 decimales multiplicaremos por 100 y dividiremos por 100
		 *              si son 3 decimales multiplaremos por 1000 y divideremos por 1000
		 * @param num
		 * @return
		 */
		private double redondea(double num, int numDecimales) {
			double aux1=Math.round(num*Math.pow(10,numDecimales));
			double aux2=aux1/Math.pow(10,numDecimales);
			return aux2;
		}


		/**
		 * M�tood que limpia el formulario
		 */
		private void limpia() {
			tfPrecioUd.setText("0.00");
			tfUnidades.setText("0.00");
			tfTotalBruto.setText("0.00");
			tfPorDto.setText("0.00");
			tfDto.setText("0.00");
			tfTotalConDto.setText("0.00");
			tfPorIVA.setText("0.00");
			tfIVA.setText("0.00");
			tfTotalConIVA.setText("0.00");
		}

		/**
		 * M�todos de la interfaz FocusListener
		 */
		public void focusGained(FocusEvent e) {  // Foco ganado
			JTextField campoSeleccionado = ((JTextField)e.getSource());

			if (!campoSeleccionado.isEditable())  // Si el componente no es editable				
				campoSeleccionado.transferFocus(); // Pasa el foco al siguiente componente

			if (campoSeleccionado.getText().equals("0.00"))				
				campoSeleccionado.setText("");
		}

		public void focusLost(FocusEvent e) {   // Foco perdido
			JTextField tfActivo = (JTextField)(e.getSource());
			try {
				if (tfActivo.getText().equals(""))
					tfActivo.setText("0.00");
				else {
					Double.parseDouble(tfActivo.getText());  // Si en el campo no hay un valor num�rico saltar� la excepci�n
					calcula();
					tfActivo.transferFocus();  // Pasa el foco al siguiente componente
				}

			}
			catch(NumberFormatException e1) {
				if (swExcepcion) 
					error(tfActivo); // Si no ha saltado la excepci�n antes, llamo al m�todo error
			}
		}


		/**
		 * Método que muestra un dialogo de error, y cambia el color de fondo al 
		 * JTextfield erróneo hasta que se cierra la ventana de dialogo (JOptionPane)
		 * 
		 * La variable swException, al principio a false y al final a true, es para evitar
		 * que salten dos eventos a la vez, el de foco y el de action, y se vea por duplicado
		 * la ventana del error
		 * 
		 * @param tfActivo
		 */
		public void error(JTextField tfActivo) {
			swExcepcion=false;
			tfActivo.setBackground(amarilloClaro);
			JOptionPane.showMessageDialog(null, "Debe introducir un número.");
			tfActivo.setText("0.00");
			tfActivo.setBackground(Color.white);
			swExcepcion = true;
		}

	}
}
