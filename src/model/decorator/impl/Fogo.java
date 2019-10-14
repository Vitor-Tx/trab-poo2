package model.decorator.impl;

import model.decorator.Decorator;
import model.strategy.Ataque;

public class Fogo extends Decorator {
    public Fogo(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 5;
    }
}
