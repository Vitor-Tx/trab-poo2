package entities.estado.impl;

import entities.estado.Estado;
import entities.Personagem;

public class EstadoMorto extends Estado {

    public EstadoMorto(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(null, null, null);
        personagem.deleteObservers();

        System.out.println("\nPERSONAGEM " + personagem + " MORREU (X.X)\n");
        atualizaMovimento();
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() > 0) {
            this.getPersonagem().setEstado(new EstadoPerigo(this.getPersonagem()));
        }
    }
}
