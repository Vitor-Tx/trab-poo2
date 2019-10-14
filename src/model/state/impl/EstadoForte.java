package model.state.impl;

import model.state.Estado;
import model.strategy.Ataque;
import model.strategy.Pulo;
import model.strategy.Velocidade;
import model.strategy.impl.*;
import model.observer.Personagem;

public class EstadoForte extends Estado {

    public EstadoForte(Personagem personagem, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(personagem, pulo, velocidade, ataque);
    }

    public EstadoForte(Personagem personagem) {
        super(personagem);

        this.getPersonagem().setEstragetias(getPersonagem().getDefaultPulo(), new VelocidadeRapida(), new AtaqueForte());
    }
}
