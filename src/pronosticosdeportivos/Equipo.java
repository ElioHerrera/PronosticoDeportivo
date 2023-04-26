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
   
 }