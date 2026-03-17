package prPractica18;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * 2.- En este segundo ejercicio, os voy a proponer un juego sencillo para jugar con el ordenador a lanzar una
 * par de dados aleatoriamente. Programaremos un evento tipo Action (ActionEvent), que se lanzará al
 * pulsar el botón Lanzar dados:
 */
public class Ejer02 extends JFrame {

	faltan eventos

	private static final long serialVersionUID = 4589263424739830124L;

	// Variables de instancia
	private JLabel etiquetaPuntosObtenidos;
	private JLabel puntos;
	private JTextField dado1Apuesta;
	private JTextField dado2Apuesta;
	private JTextField dado1Resultado;
	private JTextField dado2Resultado;
	private JButton bLanza;

	// Constructor
	public Ejer02() {

		super("Jugar a los dados");

		this.setIconImage(new ImageIcon("dados.gif").getImage());

		Container cp = this.getContentPane();

		/**
		 * Respecto a la distribución de componentes y paneles, yo he seguido la siguiente, aunque podéis
		 * buscar otras alternativas:
		 * 
		 * - El panel principal (contentPane) es un BorderLayout, en el que se ha colocado en el norte el panel
		 * con la puntuación, en el centro otro panel con la apuesta del jugador y el resultado, y en el sur un
		 * último panel que contiene el botón de lanzamiento.
		 */
		JPanel panelPrincipal = new JPanel(new BorderLayout());


		// ----------- //
		// Panel Norte //
		// ----------- //

		/**
		 * El panel de la puntuación es un panel FlowLayout con alineación a la derecha, en el que he
		 * colocado la etiqueta con el texto Puntos obtenidos, y otra etiqueta, con el número 0, inicialmente,
		 * y que conforme el juego comience a funcionar se irá actualizando. El tipo de fuente que he usado
		 * para estas dos etiquetas es Comic Sans Ms, en negrita y con un tamaño de 15.
		 * 
		 * Font fuente = new Font("Comic Sans MS", Font.BOLD, 15);
		 */
		JPanel panelPuntuacionNorte = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		etiquetaPuntosObtenidos = new JLabel("Puntos Obtenidos: ");
		puntos = new JLabel("0");

		Font fuente = new Font("Comic Sans MS", Font.BOLD, 15);

		etiquetaPuntosObtenidos.setFont(fuente);
		etiquetaPuntosObtenidos.setForeground(Color.RED);

		puntos.setFont(fuente);
		puntos.setForeground(Color.RED);

		panelPuntuacionNorte.add(etiquetaPuntosObtenidos);
		panelPuntuacionNorte.add(puntos);


		// ------------ //
		// Panel Centro //
		// ------------ //

		/**
		 * En cuanto al panel con la Apuesta del jugador y el Resultado, es un GridLayout(1,2), es decir una
		 * fila con dos celdas, así me aseguro que sean iguales. A su vez en cada una de esas celdas tendrá
		 * otro panel pero esta vez con gestor de esquemas GridLayout(2,1). Estos dos paneles llevarán
		 * como estáis viendo un borde compuesto con relieve y ell texto “Apuesta Jugador” en el primero, y
		 * “Resultado” en el segundo.
		 * 
		 * pApuesta.setBorder(new CompoundBorder(
		 * new TitledBorder("Apuesta Jugador"),
		 * new BevelBorder(BevelBorder.RAISED)));
		 */
		JPanel panelJuegoCentro = new JPanel(new GridLayout(1,2));

		JPanel apuestaJugador = new JPanel(new GridLayout(2,1));

		apuestaJugador.setBorder(new CompoundBorder(
				new TitledBorder("Apuesta Jugador"),
				new BevelBorder(BevelBorder.RAISED)));

		JPanel resultado = new JPanel(new GridLayout(2,1));

		resultado.setBorder(new CompoundBorder(
				new TitledBorder("Resultado"),
				new BevelBorder(BevelBorder.RAISED)));

		/**
		 * Lo que veis en estos paneles en color blanco, son dos JTextField con borde de título, y en ese
		 * borde es donde especifico “Dado 1” y “Dado 2”. La fuente de estos JTextField es la misma que la
		 * de las etiquetas de la Puntuación obtenida. 
		 */
		dado1Apuesta = new JTextField();
		dado1Apuesta.setBorder(new CompoundBorder(
				new TitledBorder("Dado 1"), null));
		dado1Apuesta.setFont(fuente);

		dado2Apuesta = new JTextField();
		dado2Apuesta.setBorder(new CompoundBorder(
				new TitledBorder("Dado 2"), null));
		dado2Apuesta.setFont(fuente);

		dado1Resultado = new JTextField();
		dado1Resultado.setBorder(new CompoundBorder(
				new TitledBorder("Dado 1"), null));
		dado1Resultado.setFont(fuente);

		dado2Resultado = new JTextField();
		dado2Resultado.setBorder(new CompoundBorder(
				new TitledBorder("Dado 2"), null));
		dado2Resultado.setFont(fuente);

		// Añadir los TextFields a su panel correspondiente
		apuestaJugador.add(dado1Apuesta);
		apuestaJugador.add(dado2Apuesta);

		resultado.add(dado1Resultado);
		resultado.add(dado2Resultado);

		/**
		 * Otra cosa a tener en cuenta con respecto a los JTextField, es que los del primer panel “Apuesta
		 * jugador”, son normales, es decir, editables, pero los del panel del “Resultado” no nos interesa que
		 * sean editables, ya que simplemente los utilizaremos para mostrar el resultado de generar
		 * aleatoriamente los dados, y no queremos que el usuario escriba en ellos, para que no sean
		 * editables tenéis el método setEditable, pero al quitarle la edición os lo podrá en color gris, así que
		 * también tendréis que cambiar el color a blanco. (Algunas estaréis pensando que porque no he
		 * utilizado JLabel en este último panel en lugar de armar este lio, el motivo es porque no se veían
		 * iguales los JLabel que los JTextField y quería conseguir un aspecto más uniforme).
		 */

		// Cambiar el TextField para que no sea editable (se pondrá de color gris)
		dado1Resultado.setEditable(false);
		dado2Resultado.setEditable(false);

		// Cambiar el color de fondo a blanco
		dado1Resultado.setBackground(Color.WHITE);
		dado2Resultado.setBackground(Color.WHITE);

		// Añadir los paneles al Panel Central
		panelJuegoCentro.add(apuestaJugador);
		panelJuegoCentro.add(resultado);


		// --------- //
		// Panel Sur //
		// --------- //

		/**
		 * Por último, el botón tiene una imagen (es un gif animado), a continuación os pongo una de las
		 * formas de poder poner una imagen a un botón, también le he puesto un borde al botón para que
		 * quede más levantado, quedaba regular tras ponerle la imagen.
		 * 
		 * bLanza = new JButton("Lanzar dados",
		 * 							new ImageIcon("recursos/dados-03.gif"));
		 * 
		 * bLanza.setBorder(new BevelBorder(BevelBorder.RAISED));
		 */
		JPanel panelBotonSur = new JPanel();

		bLanza = new JButton("Lanzar dados");

		bLanza = new JButton("Lanzar dados", new ImageIcon("dados-03.gif"));
		bLanza.setBorder(new BevelBorder(BevelBorder.RAISED));

		panelBotonSur.add(bLanza);

		// Añadir todo al Panel Principal
		panelPrincipal.add(panelPuntuacionNorte,BorderLayout.NORTH);
		panelPrincipal.add(panelJuegoCentro,BorderLayout.CENTER);
		panelPrincipal.add(panelBotonSur,BorderLayout.SOUTH);

		cp.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer02 ventana = new Ejer02();

		ventana.pack();

		ventana.setResizable(false);

		ventana.setVisible(true);

		// Tamaño (300, 250)
		ventana.setSize(300, 250);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Por último el funcionamiento del juego es el siguiente:
	 * o Vamos a jugar con el ordenador a acertar el resultado del lanzamiento de dos dados.
	 * o El jugador dará el posible resultado de cada uno de los dados, en los JTextField del panel “Apuesta
	 * Jugador” y el ordenador internamente generará el número que saldrá en cada dado cada vez que
	 * se pulse el botón pulsar, y que se mostrarán en los JTextField del panel Resultado.
	 * o Si el resultado dado por el jugador coincide con el del ordenador el jugador sumará 25 puntos a su
	 * acumulador, si solo coincide uno de los dados sumará 10 puntos, y si no coincide ninguno restará
	 * 5 puntos.
	 * o No tienen que coincidir el orden del resultado, es decir, si la apuesta del usuario es 1 y 3, y el
	 * ordenador genera 3 y 1, es válido y sumaría 25 puntos.
	 */

}
