package model.Personagem.impl;

import model.Personagem.Jogador;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.PuloAlto;
import model.strategy.impl.VelocidadeRapida;

public class Jogador05 extends Jogador {

    public Jogador05() {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueFraco());
    }

    public Jogador05(int l, int a) {
        super(l, a, new PuloAlto(), new VelocidadeRapida(), new AtaqueFraco());
    }
}
