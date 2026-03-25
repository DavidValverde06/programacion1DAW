package prPractica22Rosi;

import javax.swing.JTextField;

/**
 * Clase que controla el funcionamiento de la calculadora, se podria considerar esta
 * clase como el modelo de la aplicación, es decir la parte logica. Aunque en este
 * caso, se esta mezclando con la parte gráfica, por tanto no es un modelo "puro"
 * 
 * @author Administrador
 *
 */
public class ProcesaDatos 
{
	/**
	 * Variables de instancia 
	 */
	private JTextField tfrdo;
	private double op1, op2;   // Operandos con los que hacer la operacion indicada
	private char operacion;    // Operacion a realizar, podra ser +,-,*,/
	private int estado;        // Estado en que se encuentra la calculadora en un momento dado
	// siguiendo la MAQUINA DE ESTADOS, del enunciado de la pr�ctica
	// Los valores que tomara la variable estado seran:
	// 0 -- No hemos recibido aun nada o hemos comenzado de nuevo, se espera un 
	//      dígito o el signo "-" para el primer operando
	// 1 -- Se ha puesto signo negativo al primer operando, se esperan sus dígitos
	// 2 -- Se están introduciendo los digitos (parte entera) del primer operando, o 
	//      bien se pulsa el punto decimal (estado 3) o el operador (estado 5)
	// 3 -- Se están introduciendo los digitos de la parte decimal del operando 1
	//      (asegura que al menos se introduce un dígito decimal)
	// 4 -- Se continuan introduciendo los dígitos decimales del operando 1 
	//      o bien el operador (estado 5)
	// 5 -- Hemos recibido un numero y un operador y estamos a la espera de un 
	//   -- dígito o del signo "-"
	// 6 -- Se ha puesto signo negativo al segundo operando, se esperan sus dígitos
	// 7 -- Se están introduciendo los digitos del segundo operando (parte entera), 
	//      o bien se pulsa el punto decimal (estado 8) o el igual (estado 10)
	// 8 -- Se están introduciendo los digitos de la parte decimal del operando 2
	//      (asegura que al menos se introduce un dígito decimal)
	// 9 -- Se continua con los dígitos decimales del operando 2 o bien el igual
	// 10-- Ya se ha realizado la operacion, se espera un nuevo operador

	/**
	 * Constructor
	 * @param tf
	 */
	public ProcesaDatos(JTextField tf) {
		this.tfrdo = tf;
	}

	/**
	 * M�todo para el control de la calculadora
	 * @param valor --> Se correpondera con el valor correspodiente al boton pulsado, o tecla pulsada,
	 *                  es decir, uno de los dígitos del 0 al 9, una de las operaciones (+,-,*,/), el
	 *                  s�mbolo "." o bien el s�mbolo "="
	 *                  
	 * @throws MiExcepcion --> Se relanza si algo va mal en la calculadora, se capturar� desde el 
	 *                         Controlador
	 */
	public void procesa(char valor) throws MiExcepcion
	{

		char valor_aux;
		if (tfrdo.getText().equals("ERROR")) tfrdo.setText("");

		valor_aux = convierte_valor(valor);

		switch (estado)  // Va controlando la evoluci�n de la calculadora
		{
		// No se ha recibido nada o hemos comenzado de nuevo, se espera un 
		// dígito o el signo "-" para el primer operando
		case 0: 
			switch (valor_aux)
			{
			case '-': estado = 1; tfrdo.setText(tfrdo.getText()+valor); break;
			case 'd': estado = 2; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se ha puesto signo negativo al primer operando, se esperan sus dígitos
		case 1: 
			switch (valor_aux)
			{
			case 'd': estado = 2; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se están introduciendo los digitos del primer operando (parte entera), 
			// o bien se pulsa el punto decimal (estado 3) o el operador (estado 5)
		case 2: 
			switch (valor_aux)
			{
			case '.': estado = 3; tfrdo.setText(tfrdo.getText()+valor); break;
			case '+':
			case '-':
			case '*':
			case '/': estado = 5; 
			operacion = valor;
			op1=Double.parseDouble(tfrdo.getText());
			tfrdo.setText(" ");
			break;
			case 'd': tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se están introduciendo los digitos de la parte decimal del operando 1
			// (asegura que al menos se introduce un dígito decimal)
		case 3: 
			switch (valor_aux)
			{
			case 'd': estado = 4; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se continua con los dígitos decimales del operando 1 o bien el operador 
		case 4: 
			switch (valor_aux)
			{
			case '+':
			case '-':
			case '*':
			case '/': estado = 5; 
			operacion = valor;
			op1=Double.parseDouble(tfrdo.getText());
			tfrdo.setText(" ");
			break;
			case 'd': tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Hemos recibido un n�mero y un operador y estamos a la espera de un dígito
			// o del signo "-" para el segundo operando
		case 5: 
			switch (valor_aux)
			{
			case '-': estado = 6; tfrdo.setText(tfrdo.getText()+valor); break;
			case 'd': estado = 7; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se ha puesto signo negativo al segundo operando, se esperan sus dígitos
		case 6: 
			switch (valor_aux)
			{
			case 'd': estado = 7; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se están introduciendo los digitos del segundo operando (parte entera), 
			// o bien se pulsa el punto decimal (estado 8) o el igual (estado 10)
		case 7: 
			switch (valor_aux)
			{
			case '.': estado = 8; tfrdo.setText(tfrdo.getText()+valor); break;
			case '=': estado = 10; 
			op2 = Double.parseDouble(tfrdo.getText());
			double rdo = calculaResultado();
			tfrdo.setText(String.valueOf(rdo)); 
			op1 = rdo;
			break;
			case 'd': tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se están introduciendo los digitos de la parte decimal del operando 2
			// (asegura que al menos se introduce un dígito decimal)
		case 8: 
			switch (valor_aux)
			{
			case 'd': estado = 9; tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Se continua con los dígitos decimales del operando 2 o bien el igual
		case 9: 
			switch (valor_aux)
			{
			case '=': estado = 10; 
			op2 = Double.parseDouble(tfrdo.getText());
			double rdo = calculaResultado();
			tfrdo.setText(String.valueOf(rdo)); 
			op1 = rdo;
			break;
			case 'd': tfrdo.setText(tfrdo.getText()+valor); break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;

			// Ya se ha realizado la operación, se espera un nuevo operador
		case 10: 
			switch (valor_aux)
			{
			case '+':
			case '-':
			case '*':
			case '/': estado = 5; 
			operacion = valor;
			tfrdo.setText(" ");
			break;
			default: iniciar(); throw new MiExcepcion();
			}
			break;
		}
	}

	/**
	 *  Retorna "d" si es un dígito o el valor orignal en otro caso
	 * @param valor
	 * @return
	 */
	private char convierte_valor(char valor)
	{
		switch (valor)  // Utilizo una variable auxiliar para guardar el valor del 
		{				// botón pulsado, si es un dígito, guardo en esta vble. "d"
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': return 'd'; // Indica que es un dígito
		default : return valor; 
		}
	}


	/**
	 *  Inicializa el visor y el operador a blanco, y los operandos a 0 
	 */
	private void iniciar()
	{
		estado=0;
		tfrdo.setText("");
		op1=0;
		op2=0;
		operacion=' ';
	}


	/**
	 * Efectua la operacion 
	 * @return
	 */
	private double calculaResultado()
	{
		double resultado = 0;
		switch(operacion) {
		case '+' -> resultado = op1 + op2;
		case '-' -> resultado = op1 - op2;
		case '*' -> resultado = op1 * op2;
		case '/' -> resultado = op1 / op2;
		}

		return resultado;
	}
}








