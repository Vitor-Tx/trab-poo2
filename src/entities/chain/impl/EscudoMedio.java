package entities.chain.impl;

import entities.chain.Escudo;

public class EscudoMedio extends Escudo {
    public EscudoMedio(int carga){
        super(carga);
        this.defesa = 10;
    }

    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoMedio) this.carga += escudo.getCarga();
    }
}
