package model;

import model.composite.Sala;
import model.Personagem.impl.NPC;

public class JogoNPC implements Runnable {

    NPC npc;
    Sala labirinto;
    public JogoNPC(NPC npc, Sala labirinto){
        this.npc = npc;
        this.labirinto = labirinto;
    }

    public void run(){
        this.labirinto.entrar(this.npc);
    }
}
