package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.estrategias.impl.AtaqueFraco;
import entities.estrategias.impl.VelocidadeDevagar;
import entities.observer.Personagem;

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
