package prPractica22Rosi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controlador implements ActionListener, KeyListener, FocusListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista; // Vista
	private ProcesaDatos pd; // Módelo

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.pd = new ProcesaDatos(miVista.getTfRdo());
	}

	/**
	 * Métodos de FocusListener (Ganar o perder foco de un botón)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		e.getComponent().setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JButton botonPulsado = (JButton)e.getSource();

		// --------------------------------------------------------
		// Primer planteamiento: preguntando por el texto del botón
		// --------------------------------------------------------
		//		if (botonPulsado.getText().equals(" + ") ||
		//				botonPulsado.getText().equals(" - ") || 
		//				botonPulsado.getText().equals(" * ") ||
		//				botonPulsado.getText().equals(" / ") ||
		//				botonPulsado.getText().equals(".") ||
		//				botonPulsado.getText().equals("=")) {
		//
		//			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		//		}
		//		else {
		//			e.getComponent().setBackground(Color.GREEN);
		//		}


		// -----------------------------------------------------------
		// Segundo planteamiento: preguntando por el "alias" del botón
		// -----------------------------------------------------------
		//		if (botonPulsado.getActionCommand().equals("+") ||
		//				botonPulsado.getActionCommand().equals("-") ||
		//				botonPulsado.getActionCommand().equals("*") ||
		//				botonPulsado.getActionCommand().equals("/") ||
		//				botonPulsado.getActionCommand().equals("=") ||
		//				botonPulsado.getActionCommand().equals(".")) {
		//
		//			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		//		}
		//		else {
		//			e.getComponent().setBackground(Color.GREEN);
		//		}


		// ----------------------------------------------------------------
		// Tercer planteamiento: preguntando directamente por el componente
		// ----------------------------------------------------------------
		//		if (botonPulsado==miVista.getbPunto() ||
		//				botonPulsado==miVista.getbIgual() ||
		//				botonPulsado==miVista.getbOperadores()[0] ||
		//				botonPulsado==miVista.getbOperadores()[1] ||
		//				botonPulsado==miVista.getbOperadores()[2] ||
		//				botonPulsado==miVista.getbOperadores()[3]) {
		//
		//			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		//		}
		//		else {
		//			e.getComponent().setBackground(Color.GREEN);
		//		}


		// ----------------------------------------------------------------
		// Cuarto planteamiento: preguntando directamente por el componente
		// ----------------------------------------------------------------
		//		String[] simbolos = new String[]{"+","-","*","/",".","="};
		//
		//		java.util.List<String> listaSimbolos = Arrays.asList(simbolos); // En vez de añadir los elementos
		//
		//		//		listaSimbolos.add("+");
		//		//		listaSimbolos.add("-");
		//		//		listaSimbolos.add("*");
		//		//		listaSimbolos.add("/");
		//		//		listaSimbolos.add(".");
		//		//		listaSimbolos.add("=");
		//
		//		if (listaSimbolos.contains(botonPulsado.getActionCommand())) {
		//			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		//		}
		//		else {
		//			e.getComponent().setBackground(Color.CYAN);
		//		}


		// ---------------------------------------------------------------
		// Quinta formna: convirtiendo el texto del botón en un número, si
		// salta la excepcion, sabemos que SI se trata de un digito
		// ---------------------------------------------------------------
		//		try {
		//			Integer.parseInt(botonPulsado.getText());
		//			e.getComponent().setBackground(Color.GREEN);
		//		}
		//		catch (NumberFormatException e1) {
		//			e.getComponent().setBackground(UIManager.getColor("Button.background"));
		//		}


		// --------------------------------------
		// Sexta forma: con expresiones regulares
		// --------------------------------------
		//		if (botonPulsado.getText().matches("[0-9]")) {
		//			e.getComponent().setBackground(Color.GREEN);
		//		}
		//		else {
		//			e.getComponent().setBackground(UIManager.getColor("Button.background"));
		//		}

		e.getComponent().setBackground(botonPulsado.getText().matches("[0-9]") ? Color.GREEN:UIManager.getColor("Button.background"));

		// UIManager.getColor("Button.background") es equivalente a poner null

	}

	/**
	 * Métodos de KeyListener (Pulsar un botón tecleando su valor en el teclado)
	 */
	@Override
	public void keyTyped(KeyEvent e) {

		// Obtener el valor de la tecla pulsada
		char valorTecla = e.getKeyChar();

		// Definir una variable de tipo JButton que será una referencia al botón
		// cuyo valor coincide con el de la tecla pulsada, si no coincide
		// la tecla con ningun valor, esta variable estará a null
		JButton botonPulsado = null;

		try {
			botonPulsado = asignaFoco(valorTecla);
			if (botonPulsado!=null) {
				pd.procesa(valorTecla);
			}
		} catch (MiExcepcion e1) {
			// e1.printStackTrace();
			botonPulsado.setBackground(Color.RED);
			miVista.getTfRdo().setText(e1.getMessage());
		}
	}

	private JButton asignaFoco(char valorTecla) {

		JButton botonPulsado = switch (valorTecla) {
		case '+' -> miVista.getbOperadores()[0];
		case '-' -> miVista.getbOperadores()[1];
		case '*' -> miVista.getbOperadores()[2];
		case '/' -> miVista.getbOperadores()[3];
		case '.' -> miVista.getbPunto();
		case '=' -> miVista.getbIgual();

		case '0','1','2','3','4','5','6','7','8','9' -> miVista.getbDigitos()[valorTecla-48];
		// Se resta 48 porque está devolviendo el valor ASCII del número

		default -> null;
		};

		if (botonPulsado!=null) {
			botonPulsado.requestFocus();
		}

		return botonPulsado;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Métodod de la interfaz actionListener (Pulsar un botón con el ratón)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtener una referencia al botón que se ha pulsado
		JButton botonPulsado = (JButton) e.getSource();

		// Guardar el carácter del botón pulsado
		char valorBoton = botonPulsado.getActionCommand().charAt(0);

		try {
			pd.procesa(valorBoton);
		} catch (MiExcepcion e1) {
			// e1.printStackTrace();
			botonPulsado.setBackground(Color.RED);
			miVista.getTfRdo().setText(e1.getMessage());
		}
	}

}
