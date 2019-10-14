package model.strategy.impl;

import model.strategy.Velocidade;

public class VelocidadeDevagar implements Velocidade {

    @Override
    public int vel() {
        return 2;
    }
}
