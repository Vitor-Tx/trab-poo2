package model.factory.impl;

import model.factory.FactoryJogador;
import model.observer.Personagem;
import model.observer.impl.Jogador01;

public class SimpleJogadorfactory extends FactoryJogador {


    @Override
    public Personagem criaJogador() {
        Double r = Math.random() * 2;

        Personagem p;

        if (r <= 0.2) {
            p = new Jogador01();
        } else if (r <= 0.4) {
            p = new Jogador02();
        } else if (r <= 0.6) {
            p = new Jogador03();
        } else if (r <= 0.8) {
            p = new Jogador01();
        } else  if (r <= 1.0) {
            p = new Jogador02();
        }
        
        return null;
    }
}
