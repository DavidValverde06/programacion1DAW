package claseOptional;

import java.util.Optional;

class Usuario {
    private String nombre;
    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    /*
     * Getter's y setter's
     */
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}


public class TestUsuario {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("Juan", null);

		String email = usuario.getEmail().orElse("Correo no disponible");
		
		System.out.println("Email: " + email);

	}

}
