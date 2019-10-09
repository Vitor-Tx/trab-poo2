package entities.personagem;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import entities.auxiliars.Posicao;
import entities.chain.Escudo;
import entities.chain.impl.EscudoForte;
import entities.chain.impl.EscudoFraco;
import entities.chain.impl.EscudoMedio;
import entities.estado.Estado;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;

import java.util.Observable;

public abstract class Personagem extends Observable {

    private Pulo pulo, defaultPulo;
    private Velocidade velocidade, defaultVelocidade;
    private Ataque ataque, defaultAtaque;
    private Escudo escudo;


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
        this.escudo = new EscudoForte(15);
        this.escudo.setSucessor(new EscudoMedio(10));
        this.escudo.getSucessor().setSucessor(new EscudoFraco(5));
    }

    public Personagem(int l, int a, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.largura = l;
        this.altura = a;
        this.defaultPulo = pulo;
        this.defaultVelocidade = velocidade;
        this.defaultAtaque = ataque;
        this.escudo = new EscudoForte(15);
        this.escudo.setSucessor(new EscudoMedio(10));
        this.escudo.getSucessor().setSucessor(new EscudoFraco(5));
    }

    public void setEstragetias(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.pulo = pulo;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public Pulo getPulo() {
        return pulo;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public Velocidade getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Velocidade velocidade) {
        this.velocidade = velocidade;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
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
        AudioPlayer.playSound(Jogo.hurtUrl);
        estado.receberDano(escudo.defender(dano));
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

    public Pulo getDefaultPulo() {
        return defaultPulo;
    }

    public Velocidade getDefaultVelocidade() {
        return defaultVelocidade;
    }

    public Ataque getDefaultAtaque() {
        return defaultAtaque;
    }
}
