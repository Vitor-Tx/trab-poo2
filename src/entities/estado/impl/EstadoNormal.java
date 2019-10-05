package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.impl.AtaqueMedio;
import entities.estrategias.impl.PuloMedio;
import entities.estrategias.impl.VelocidadeMedia;
import entities.Personagem;
import entities.Posicao;

public class EstadoNormal extends Estado {

    public EstadoNormal(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(new PuloMedio(), new VelocidadeMedia(), new AtaqueMedio());

        if (personagem.getPosicao() == null) {
            personagem.setPosicao(new Posicao(0, 0, personagem.getVelocidade().vel()));
        } else {
            atualizaMovimento();
        }
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() < 30 && this.getPersonagem().getSaude() > 0) {
            this.getPersonagem().setEstado(new EstadoPerigo(this.getPersonagem()));
        } else if (this.getPersonagem().getSaude() > 70) {
            this.getPersonagem().setEstado(new EstadoForte(this.getPersonagem()));
        }
    }
}
