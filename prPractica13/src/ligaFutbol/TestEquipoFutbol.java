package ligaFutbol;

public class TestEquipoFutbol {

    public static void main(String[] args) {

        System.out.println("=== CREACIÓN DE EQUIPOS ===");
        Equipo equipo1 = new Equipo("Real Madrid");
        Equipo equipo2 = new Equipo("Barcelona");
        Equipo equipo3 = new Equipo("Malaga CF");

        System.out.println("\n--- Mostrar equipos recién creados ---");
        System.out.println(equipo1);
        System.out.println(equipo2);
        System.out.println(equipo3);

        System.out.println("\n--- Mostrar con toStringLineal ---");
        System.out.println(equipo1.toStringLineal());
        System.out.println(equipo2.toStringLineal());
        System.out.println(equipo3.toStringLineal());

        System.out.println("\n=== PROBAR MÉTODOS DE INCREMENTO ===");
        System.out.println("Incrementando partidos y goles del Real Madrid...");
        equipo1.incrementaNumPartidosGanados();
        equipo1.incrementaNumPartidosEmpatados();
        equipo1.incrementaNumPartidosPerdidos();
        equipo1.incrementaNumGolesMarcados(4);
        equipo1.incrementaNumGolesRecibidos(2);

        System.out.println(equipo1);

        System.out.println("\n=== PROBAR PUNTOS ACUMULADOS ===");
        System.out.println("Puntos acumulados Real Madrid: " + equipo1.puntosAcumuladosEquipo());

        System.out.println("\n=== PROBAR EQUALS Y HASHCODE ===");
        Equipo equipoDuplicado = new Equipo("real madrid"); // diferente mayúsculas/minúsculas
        System.out.println("¿Equipo1 y equipoDuplicado son iguales? " + equipo1.equals(equipoDuplicado));
        System.out.println("HashCode equipo1: " + equipo1.hashCode());
        System.out.println("HashCode equipoDuplicado: " + equipoDuplicado.hashCode());

        System.out.println("\n=== PROBAR INCREMENTO VARIOS PARTIDOS ===");
        equipo2.incrementaNumPartidosGanados();
        equipo2.incrementaNumGolesMarcados(2);
        equipo2.incrementaNumGolesRecibidos(0);

        equipo3.incrementaNumPartidosEmpatados();
        equipo3.incrementaNumGolesMarcados(1);
        equipo3.incrementaNumGolesRecibidos(1);

        System.out.println(equipo2);
        System.out.println(equipo3);

        System.out.println("\n=== RESUMEN LINEAL DE TODOS LOS EQUIPOS ===");
        System.out.println(equipo1.toStringLineal());
        System.out.println(equipo2.toStringLineal());
        System.out.println(equipo3.toStringLineal());
    }
}