package pronosticosdeportivos;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

public class Pronostico {
   private Partido partido;
    private ResultadoEnum resultado;
    
    public Pronostico(Partido partido, ResultadoEnum resultado){
        this.partido=partido;
        this.resultado=resultado;
    }

    public Partido getPartido() {
        return partido;
    }
    
      public void SetPartido(Partido partido) {
        this.partido=partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }
    
    public void setResultado(ResultadoEnum resultado) {
        this.resultado= resultado;
    }
    
    //Metodo Para que me devuta el array de string que necesito para 
    //guardar en el formato CSV
    public String [] formatoDeCSV(ResultadoEnum resultado){
        String []datos=new String[5];
  
        if(resultado.equals(ResultadoEnum.GANA_EQUIPO_1)){
            datos[0]=partido.getEquipoUno().getNombre();
            datos[1]="X";
            datos[2]=" ";
            datos[3]=" ";
            datos[4]=partido.getEquipoDos().getNombre();   
        }
        if(resultado.equals(ResultadoEnum.GANA_EQUIPO_2)){
            datos[0]=partido.getEquipoUno().getNombre();
            datos[1]=" ";
            datos[2]=" ";
            datos[3]="X";
            datos[4]=partido.getEquipoDos().getNombre();   
        }
         if(resultado.equals(ResultadoEnum.EMPATE)){
            datos[0]=partido.getEquipoUno().getNombre();
            datos[1]=" ";
            datos[2]="X";
            datos[3]=" ";
            datos[4]=partido.getEquipoDos().getNombre();   
        }
        
        
        return datos;
    }
                
    
        
}
