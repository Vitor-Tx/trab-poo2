package entities.chain.impl;
import entities.chain.Escudo;

public class EscudoFraco extends Escudo {
    public EscudoFraco(){
        this.defesa = 5;
        this.carga = 5;
    }

    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoFraco) this.carga += 5;
    }
}
