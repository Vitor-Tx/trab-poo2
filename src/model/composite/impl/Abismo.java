package model.composite.impl;

import model.composite.Sala;
import model.Personagem.impl.NPC;

public class Abismo extends Sala {

    public Abismo(){

    }
    @Override
    public Sala entrar(NPC npc) {
        System.out.println("Opa, " +npc.getNome() +  " perdeu o jogo, caiu no abismo!\n");
        return this;
    }
}
