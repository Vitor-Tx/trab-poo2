package model.decorator.impl;

import model.decorator.Decorator;
import model.strategy.Ataque;

public class Veneno extends Decorator {
    public Veneno(Ataque atkDecorado) {
        super(atkDecorado);
        this.extra = 4;
    }
}
