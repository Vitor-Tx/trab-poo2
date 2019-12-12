package model.composite.impl;

import model.composite.Sala;

public class Abismo extends Sala {

    public Abismo(){

    }
    @Override
    public Sala entrar() {
        System.out.println("Opa, você perdeu o jogo, caiu no abismo!\n");
        return null;
    }
}
