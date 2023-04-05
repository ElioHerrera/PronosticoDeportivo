package pronosticosdeportivos;

/**
 *
 * @author 
 */
public class Partido {
    
    String nombre = ""; 
    Equipo equipoLocal;
    Equipo EquipoVisitante;
    
    private int golesEquipoLocal = 0, golesEquipoVisitante = 0;

    public Partido(Equipo equipo, int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante; 
    }
        
   }
