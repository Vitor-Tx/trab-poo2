package model.observer.impl;

import model.decorator.impl.Gelo;
import model.observer.Inimigo;

public class InimigoGelo extends Inimigo {
    public InimigoGelo(int x, int y, int l, int a){
        super(x, y, l, a);
        setAtaque(new Gelo(new Gelo(getAtaque())));
    }

}
