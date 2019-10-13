package entities.observer.impl;

import entities.estrategias.impl.*;
import entities.observer.Jogador;

public class Jogador02 extends Jogador {

    public Jogador02() {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }

    public Jogador02(int l, int a) {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }
}
