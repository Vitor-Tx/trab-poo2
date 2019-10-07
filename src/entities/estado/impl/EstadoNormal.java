package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.estrategias.impl.AtaqueMedio;
import entities.estrategias.impl.PuloMedio;
import entities.estrategias.impl.VelocidadeMedia;
import entities.personagem.Personagem;
import entities.auxiliars.Posicao;

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
