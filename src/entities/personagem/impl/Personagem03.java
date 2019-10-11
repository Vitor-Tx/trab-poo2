package entities.personagem.impl;

import entities.estado.impl.EstadoNormal;
import entities.estrategias.impl.*;
import entities.personagem.Personagem;

public class Personagem03 extends Personagem {

    public Personagem03() {
        super(new PuloBaixo(), new VelocidadeRapida(), new AtaqueForte());
    }

    public Personagem03(int l, int a) {
        super(new PuloBaixo(), new VelocidadeRapida(), new AtaqueForte());
    }
}
