package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.estrategias.impl.*;
import entities.personagem.Personagem;

public class EstadoForte extends Estado {

    public EstadoForte(Personagem personagem, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(personagem, pulo, velocidade, ataque);
    }

    public EstadoForte(Personagem personagem) {
        super(personagem);

        this.getPersonagem().setEstragetias(getPersonagem().getDefaultPulo(), new VelocidadeRapida(), new AtaqueForte());
    }
}
