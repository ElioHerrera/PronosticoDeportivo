
package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

import datos.DatosPartidos;
import datos.DatosApuestas;


public class Main {
    public static void main(String[] args) {
        
        DatosPartidos resultados = new DatosPartidos();
        DatosApuestas pronosticos = new DatosApuestas();
        
        resultados.DatosPartidos();
        System.out.println("***************************************");
        pronosticos.DatosApuestas();
        
    }
    
}
