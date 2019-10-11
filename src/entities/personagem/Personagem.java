package entities.personagem;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import entities.auxiliars.Posicao;
import entities.chain.Escudo;
import entities.chain.impl.EscudoForte;
import entities.chain.impl.EscudoFraco;
import entities.chain.impl.EscudoMedio;
import entities.estado.Estado;
import entities.estado.impl.EstadoMorto;
import entities.estado.impl.EstadoNormal;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.personagem.impl.Inimigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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

    private List<Inimigo> inimigos = new ArrayList<>();

    public Personagem(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.largura = 20;
        this.altura = 40;
        this.defaultPulo = pulo;
        this.defaultVelocidade = velocidade;
        this.defaultAtaque = ataque;
        this.estado = new EstadoNormal(this, getDefaultPulo(), getDefaultVelocidade(), getDefaultAtaque());
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
        this.estado = new EstadoNormal(this, getDefaultPulo(), getDefaultVelocidade(), getDefaultAtaque());
        this.escudo = new EscudoForte(15);
        this.escudo.setSucessor(new EscudoMedio(10));
        this.escudo.getSucessor().setSucessor(new EscudoFraco(5));
    }

    public void setEstragetias(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.pulo = pulo;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public void receberDano(Integer dano) {
        AudioPlayer.playSound(Jogo.hurtUrl);
        estado.receberDano(escudo.defender(dano));
    }

    public void receberVida(Integer vida) {
        estado.receberVida(vida);
    }

    public void mostraPos() {
        setChanged();
        notifyObservers();
    }

    public void atacar() {
        if (inimigos.size() == 0) return;

        for (Inimigo i : inimigos) {

            // Faz aqui a verificação se o inimigo esta na area de receber ataque, tenta conseguir implementar sem ajuda
            // Por estar "true" ele vai sempre conseguir atacar o inimigo, independente da posição
            if (true) {
                i.receberDano(ataque.forca());
            }
        }
    }

    public void addObserver(Observer o) {
        super.addObserver(o);

        Inimigo i = (Inimigo) o;
        this.inimigos.add(i);
    }

    public void deleteObserver(Observer o) {
        super.deleteObserver(o);

        Inimigo i = (Inimigo) o;
        this.inimigos.remove(i);
    }

    public void deleteObservers() {
        super.deleteObservers();

        this.inimigos.clear();
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

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
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

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(List<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }
}
