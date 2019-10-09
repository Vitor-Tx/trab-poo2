package entities.chain.impl;

import entities.chain.Escudo;

public class EscudoMedio extends Escudo {
    public EscudoMedio(){
        this.defesa = 10;
        this.carga = 10;
    }

    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoMedio) this.carga += 10;
    }
}
