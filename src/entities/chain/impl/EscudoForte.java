package entities.chain.impl;
import entities.chain.Escudo;

public class EscudoForte extends Escudo {
    public EscudoForte(){
        this.defesa = 15;
        this.carga = 15;
    }
    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoForte) this.carga += 15;
    }
}
