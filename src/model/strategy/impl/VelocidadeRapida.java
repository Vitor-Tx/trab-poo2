package model.strategy.impl;

import model.strategy.Velocidade;

public class VelocidadeRapida implements Velocidade {

    @Override
    public int vel() {
        return 10;
    }
}
