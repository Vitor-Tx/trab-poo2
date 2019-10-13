package entities.observer.impl;

import entities.decorators.impl.Fogo;
import entities.observer.Inimigo;

public class InimigoFogo extends Inimigo {
    public InimigoFogo(int x, int y, int l, int a){
        super(x, y, l, a);
        setAtaque(new Fogo(new Fogo(getAtaque())));
    }

}
