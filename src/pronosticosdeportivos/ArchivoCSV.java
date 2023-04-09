
package pronosticosdeportivos;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

public class ArchivoCSV {
    
    //Crea un Archivo de Partidos disputados con el nombre que se pasa por parametro 
    //y una ronda de partidos por eso el array 
       public static void CrearPartidosCSV(String nombreDelArchivo, List<Partido>partidos){
        boolean existe = new File(nombreDelArchivo).exists(); // Verifica si existe
        
        //si existe lo borra 
           if(existe) {
            File archivoDePartidos = new File(nombreDelArchivo);
            archivoDePartidos.delete();
        }     
        try {
            // Crea el archivo
            CsvWriter archivoCSV = new CsvWriter(new FileWriter(nombreDelArchivo, true), ',');
            
            // Datos para identificar las columnas
            archivoCSV.write("Equipo_1");
            archivoCSV.write("Goles_Equipo_1");
            archivoCSV.write("Goles_Equipo_2");
            archivoCSV.write("Equipo_2");
            
            archivoCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y la escribimos en el archivo
            for(Partido partido : partidos) {
                String [] datos= partido.formatoDeCSV();
                archivoCSV.writeRecord(datos);
                
                archivoCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            archivoCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
        public static void CrearPronosticosCSV(String nombreDelArchivo, List<Pronostico> pronosticos){
        boolean existe = new File(nombreDelArchivo).exists(); // Verifica si existe
        
        //si existe lo elimino
           if(existe) {
            File archivoDePronosticos = new File(nombreDelArchivo);
            archivoDePronosticos.delete();
        }     
        try {
            // Crea el archivo
            CsvWriter archivoCSV = new CsvWriter(new FileWriter(nombreDelArchivo, true), ',');
            
            // Datos para identificar las columnas
            archivoCSV.write("Equipo_1");
            archivoCSV.write("Gana_Equipo_1");
            archivoCSV.write("Empata");
            archivoCSV.write("Gana_Equipo_2");
            archivoCSV.write("Equipo_2");
            
            archivoCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y la escribimos en el archivo
            for(Pronostico pronostico : pronosticos) {
                String [] datos= pronostico.formatoDeCSV(pronostico.getResultado());
                archivoCSV.writeRecord(datos);
                
                archivoCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            archivoCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }
        public static List<Partido> ImportarResultadosCSV(String nombreDelArchivo) {
        try{
            List<Partido> partidos = new ArrayList<>(); // Lista donde guardaremos los datos del archivo
            
            // creamos una variable de tipo CsvReader para leer el archivo
            CsvReader leerPartidos = new CsvReader(nombreDelArchivo);
            leerPartidos.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerPartidos.readRecord()) {
                String leerEquipoUno = leerPartidos.get(0);
                int golesEquipoUno = Integer.parseInt(leerPartidos.get(1));
                int golesEquipoDos = Integer.parseInt(leerPartidos.get(2));
                String leerEquipoDos = leerPartidos.get(3);
                
                Equipo equipoUno= new Equipo (leerEquipoUno);
                Equipo equipoDos= new Equipo (leerEquipoDos);
                partidos.add(new Partido(equipoUno, golesEquipoUno, golesEquipoDos, equipoDos)); // Añade la informacion a la lista
            }
            
            leerPartidos.close(); // Cierra el archivo
            
            // Recorremos la lista y la mostramos en la pantalla
            for(Partido partido : partidos) {
                System.out.println(partido.getEquipoUno().getNombre()+ " , "
                    + partido.getGolesEquipoUno() + " , "
                    + partido.getGolesEquipoDos() + " , "
                    + partido.getEquipoDos().getNombre());
            }
            return partidos;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
           return null;
           
    }
        public static List<Pronostico> ImportarPronosticoCSV(String nombreDelArchivo) {
        try{
            List<Pronostico> pronosticos = new ArrayList<>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader leerPronosticos = new CsvReader(nombreDelArchivo);
            leerPronosticos.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerPronosticos.readRecord()) {
                String leerEquipoUno = leerPronosticos.get(0);
                String gana_1 = leerPronosticos.get(1);
                String empata = leerPronosticos.get(2);
                String gana_2 = leerPronosticos.get(3);
                String leerEquipoDos = leerPronosticos.get(4);
                
                Equipo equipoUno= new Equipo (leerEquipoUno);
                Equipo equipoDos= new Equipo (leerEquipoDos);
                Partido partido= new Partido (equipoUno,equipoDos);
               
                if(gana_1.equals("X")){
                     pronosticos.add(new Pronostico(partido,ResultadoEnum.GANA_EQUIPO_1)); // Añade la informacion a la lista
                }
                if(empata.equals("X")){
                     pronosticos.add(new Pronostico(partido,ResultadoEnum.EMPATE)); // Añade la informacion a la lista
                }
                if(gana_2.equals("X")){
                     pronosticos.add(new Pronostico(partido,ResultadoEnum.GANA_EQUIPO_2)); // Añade la informacion a la lista
                }
               
            }
            
            leerPronosticos.close(); // Cierra el archivo
            
             // Recorremos la lista y la mostramos en la pantalla
            for(Pronostico pronostico : pronosticos) {
                System.out.println(pronostico.getPartido().getEquipoUno().getNombre()+ " , "
                    + pronostico.getPartido().getEquipoDos().getNombre() + " , "
                    + pronostico.getResultado().toString());
            }           
            
            return pronosticos;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
           return null;
           
    }
}
