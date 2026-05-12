package prPractica17;

import javax.swing.JOptionPane;

/**
 * 5.- Por último os propongo un GUI, un poco más interactivo, utilizando los JOptionPane. Inicialmente
 * lanzaremos una ventanita, pidiendo un número: 
 */
public class Ejer05 {

	public static void main(String[] args) {


		String numIntroducido = JOptionPane.showInputDialog("Escriba un número");

		try {
			double num = Double.parseDouble(numIntroducido);

			if (num==100) {
				JOptionPane.showMessageDialog(null, "Enhorabuena, has obtenido un premio");
			}
			else {
				JOptionPane.showMessageDialog(null, "El número introducido es " + num);
			}
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Operación cancelada");
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Dato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
