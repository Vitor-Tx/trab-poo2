package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.impl.AtaqueFraco;
import entities.estrategias.impl.PuloBaixo;
import entities.estrategias.impl.VelocidadeDevagar;
import entities.Personagem;

public class EstadoPerigo extends Estado {

    public EstadoPerigo(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(new PuloBaixo(), new VelocidadeDevagar(), new AtaqueFraco());

        System.out.println("\n== ESTADO PERIGO ==\n");
    }
}
