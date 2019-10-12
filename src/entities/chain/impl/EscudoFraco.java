package entities.chain.impl;
import entities.chain.Escudo;

public class EscudoFraco extends Escudo {
    public EscudoFraco(int carga){
        super(carga);
        this.defesa = 5;
    }

    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoFraco) this.carga += escudo.getCarga();
        else if(getSucessor() != null) getSucessor().adcCarga(escudo);
    }
}
