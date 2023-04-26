package pronosticosdeportivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*  ********         @authors Leiria Gonzalo, Herrera Elio         ********  */
public class TrabajoIntegrador {

    public static void main(String[] args) throws IOException {

        //definimos ruta relativa de los csv
        String ubicacionArchivoPartidos = "src\\datos\\resultados.csv";
        String ubicacionArchivoPronostico = "src\\datos\\pronostico.csv";

        //inicializamos las listas
        List<Pronostico> listaPronostico = new ArrayList<>();
        List<Partido> listaPartidos = new ArrayList<>();

        Path pathPartidos = Paths.get(ubicacionArchivoPartidos);
   
        //recorro csv
        for (String partidoLinea : Files.readAllLines(pathPartidos)) {
            int i = 0;
            i++;
            
            //separo la cadena en columnas
            String[] columna = partidoLinea.split(",");
            
            //creamos los equipos de cada partido
            Equipo equipoLocal = new Equipo(columna[0]);
            Equipo equipoVisitante = new Equipo(columna[2]);
            
            //creamos cada partido
            Partido partido = new Partido(equipoLocal, Integer.valueOf(columna[1]), Integer.valueOf(columna[3]), equipoVisitante);
            
            //agregamos cada partido a la lista
            listaPartidos.add(partido);

            // Imprimir en pantalla cada partido
            System.out.println(columna[0] + "  " + columna[1] + "  vs   " + columna[3] + "  " + columna[2]);

        }
        System.out.println("-----------------------------------------");

        Path pathPronostico = Paths.get(ubicacionArchivoPronostico);
       
        //leo cada linea
        for (String pronosticoLinea : Files.readAllLines(pathPronostico)) {
            
            //guardamos en un Array las columnas  de cada linea
            String[] columna = pronosticoLinea.split(",");
            int i = 0;
            i++;
            
            //metodo BuscarPartidoPorNombreEquipos(argumentos)
            Partido partidoEncontrado = BuscarPartidoPorNombreEquipos(listaPartidos, columna[0], columna[4]);
            ResultadoEnum resultadoPronostico = DeterminarResultadoElegido(columna);
            
            //creamos objeto de tipo y armamos la lista
            Pronostico pronostico = new Pronostico(partidoEncontrado, resultadoPronostico);
            listaPronostico.add(pronostico);

        }

        System.out.println("-----------------------------------------");
        int puntajeFinalPersona = 0;
        
        //recorremos los pronosticos y cargamos los puntos del metodo puntajePronostico() 
        for (Pronostico pronostico : listaPronostico) {
            puntajeFinalPersona = puntajeFinalPersona + pronostico.puntajePronostico();
        }
        System.out.println("Puntaje: " + puntajeFinalPersona);
    }

    public static Partido BuscarPartidoPorNombreEquipos(List<Partido> listaPartidos, String nombreEquipoLocal, String nombreEquipoVisitante) {
       
        Partido partidoEncontrado = listaPartidos.stream()
                .filter(Partido -> Partido.getEquipoUno().getNombre().equals(nombreEquipoLocal) && Partido.getEquipoDos().getNombre().equals(nombreEquipoVisitante))
                .findAny()
                .orElse(null);
        return partidoEncontrado;
    }

    private static ResultadoEnum DeterminarResultadoElegido(String[] columna) {
        String ganaEquipoLocal = columna[1];
        String empate = columna[2];
        String ganaEquipoVisitante = columna[3];

        //si la columan 1 es igual a "x" GANA_EQUIPO_UNO
        if (ganaEquipoLocal.equals("x")) {
            System.out.println("Resultado elejido --> GANA " + columna[0]);
            return ResultadoEnum.GANA_EQUIPO_UNO;
        }
        if (ganaEquipoVisitante.equals("x")) {
            System.out.println("Resultado elejido --> GANA " + columna[4]);
            return ResultadoEnum.GANA_EQUIPO_DOS;
        }
        if (empate.equals("x")) {
            System.out.println("Resultado elejido --> EMPATAN");
            return ResultadoEnum.EMPATE;
        }

        return ResultadoEnum.EMPATE;

    }
}
