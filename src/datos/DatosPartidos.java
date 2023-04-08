package datos;

// Clase que te permite leer el archivo resultados.csv
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pronosticosdeportivos.Partido;


public class DatosPartidos {
    
      public void DatosPartidos() {
            
          List<Partido> listaDePartidos = new ArrayList<>();
          
          
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\ELIO\\OneDrive\\Documentos\\NetBeansProjects\\PronosticoDeportivo\\src\\datos\\resultados.csv"));
            String linea = null;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                int columnas = datos.length;
                for (int indice = 0; indice < columnas; indice++) {
                    //System.out.println(datos[indice] + " ");
                   listaDePartidos.add(datos[indice]);
                }
            }
           
            System.out.println(listaDePartidos);
            
            
        } catch (IOException e) {
            e.printStackTrace();
            
          
        }
    }
}

