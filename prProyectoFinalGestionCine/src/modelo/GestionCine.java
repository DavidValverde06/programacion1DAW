package modelo;

import java.util.*;

public interface GestionCine {

	// -------------------
	// Métodos de Pelicula
	// -------------------

	/**
	 * Método añadirPelicula(Pelicula p)
	 */
	public void añadirPelicula(Pelicula p);

	/**
	 * Método eliminarPelicula(Pelicula p)
	 */
	public boolean eliminarPelicula(Pelicula p);

	/**
	 * Método modificarPelicula(Pelicula p)
	 */
	public boolean modificarPelicula(Pelicula p);

	/**
	 * Método buscarPelicula(Pelicula p)
	 */
	public Pelicula buscarPelicula(Pelicula p);

	// -----------------
	// Métodos de Sala
	// -----------------

	/**
	 * Método añadirSala(Sala s)
	 */
	public void añadirSala(Sala s);


	// -----------------
	// Métodos de Sesion
	// -----------------

	/**
	 * Método añadirSesion(Sesion s)
	 */
	public void añadirSesion(Sesion s);

	/**
	 * Método sesionesDeUnaPelicula(Pelicula p)
	 */
	public ArrayList<Sesion> sesionesDeUnaPelicula(Pelicula p);

	/**
	 * Método sesionesEnUnaSala(Sala s)
	 */
	public ArrayList<Sesion> sesionesEnUnaSala(Sala s);

}