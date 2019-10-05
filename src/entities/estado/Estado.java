package entities.estado;

import entities.Jogo;
import entities.Personagem;
import entities.Posicao;

public abstract class Estado {

    private Personagem personagem;

    public Estado(Personagem personagem) {
        this.personagem = personagem;

        if (personagem.getSaude() == null) this.personagem.setSaude(100);
    }

    public void receberDano(Integer dano) {
        this.personagem.setSaude(this.personagem.getSaude() - dano);
        Jogo.clearScreen();
        System.out.println("RECEBE " + dano + " DE DANO!!\nSAUDE: " + personagem.getSaude());
        verificaAlteracaoEstado();
    }

    public void receberVida(Integer vida) {
        this.personagem.setSaude(this.personagem.getSaude() + vida);
        Jogo.clearScreen();
        System.out.println("RECEBE " + vida + "DE VIDA!!\nSAUDE: " + personagem.getSaude());
        verificaAlteracaoEstado();
    }

    public void atualizaMovimento() {
        int x = personagem.getPosicao().getX();
        int y = personagem.getPosicao().getY();
        int vel;

        if (personagem.getVelocidade() == null) {
            vel = 0;
        } else {
            vel = personagem.getVelocidade().vel();
        }

        personagem.setPosicao(new Posicao(x, y, vel));
    }

    protected abstract void verificaAlteracaoEstado();

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
