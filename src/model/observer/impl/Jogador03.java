package model.observer.impl;

import model.strategy.impl.*;
import model.observer.Jogador;

public class Jogador03 extends Jogador {

    public Jogador03() {
        super(new PuloBaixo(), new VelocidadeRapida(), new AtaqueForte());
    }

    public Jogador03(int l, int a) {
        super(new PuloBaixo(), new VelocidadeRapida(), new AtaqueForte());
    }
}
