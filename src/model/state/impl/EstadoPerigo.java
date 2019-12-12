package model.state.impl;

import model.state.Estado;
import model.strategy.Ataque;
import model.strategy.Pulo;
import model.strategy.Velocidade;
import model.strategy.impl.AtaqueFraco;
import model.strategy.impl.VelocidadeDevagar;
import model.Personagem.Personagem;

public class EstadoPerigo extends Estado {

    public EstadoPerigo(Personagem personagem, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(personagem, pulo, velocidade, ataque);

        System.out.println("\n== ESTADO PERIGO ==\n");
    }

    public EstadoPerigo(Personagem personagem) {
        super(personagem);
        this.getPersonagem().setEstragetias(getPersonagem().getDefaultPulo(), new VelocidadeDevagar(), new AtaqueFraco());

        System.out.println("\n== ESTADO PERIGO ==\n");
    }
}
