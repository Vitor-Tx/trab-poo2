package model.state;

import view.Jogo;
import controller.Posicao;
import model.strategy.Ataque;
import model.strategy.Pulo;
import model.strategy.Velocidade;
import model.Personagem.Personagem;
import model.state.impl.EstadoForte;
import model.state.impl.EstadoMorto;
import model.state.impl.EstadoNormal;
import model.state.impl.EstadoPerigo;

public abstract class Estado {

    public static final Integer limiteMaxVidaPerigo = 30;
    public static final Integer limiteMaxVidaNormal = 70;
    public static final Integer limiteMaxVidaForte = 100;

    private Personagem personagem;

    public Estado(Personagem personagem, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.personagem = personagem;

        this.personagem.setEstragetias(pulo, velocidade, ataque);

        if (personagem.getSaude() == null) this.personagem.setSaude(limiteMaxVidaNormal);

        if (personagem.getPosicao() == null) {
            personagem.setPosicao(new Posicao(0, 0, personagem));
        }
    }

    public Estado(Personagem personagem) {
        this.personagem = personagem;

        if (personagem.getSaude() == null) this.personagem.setSaude(limiteMaxVidaNormal);


        if (personagem.getPosicao() == null) {
            personagem.setPosicao(new Posicao(0, 0, personagem));
        }
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

    private void verificaAlteracaoEstado() {
        Integer s = personagem.getSaude();
        if (s <= 0) {
            this.personagem.setEstado(new EstadoMorto(personagem));
        } else if (s <= limiteMaxVidaPerigo) {
            this.personagem.setEstado(new EstadoPerigo(personagem));
        } else if (s <= limiteMaxVidaNormal) {
            this.personagem.setEstado(new EstadoNormal(personagem));
        } else if (s <= limiteMaxVidaForte) {
            this.personagem.setEstado(new EstadoForte(personagem));
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
