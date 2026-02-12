package biblioteca;

/**
 * Una clase Bioblioteca que implemente la interfaz anterior, la cual mantendrá un conjunto de los usuarios
de la biblioteca y un conjunto ordenado por código de los libros disponibles. Esta clase deberá algunos
métodos propios, más los métodos de la interfaz, los cuales se detallan a continuación:
a) Un constructor, métodos getter y setter.
b) Método para añadir un usuario a la biblioteca.
c) Método para añadir un libro a la biblioteca
b) Un método Libro sacarLibro(String título) que dado un título lo busque en la colección de libros
de la biblioteca y devuelva una referencia al Libro cuyo título coincida con el indicado como parámetro,
o bien un null en caso de no encontrar ese libro. Este método además de devolver el libro, lo extrae de
la colección de libros de la biblioteca.
c) Un método Usuario buscarUsuario(String nombre) que busque un usuario en la colección de
usuarios de la biblioteca, y devuelva una referencia al objeto usuario cuyo nombre coincide con la
cadena de caracteres dada como argumento. Devolverá null en caso de no existir un usuario con dicho
nombre.
d) Un método boolean prestarLibro(String titulo, String nombre) que tenga el efecto esperado
de un préstamo de libro (es decir, el libro con ese título deja de estar en la colección de libros de la
biblioteca y pasa a estar en la colección de libros sacados por el usuario con el nombre indicado). Podéis
devolver un valor false, cuando algo vaya mal, por ejemplo, el usuario o el libro no existen, y true
cuando todo vaya correctamente.
e) Un método boolean devuelveLibro(String titulo, String nombre) que tenga el efecto esperado
de una devolución de un Libro sacado previamente por el usuario indicado, es decir, el libro ya no estará
en la colección de libros sacados por el usuario, y volverá a la colección de libros de la biblioteca.
f) Método String librosDisponibles() devuelve una cadena con todas los libros disponibles en la
biblioteca
g) Método String librosPrestadosUsuario(String nombre) devuelve una cadena con todos las libros
sacados por un determinado usuario.
h) Un método SortedSet<Libro> copias(String titulo) que devuelve un conjunto con todos las
libros que hay con el título que se pasa como argumento.
i) Un método Set<Libro> getLibrosUsuario(String nomCli) que devuelve una colección con los
libros sacados por un determinado usuario.
 */
public class Biblioteca {

}
