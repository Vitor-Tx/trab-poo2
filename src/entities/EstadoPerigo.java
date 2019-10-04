package entities;

public class EstadoPerigo extends Estado {

    public EstadoPerigo(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(new PularBaixo(), new CorrerDevagar(), new AtacarFraco());
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() == 0) {
            this.getPersonagem().setEstado(new EstadoMorto(this.getPersonagem()));
        } else if (this.getPersonagem().getSaude() >= 30 && this.getPersonagem().getSaude() <= 70) {
            this.getPersonagem().setEstado(new EstadoNormal(this.getPersonagem()));
        }
    }
}
