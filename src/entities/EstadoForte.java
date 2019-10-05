package entities;

public class EstadoForte extends Estado {

    public EstadoForte(Personagem personagem) {
        super(personagem);
        this.getPersonagem().setEstragetias(new PuloAlto(), new VelocidadeRapida(), new AtaqueForte());
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() <= 70 && this.getPersonagem().getSaude() >= 30) {
            this.getPersonagem().setEstado(new EstadoNormal(this.getPersonagem()));
        }
    }
}
