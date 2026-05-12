package vista;
/**
 *  Clase que muestra un dialogo con el JTable de una consulta
 *  
 *  Recibe los datos en una matriz de tipo String
 *  
 */


import javax.swing.*;

import java.awt.*;

public class Consulta1 extends JDialog 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param datos
	 */
	public Consulta1(String [][] datos)
	{ 
		// Poner el dialogo modal, darle titulo y gestor de esquemas
		this.setModal(true);
		this.setTitle("Consulta de discos vendidos en este año");
		this.setLayout(new FlowLayout());
	
		String [] nombreColumnas = {"Código","Título","Autor","Año","Precio"};

	
		JTable tablaResultados = new JTable(datos,nombreColumnas);
		JScrollPane sp = new JScrollPane(tablaResultados);

		this.add(sp);
	    
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	this.pack();  
		this.setVisible(true);   // Para mostrar el dialogo
		this.setResizable(false);

	}
}
