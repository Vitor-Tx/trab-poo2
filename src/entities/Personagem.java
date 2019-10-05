package entities;

import entities.estado.Estado;
import entities.estado.impl.EstadoNormal;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;

import java.util.Observable;

public class Personagem extends Observable {

    private Pulo pulo;
    private Velocidade velocidade;
    private Ataque ataque;

    private Estado estado;
    private Integer saude;

    private Posicao posicao;

    public Personagem() {
        this.estado = new EstadoNormal(this);
    }

    public void setEstragetias(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.pulo = pulo;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public Pulo getPulo() {
        return pulo;
    }

    public Velocidade getVelocidade() {
        return velocidade;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getSaude() {
        return saude;
    }

    public void setSaude(Integer saude) {
        this.saude = saude;
    }

    public void receberDano(Integer dano) {
        estado.receberDano(dano);
    }

    public void receberVida(Integer vida) {
        estado.receberVida(vida);
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public void mostraPos() {
        setChanged();
        notifyObservers();
    }
}
