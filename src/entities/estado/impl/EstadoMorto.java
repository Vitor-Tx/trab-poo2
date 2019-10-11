package entities.estado.impl;

import entities.estado.Estado;
import entities.personagem.Personagem;
import entities.personagem.impl.Inimigo;

public class EstadoMorto extends Estado {

    public EstadoMorto(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(null, null, null);
        personagem.deleteObservers();

        System.out.println("\nPERSONAGEM " + personagem + " MORREU (X.X)\n");
    }
}
