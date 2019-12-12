package model.composite.impl;

import model.composite.Sala;

public class Saida extends Sala {

    public Saida(){

    }

    @Override
    public Sala entrar() {

        System.out.println("Você ganhou o jogo, saiu do labirinto!\n");
        return this;
    }
}
