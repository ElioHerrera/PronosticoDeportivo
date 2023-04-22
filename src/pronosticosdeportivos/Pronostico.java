package pronosticosdeportivos;

public class Pronostico {

    //Atributos
    private Partido partido;
    private ResultadoEnum resultado;

    //Constructor
    public Pronostico(Partido partido, ResultadoEnum resultado) {
        this.partido = partido;
        this.resultado = resultado;
    }

    public int puntajePronostico() {
        ResultadoEnum resultadoPartido = this.partido.resultadoPartido();

        if (resultadoPartido == this.resultado) {
            return 1;
        } else {
            return 0;
        }
    }

}
