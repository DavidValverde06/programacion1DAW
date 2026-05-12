package modelo;

import java.util.*;

public class Cine implements GestionCine {

	/**
	 * Variables de instancia
	 */
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Sala> salas;
	private ArrayList<Sesion> sesiones;

	/**
	 * Constructor sobrecargado
	 */
	public Cine() {
		this.peliculas = new ArrayList<>();
		this.salas = new ArrayList<>();
		this.sesiones = new ArrayList<>();
	}

	public Cine(ArrayList<Pelicula> peliculas, ArrayList<Sala> salas, ArrayList<Sesion> sesiones) {
		this.peliculas = peliculas;
		this.salas = salas;
		this.sesiones = sesiones;
	}

	/**
	 * Getter's
	 */
	public ArrayList<Pelicula> getPeliculas() {return peliculas;}
	public ArrayList<Sala> getSalas() {return salas;}
	public ArrayList<Sesion> getSesiones() {return sesiones;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Cine [peliculas=" + peliculas + ", salas=" + salas + ", sesiones=" + sesiones + "]";
	}

	/**
	 * Métodos de la interfaz GestionCine
	 */
	@Override
	public void añadirPelicula(Pelicula p) {
		// TODO Auto-generated method stub
	}
	@Override
	public boolean eliminarPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modificarPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Pelicula buscarPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void añadirSala(Sala s) {
		// TODO Auto-generated method stub

	}
	@Override
	public void añadirSesion(Sesion s) {
		// TODO Auto-generated method stub

	}
	@Override
	public ArrayList<Sesion> sesionesDeUnaPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Sesion> sesionesEnUnaSala(Sala s) {
		// TODO Auto-generated method stub
		return null;
	}
}
