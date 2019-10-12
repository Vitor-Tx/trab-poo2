package entities.decorators.impl;

import entities.decorators.Decorator;
import entities.estrategias.Ataque;

public class Gelo extends Decorator {
    public Gelo(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 3;
    }
}
