package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

public class Partido {

    private final Equipo EQUIPO_LOCAL;
    private Equipo EQUIPO_VISITANTE;
    private int golesEquipoLocal = 0, golesEquipoVisitante = 0;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesEquipoLocal, int golesEquipoVisitante) {
        this.EQUIPO_LOCAL = equipoLocal;
        this.EQUIPO_VISITANTE = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public void Partido() {

        if (golesEquipoLocal == golesEquipoVisitante) {
            //empate
        } else if (golesEquipoLocal > golesEquipoVisitante) {
            //EQUIPO_LOCAL GANA
        } else {
            //EQUIPO_VISITANTE GANA
        }
    }
}
