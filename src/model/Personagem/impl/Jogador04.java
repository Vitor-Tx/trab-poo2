package model.Personagem.impl;

import model.Personagem.Jogador;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.PuloBaixo;
import model.strategy.impl.VelocidadeDevagar;

public class Jogador04 extends Jogador {

    public Jogador04() {
        super(new PuloBaixo(), new VelocidadeDevagar(), new AtaqueFraco());
    }

    public Jogador04(int l, int a) {
        super(l, a, new PuloBaixo(), new VelocidadeDevagar(), new AtaqueFraco());
    }
}
