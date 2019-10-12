package entities.decorators.impl;

import entities.decorators.Decorator;
import entities.estrategias.Ataque;

public class Veneno extends Decorator {
    public Veneno(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 4;
    }
}
