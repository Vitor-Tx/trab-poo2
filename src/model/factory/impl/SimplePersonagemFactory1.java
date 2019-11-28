package model.factory.impl;

import model.decorator.impl.Fogo;
import model.decorator.impl.Gelo;
import model.decorator.impl.Veneno;
import model.observer.Personagem;
import model.observer.impl.Jogador01;
import model.observer.impl.Jogador02;
import model.observer.impl.Jogador03;
import model.strategy.impl.AtaqueForte;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.AtaqueMedio;

import java.util.Random;

public class SimplePersonagemFactory1 {

    public static Personagem createPesonagem(){
        Random random = new Random();
        float r = random.nextFloat();

        Personagem p = null;

        if (r <= 0.2){
            p = new Jogador01();
        } else if (0.2 < r && r <= 0.4) {
            p = new Jogador02();
        } else if (0.4 < r && r <= 0.6) {
            p = new Jogador03();
        } else if (0.6 < r && r <= 0.8) {
            p = new Jogador03();
        } else if (0.8 < r && r <= 1.0) {
            p = new Jogador01();
        } else
            p = new Jogador01();

        return p;
    }
}
