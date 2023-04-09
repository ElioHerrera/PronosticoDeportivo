package pronosticosdeportivos;

import java.util.ArrayList;
import java.util.List;

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 */

public class Ronda {
   private String ronda;
    private final List<Partido> partidos;
    
    public Ronda(String ronda){
        this.ronda=ronda;
        this.partidos=new ArrayList<>();
    }
    
    public void AgregarRonda(List<Partido> partidos){
        for(Partido partido : partidos){
           this.partidos.add(partido);
        }
        
    }
    
    public String getRonda() {
        return ronda;
    }
    
       public void setRonda(String ronda) {
        this.ronda=ronda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
    
    public void agregarPartidos(List<Partido>partidos){
        for(Partido partido: partidos){
             this.partidos.add(partido);
        }
       
    }
    
}
