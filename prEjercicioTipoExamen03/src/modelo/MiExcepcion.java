package modelo;

public class MiExcepcion extends Exception {
	
	private static final long serialVersionUID = -2625930008384418054L;

	public MiExcepcion() {super();}
	
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}