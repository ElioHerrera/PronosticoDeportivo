package datos;

// Clase que te permite leer el archivo resultados.csv

import java.io.*;

public class DatosPartidos {

    public void DatosPartidos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ELIO\\OneDrive\\Documentos\\NetBeansProjects\\PronosticoDeportivo\\src\\datos\\resultados.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int totalParts = parts.length;
                for (int i = 0; i < totalParts; i++) {
                    System.out.println(parts[i] + " ");
                }
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
