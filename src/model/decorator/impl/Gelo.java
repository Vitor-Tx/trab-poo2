package model.decorator.impl;

import model.decorator.Decorator;
import model.strategy.Ataque;

public class Gelo extends Decorator {
    public Gelo(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 3;
    }
}
