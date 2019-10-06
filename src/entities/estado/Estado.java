package entities.estado;

import entities.Jogo;
import entities.Personagem;
import entities.estado.impl.EstadoForte;
import entities.estado.impl.EstadoMorto;
import entities.estado.impl.EstadoNormal;
import entities.estado.impl.EstadoPerigo;

public abstract class Estado {

    public static final Integer limiteMaxVidaPerigo = 30;
    public static final Integer limiteMaxVidaNormal = 100;
    public static final Integer limiteMaxVidaForte = 150;

    private Personagem personagem;

    public Estado(Personagem personagem) {
        this.personagem = personagem;

        if (personagem.getSaude() == null) this.personagem.setSaude(limiteMaxVidaNormal);
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
