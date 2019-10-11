package entities.personagem.impl;

import entities.estado.impl.EstadoNormal;
import entities.estrategias.impl.*;
import entities.personagem.Personagem;

public class Personagem02 extends Personagem {

    public Personagem02() {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }

    public Personagem02(int l, int a) {
        super(new PuloAlto(), new VelocidadeRapida(), new AtaqueMedio());
    }
}
