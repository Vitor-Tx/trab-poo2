package entities.personagem.impl;

import entities.estado.impl.EstadoNormal;
import entities.estrategias.impl.AtaqueForte;
import entities.estrategias.impl.PuloMedio;
import entities.estrategias.impl.VelocidadeMedia;
import entities.personagem.Personagem;

public class Jogador01 extends Jogador {

    public Jogador01() {
        super(new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }

    public Jogador01(int l, int a) {
        super(l, a, new PuloMedio(), new VelocidadeMedia(), new AtaqueForte());
    }
}
