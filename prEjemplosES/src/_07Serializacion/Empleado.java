package _07Serializacion;

import java.io.*;


public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1227025033699164264L;

	private String nombre;
	private long sueldo;
	
	public Empleado(String n, long s) {
		this.nombre = n;
		this.sueldo= s;
	}
	
	@Override
	public String toString() {
		return nombre+ ", "+sueldo;
	}

}
