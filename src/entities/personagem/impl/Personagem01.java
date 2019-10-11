package entities.personagem.impl;

import entities.estado.impl.EstadoNormal;
import entities.estrategias.impl.AtaqueForte;
import entities.estrategias.impl.PuloMedio;
import entities.estrategias.impl.VelocidadeMedia;
import entities.personagem.Personagem;

public class Personagem01 extends Personagem {

    public Personagem01() {
        super(new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }

    public Personagem01(int l, int a) {
        super(l, a, new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }
}
