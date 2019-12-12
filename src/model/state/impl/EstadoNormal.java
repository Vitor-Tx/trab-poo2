package model.state.impl;

import model.state.Estado;
import model.strategy.Ataque;
import model.strategy.Pulo;
import model.strategy.Velocidade;
import model.Personagem.Personagem;

public class EstadoNormal extends Estado {

    public EstadoNormal(Personagem personagem, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(personagem, pulo, velocidade, ataque);
    }

    public EstadoNormal(Personagem personagem) {
        super(personagem);

        this.getPersonagem().setEstragetias(
                getPersonagem().getDefaultPulo(),
                getPersonagem().getDefaultVelocidade(),
                getPersonagem().getDefaultAtaque()
        );
    }
}
