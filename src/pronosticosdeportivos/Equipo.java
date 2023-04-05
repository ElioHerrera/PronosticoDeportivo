package pronosticosdeportivos;

/**
 *
 * @author 
 */
public class Equipo {
    
    String nombre;
       
    public Equipo(String nombre){
        this.nombre = nombre;
    }

       public String getNombre() {
        return nombre;
    }

    public void imprimirNombreDelEquipo() {
        System.out.println(this.getNombre());
    }
}