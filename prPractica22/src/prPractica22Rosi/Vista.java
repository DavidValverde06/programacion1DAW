package prPractica22Rosi;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JPanel{

	private static final long serialVersionUID = 4792839526301337313L;

	/**
	 * Variables de instancia
	 */
	private JButton [] bDigitos; // Array con los dígitos del 0 al 9
	private JButton [] bOperadores;  // Array con los operadores +, -, *, /
	private JButton bPunto, bIgual;
	private JTextField tfRdo;


	/**
	 * Constructor
	 */
	public Vista() {

		// Crear un panel principal (BorderLayout), donde colocaremos
		// el textField en el norte, los botones de dígitos, punto e igual en 
		// el centro, y los botones de operadores en el este
		JPanel panelPrincipal = new JPanel(new BorderLayout(5,5));

		panelPrincipal.add(preparaPanelResultado(), BorderLayout.NORTH);
		panelPrincipal.add(preparaPanelCentro(), BorderLayout.CENTER);
		panelPrincipal.add(preparaPanelEste(), BorderLayout.EAST);

		// Añadir el panel principal al panel contenedor
		this.add(panelPrincipal);
	}


	/**
	 * Método que se encarga de preparar el panel del norte
	 * @return
	 */
	private JPanel preparaPanelResultado() {
		// Pedir memoria para el JTextField
		this.tfRdo = new JTextField(10);

		// Poner el JTextField no editable y alineado a la derecha
		this.tfRdo.setEditable(false);
		this.tfRdo.setHorizontalAlignment(SwingConstants.RIGHT);
		this.tfRdo.setBackground(Color.WHITE);

		// Prepara un panel en el el colocar el JTextField
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Resultado"));
		p.add(tfRdo);

		return p;
	}


	/**
	 * Método que se encarga de preparar el panel del centro
	 */
	private JPanel preparaPanelCentro() {

		// Pedir memoria para el array
		this.bDigitos = new JButton[10];

		// Crear los botones que estarán dentro del array (digitos 0..9)
		for (int cont=0; cont<this.bDigitos.length; cont++) {
			//	this.bDigitos[cont] = new JButton(cont+"");
			//	this.bDigitos[cont] = new JButton(Integer.toString(cont));
			this.bDigitos[cont] = new JButton(String.valueOf(cont));
			this.bDigitos[cont].setBackground(Color.green);
			this.bDigitos[cont].setBorder(new BevelBorder(BevelBorder.RAISED));
		}

		// Crear los botones del punto y del igual
		this.bPunto = new JButton(".");
		this.bIgual = new JButton("=");

		// Preparar un panel con todos los componentes
		JPanel p = new JPanel(new GridLayout(4,3));
		for (int cont=1; cont<this.bDigitos.length; cont++) {
			p.add(this.bDigitos[cont]);
		}

		p.add(this.bPunto);
		p.add(this.bDigitos[0]);
		p.add(this.bIgual);

		return p;

	}

	/**
	 * Método que se encarga de preparar el panel del este
	 */

	private JPanel preparaPanelEste() {
		// Pedir memoria para el array
		this.bOperadores = new JButton[4];

		// Crear un String con los 4 operadores
		String [] operadores = {"+", "-", "*", "/"};

		// Crear un panel para colocar todos los botones de operadores
		JPanel p = new JPanel(new GridLayout(4,1));

		// Crear una fuente para los botones
		Font fuente = new Font("Comic Sans MS", Font.PLAIN, 16);

		for (int cont=0; cont<bOperadores.length; cont++) {
			this.bOperadores[cont] = new JButton(" "+operadores[cont]+" ");	
			this.bOperadores[cont].setBorder(new BevelBorder(BevelBorder.RAISED));
			this.bOperadores[cont].setFont(fuente);
			this.bOperadores[cont].setActionCommand(operadores[cont]);
			p.add(this.bOperadores[cont]);
		}

		return p;
	}


	/**
	 * Métodos getter's
	 * @return
	 */
	public JButton[] getbDigitos() {return bDigitos;}

	public JButton[] getbOperadores() {return bOperadores;}

	public JButton getbPunto() {return bPunto;}

	public JButton getbIgual() {return bIgual;}

	public JTextField getTfRdo() {return tfRdo;}


	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 * 
	 * Programaremos eventos tipo foco, action y teclado
	 */
	public void control(Controlador ctr) {

		// Añadir el control a los botones de los dígitos
		for (int cont=0; cont<this.bDigitos.length;cont++) {
			bDigitos[cont].addActionListener(ctr);
			bDigitos[cont].addKeyListener(ctr);
			bDigitos[cont].addFocusListener(ctr);
		}

		//Añadir el control a los botones de los operadore
		for (int cont=0; cont<this.bOperadores.length;cont++) {
			bOperadores[cont].addActionListener(ctr);
			bOperadores[cont].addKeyListener(ctr);
			bOperadores[cont].addFocusListener(ctr);
		}

		//Añadir el control a los botones punto e igual
		bPunto.addActionListener(ctr);
		bPunto.addKeyListener(ctr);
		bPunto.addFocusListener(ctr);

		bIgual.addActionListener(ctr);
		bIgual.addKeyListener(ctr);
		bIgual.addFocusListener(ctr);

		//Hay que añadir control al JTextField porque sino la calculadora
		//no empieza a funcionar con el teclado hasta que se pulsa algún botón con el ratón
		tfRdo.addKeyListener(ctr);
	}

}






