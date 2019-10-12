package entities.decorators.impl;

import entities.decorators.Decorator;
import entities.estrategias.Ataque;

public class Fogo extends Decorator {
    public Fogo(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 5;
    }
}
