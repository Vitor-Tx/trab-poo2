package model.factory.impl;

import model.decorator.impl.Fogo;
import model.decorator.impl.Gelo;
import model.decorator.impl.Veneno;
import model.observer.Personagem;
import model.observer.impl.Jogador01;
import model.strategy.impl.AtaqueForte;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.AtaqueMedio;

import java.util.Random;

public class SimplePersonagemFactory {

    public static Personagem createPersonagem () {
        Random random = new Random();
        float r = random.nextFloat();

        Personagem p = new Personagem() {
            @Override
            public void receberDano(Integer dano) {

            }
        };

        if (r <= 0.2){
            p.setAtaque(new Fogo(new AtaqueForte()));
        } else if (0.2 < r && r <= 0.4) {
            p.setAtaque(new Gelo(new AtaqueMedio()));
        } else if (0.4 < r && r <= 0.6) {
            p.setAtaque(new Veneno(new AtaqueFraco()));
        } else if (0.6 < r && r <= 0.8) {
            p.setAtaque(new Gelo(new AtaqueForte()));
        } else if (0.8 < r && r <= 1.0) {
            p.setAtaque(new Veneno(new AtaqueMedio()));
        } else
            p = new Jogador01();

        return p;
    }
}
