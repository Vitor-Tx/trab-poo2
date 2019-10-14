package model.observer.impl;

import model.decorator.impl.Veneno;
import model.observer.Inimigo;

public class InimigoVeneno extends Inimigo {
    public InimigoVeneno(int x, int y, int l, int a){
        super(x, y, l, a);
        setAtaque(new Veneno(new Veneno(getAtaque())));
    }

}

