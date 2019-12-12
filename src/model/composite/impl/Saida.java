package model.composite.impl;

import model.composite.Sala;
import model.observer.impl.NPC;

public class Saida extends Sala {

    public Saida(){

    }

    @Override
    public Sala entrar(NPC npc) {

        System.out.println(npc.getNome() + " ganhou o jogo, saiu do labirinto!\n");
        return this;
    }
}
