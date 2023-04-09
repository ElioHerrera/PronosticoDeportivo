package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */
public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    public Partido(Equipo equipoLocal, int golesEquipoLocal, int golesEquipoVisitante, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = 0;
        this.golesEquipoVisitante = 0;
    }

    // RETORNA RESULTADO
    public ResultadoEnum decirResulado() {

        if (golesEquipoLocal > golesEquipoVisitante) {
            return ResultadoEnum.GANA_EQUIPO_1;
        } else if (golesEquipoVisitante > golesEquipoLocal) {
            return ResultadoEnum.GANA_EQUIPO_2;
        } else {
            return ResultadoEnum.EMPATE;
        }
    }

    public Equipo getEquipoUno() {
        return equipoLocal;
    }

    public void setEquipoUno(Equipo equipo) {
        this.equipoLocal = equipo;
    }

    public Equipo getEquipoDos() {
        return equipoVisitante;
    }

    public void setEquipoDos(Equipo equipo) {
        equipoVisitante = equipo;
    }

    public int getGolesEquipoUno() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoUno(int golesEquipoUno) {
        this.golesEquipoLocal = golesEquipoUno;
    }

    public int getGolesEquipoDos() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoDos(int golesEquipoDos) {
        this.golesEquipoVisitante = golesEquipoDos;
    }

    //Metodo Para que me devuta el array de string que necesito para 
    //guardar en el formato CSV
    public String[] formatoDeCSV() {
        String[] datos = {equipoLocal.getNombre(), String.valueOf(golesEquipoLocal),
            String.valueOf(golesEquipoVisitante), equipoVisitante.getNombre()};

        return datos;
    }
}
