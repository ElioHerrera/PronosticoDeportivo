package pronosticosdeportivos;

public class Partido {

    //Atributos del objeto
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    //Constructor
    public Partido(Equipo equipoLocal, int golesEquipoLocal, int golesEquipoVisitante, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    //Métodos get para cada atributo de Partido
    public Equipo getEquipoUno() {
        return equipoLocal;
    }

    public Equipo getEquipoDos() {
        return equipoVisitante;
    }

    public int getGolesEquipoUno() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoDos() {
        return golesEquipoVisitante;
    }
       
    // Método para retornar resultado
    public ResultadoEnum resultadoPartido() {

        if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            return ResultadoEnum.GANA_EQUIPO_UNO;
        } else if (this.golesEquipoVisitante > this.golesEquipoLocal) {
            return ResultadoEnum.GANA_EQUIPO_DOS;
        } else {
            return ResultadoEnum.EMPATE;
        }
    }

   
}
