package model.observer.impl;

import model.decorator.impl.Fogo;
import model.observer.Inimigo;

public class InimigoFogo extends Inimigo {
    public InimigoFogo(int x, int y, int l, int a){
        super(x, y, l, a);
        setAtaque(new Fogo(new Fogo(getAtaque())));
    }

}
