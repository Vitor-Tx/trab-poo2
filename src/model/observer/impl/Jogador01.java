package model.observer.impl;

import model.strategy.impl.AtaqueForte;
import model.strategy.impl.PuloMedio;
import model.strategy.impl.VelocidadeMedia;
import model.observer.Jogador;

public class Jogador01 extends Jogador {

    public Jogador01() {
        super(new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }

    public Jogador01(int l, int a) {
        super(l, a, new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }
}
