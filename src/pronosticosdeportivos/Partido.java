package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */
public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal = 0, golesEquipoVisitante = 0;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesEquipoLocal, int golesEquipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

 
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }
    
    public void ResultadoPartido(){
       if (golesEquipoLocal == golesEquipoVisitante) {
            System.out.println("Partido empatado");

        } else if (golesEquipoLocal > golesEquipoVisitante) {

           System.out.println("Gana equipo Local");
        } else {

           System.out.println("Gana visitante");
        }
    
    }
}
