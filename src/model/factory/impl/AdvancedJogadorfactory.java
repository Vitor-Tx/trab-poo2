package model.factory.impl;

import model.decorator.impl.Fogo;
import model.decorator.impl.Gelo;
import model.decorator.impl.Veneno;
import model.factory.FactoryJogador;
import model.Personagem.Jogador;
import model.strategy.impl.AtaqueForte;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.AtaqueMedio;

public class AdvancedJogadorfactory extends FactoryJogador {

    private static AdvancedJogadorfactory instancia = null;

    private AdvancedJogadorfactory() { super();}

    public static synchronized AdvancedJogadorfactory getInstance(){
        if (instancia == null)
            instancia = new AdvancedJogadorfactory();
        return instancia;
    }

    @Override
    public Jogador criaJogador() {

        double r = Math.random() * 1;
        SimpleJogadorfactory sjf =  SimpleJogadorfactory.getInstance();

        Jogador j = sjf.criaJogador();

        if (r <= 0.2) {
            j.setAtaque(new Veneno(new AtaqueForte()));
        } else if (r > 0.2 && r <= 0.4) {
            j.setAtaque(new Gelo(new AtaqueMedio()));
        } else if (r > 0.4 && r <= 0.6) {
            j.setAtaque(new Fogo(new AtaqueFraco()));
        } else if (r > 0.6 && r <= 0.8) {
            j.setAtaque(new Fogo(new AtaqueForte()));
        } else  if (r > 0.8 && r <= 1.0) {
            j.setAtaque(new Gelo(new AtaqueForte()));
        }

        return j;
    }
}
