package entities.observer;

import entities.auxiliars.Posicao;
import entities.estado.Estado;
import entities.estado.impl.EstadoNormal;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;

import java.util.Observable;

public abstract class Personagem extends Observable {

    private Pulo pulo, defaultPulo;
    private Velocidade velocidade, defaultVelocidade;
    private Ataque ataque, defaultAtaque;

    private Estado estado;
    private Integer saude;

    private Posicao posicao;

    private int largura;
    private int altura;



    public Personagem(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.largura = 20;
        this.altura = 40;
        this.defaultPulo = pulo;
        this.defaultVelocidade = velocidade;
        this.defaultAtaque = ataque;
        this.estado = new EstadoNormal(this, getDefaultPulo(), getDefaultVelocidade(), getDefaultAtaque());
    }

    public Personagem(int l, int a, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.largura = l;
        this.altura = a;
        this.defaultPulo = pulo;
        this.defaultVelocidade = velocidade;
        this.defaultAtaque = ataque;
        this.estado = new EstadoNormal(this, getDefaultPulo(), getDefaultVelocidade(), getDefaultAtaque());
    }

    public void setEstragetias(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.pulo = pulo;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public abstract void receberDano(Integer dano);

    public void receberVida(Integer vida) {
        estado.receberVida(vida);
    }

    // GETTERS SETTERS...

    public Pulo getPulo() {
        return pulo;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public Pulo getDefaultPulo() {
        return defaultPulo;
    }

    public void setDefaultPulo(Pulo defaultPulo) {
        this.defaultPulo = defaultPulo;
    }

    public Velocidade getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Velocidade velocidade) {
        this.velocidade = velocidade;
    }

    public Velocidade getDefaultVelocidade() {
        return defaultVelocidade;
    }

    public void setDefaultVelocidade(Velocidade defaultVelocidade) {
        this.defaultVelocidade = defaultVelocidade;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Ataque getDefaultAtaque() {
        return defaultAtaque;
    }

    public void setDefaultAtaque(Ataque defaultAtaque) {
        this.defaultAtaque = defaultAtaque;
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

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
