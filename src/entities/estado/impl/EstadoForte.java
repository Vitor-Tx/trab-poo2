package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.impl.AtaqueForte;
import entities.estrategias.impl.PuloAlto;
import entities.estrategias.impl.VelocidadeRapida;
import entities.Personagem;

public class EstadoForte extends Estado {

    public EstadoForte(Personagem personagem) {
        super(personagem);
        this.getPersonagem().setEstragetias(new PuloAlto(), new VelocidadeRapida(), new AtaqueForte());
    }
}
