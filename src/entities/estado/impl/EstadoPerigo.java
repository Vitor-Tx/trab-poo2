package entities.estado.impl;

import entities.estado.Estado;
import entities.estrategias.impl.AtaqueFraco;
import entities.estrategias.impl.PuloBaixo;
import entities.estrategias.impl.VelocidadeDevagar;
import entities.Personagem;
import entities.Posicao;

public class EstadoPerigo extends Estado {

    public EstadoPerigo(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(new PuloBaixo(), new VelocidadeDevagar(), new AtaqueFraco());

        System.out.println("\n== ESTADO PERIGO ==\n");

        atualizaMovimento();
    }

    @Override
    protected void verificaAlteracaoEstado() {
        System.out.println("\n== ESTADO PERIGO ==\n");
        if (this.getPersonagem().getSaude() == 0) {
            this.getPersonagem().setEstado(new EstadoMorto(this.getPersonagem()));
        } else if (this.getPersonagem().getSaude() >= 30 && this.getPersonagem().getSaude() <= 70) {
            this.getPersonagem().setEstado(new EstadoNormal(this.getPersonagem()));
        }
    }
}
