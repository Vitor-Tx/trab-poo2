package entities;

public class EstadoMorto extends Estado {

    public EstadoMorto(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(null, null, null);
        System.out.println("SE FODEUjhjgfghgftredfg");
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() > 0) {
            this.getPersonagem().setEstado(new EstadoPerigo(this.getPersonagem()));
        }
    }
}
