package biblioteca;

/**
 * Desarrolla una clase Usuario que implemente la interfaz anterior, y que represente a un usuario con su
 * nombre y los libros sacados por dicho usuario en un momento determinado. Los libros que tiene sacados
 * un usuario se almacenarán en una colección que no permita elementos repetidos (por ejemplo, un
 * HashSet). Defínanse los siguientes constructores y métodos:
 * 
 * a) Un constructor que tome el nombre del usuario como argumento, cuando se crea un usuario, este
 * todavía no tiene libros sacados.
 * 
 * b) Métodos apropiados para devolver y modificar el nombre y los libros sacados por un usuario.
 * 
 * c) Redefinición de los métodos de la interfaz:
 * • boolean sacaLibro(Libro lib). Método que añada el libro lib al conjunto de libros sacados
 * por el usuario que reciba el mensaje.
 * • int cantidadLibrosSacados().
 * • boolean puedeSacarMasLibros(). El usuario no podrá sacar más de 10 libros.
 * • Libro devuelveLibro(String tit). Método que extraiga el libro con título tit del conjunto de
 * libros sacados por el usuario que recibe el mensaje. Dicho libro será devuelto como resultado del
 * método; si el libro no ha sido sacado por dicho usuario debe devolverse null.
 * 
 * d) Redefine los métodos equals y hashCode de la clase Object. Dos usuarios son iguales si tienen el
 * mismo nombre (sin distinguir mayúsculas y minúsculas).
 * e) Redefinición de toString, con una salida similar a los siguientes ejemplos (sólo se mostrará el título del
 * libro):
 * 		José Mª García (El Señor de los Anillos; Don Quijote de la Mancha;)
 * 		María López (No tiene libros sacados)
 */
public class Usuario {

}
