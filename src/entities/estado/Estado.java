package entities.estado;

import entities.Jogo;
import entities.auxiliars.Posicao;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.observer.Personagem;
import entities.estado.impl.EstadoForte;
import entities.estado.impl.EstadoMorto;
import entities.estado.impl.EstadoNormal;
import entities.estado.impl.EstadoPerigo;

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
        } else {
            System.out.println("ESTADO DIVINO FODAO!!!\nOHHHHHHHHHH OHHHHHHHHH ÓOOHHHH...");
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
