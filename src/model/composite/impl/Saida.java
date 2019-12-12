package model.composite.impl;

import model.composite.Sala;

public class Saida extends Sala {

    public Saida(){

    }

    @Override
    public Sala entrar() {
        return this;
    }
}
