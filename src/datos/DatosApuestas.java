package datos;

// Clase que te permite leer el archivo pronostico.csv

import java.io.*;

public class DatosApuestas {

    public void DatosApuestas() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ELIO\\OneDrive\\Documentos\\NetBeansProjects\\PronosticoDeportivo\\src\\datos\\pronostico.csv"));
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
