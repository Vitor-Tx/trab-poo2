package entities;

public abstract class Estado {

    private Personagem personagem;

    public Estado(Personagem personagem) {
        this.personagem = personagem;
    }

    public void receberDano(Integer dano) {
        this.personagem.setSaude(this.personagem.getSaude() - dano);
        verificaAlteracaoEstado();
    }

    public void receberVida(Integer vida) {
        this.personagem.setSaude(this.personagem.getSaude() + vida);
        verificaAlteracaoEstado();
    }

    protected abstract void verificaAlteracaoEstado();

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
