package pronosticosdeportivos;


public class Equipo {
    
    //Atributo del objeto
    private final String NOMBRE;
       
    //Constructor
    public Equipo(String nombre){
        this.NOMBRE = nombre;
    }

    //Metodo get
    public String getNombre() {
        return NOMBRE;
    }
   
    //Metodo para imprimir en pantalla el nombre del equipo
    public void imprimirNombreDelEquipo() {
        System.out.println(this.getNombre());
    }
}