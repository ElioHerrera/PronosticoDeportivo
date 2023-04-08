package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

public class Equipo {
    
    private String nombre;
       
    public Equipo(String nombre){
        this.nombre = nombre;
    }

    Equipo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void imprimirNombreDelEquipo() {
        System.out.println(this.getNombre());
    }
}