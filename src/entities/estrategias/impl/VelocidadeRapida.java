package entities.estrategias.impl;

import entities.estrategias.Velocidade;

public class VelocidadeRapida implements Velocidade {

    @Override
    public int vel() {
        return 10;
    }
}
