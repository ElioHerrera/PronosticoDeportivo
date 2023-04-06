package datos;

// Clase que te permite leer el archivo resultados.csv
import java.io.*;

public class DatosPartidos {

    public void DatosPartidos() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\ELIO\\OneDrive\\Documentos\\NetBeansProjects\\PronosticoDeportivo\\src\\datos\\resultados.csv"));
            String linea = null;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                int columnas = datos.length;
                for (int indice = 0; indice < columnas; indice++) {
                    System.out.print(datos[indice] + " ");
                }
                System.out.println("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
