package model.factory.impl;

import model.decorator.impl.Fogo;
import model.decorator.impl.Gelo;
import model.decorator.impl.Veneno;
import model.factory.FactoryJogador;
import model.observer.Jogador;
import model.observer.impl.*;
import model.strategy.impl.AtaqueForte;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.AtaqueMedio;

public class AdvancedJogadorfactory extends FactoryJogador {
    @Override
    public Jogador criaJogador() {

        double r = Math.random() * 2;

        Jogador j = null;

        if (r <= 0.2) {
            j = new Jogador01();
            j.setAtaque(new Veneno(new AtaqueForte()));
        } else if (r <= 0.4) {
            j = new Jogador02();
            j.setAtaque(new Gelo(new AtaqueMedio()));
        } else if (r <= 0.6) {
            j = new Jogador03();
            j.setAtaque(new Fogo(new AtaqueFraco()));
        } else if (r <= 0.8) {
            j = new Jogador04();
            j.setAtaque(new Fogo(new AtaqueForte()));
        } else  if (r <= 1.0) {
            j = new Jogador05();
            j.setAtaque(new Gelo(new AtaqueForte()));
        }

        return j;
    }
}
