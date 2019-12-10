package model.observer;

import view.Jogo;
import controller.AudioPlayer;
import model.chain.Escudo;
import model.chain.impl.EscudoForte;
import model.chain.impl.EscudoFraco;
import model.chain.impl.EscudoMedio;
import model.strategy.Ataque;
import model.strategy.Pulo;
import model.strategy.Velocidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Jogador extends Personagem {

    private Escudo escudo;
    private List<Inimigo> inimigos = new ArrayList<>();

    private int areaAtaque = 20;

    public Jogador(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(pulo, velocidade, ataque);

        this.escudo = new EscudoForte(15);
        this.escudo.setSucessor(new EscudoMedio(10));
        this.escudo.getSucessor().setSucessor(new EscudoFraco(5));
    }

    public Jogador(int l, int a, Pulo pulo, Velocidade velocidade, Ataque ataque) {
        super(l, a, pulo, velocidade, ataque);

        this.escudo = new EscudoForte(15);
        this.escudo.setSucessor(new EscudoMedio(10));
        this.escudo.getSucessor().setSucessor(new EscudoFraco(5));
    }

    public void atacar() {
        if (getInimigos().size() == 0) return;

        int je = Jogo.getEsquerda(getPosicao()) - areaAtaque;
        int jd = Jogo.getDireita(getPosicao(), getLargura()) + areaAtaque;
        int jc = Jogo.getCima(getPosicao()) - areaAtaque;
        int jb = Jogo.getBaixo(getPosicao(), getAltura()) + areaAtaque;

        for (Inimigo i : getInimigos()) {
            int ie = Jogo.getEsquerda(i.getPosicao());
            int id = Jogo.getDireita(i.getPosicao(), i.getLargura());
            int ic = Jogo.getCima(i.getPosicao());
            int ib = Jogo.getBaixo(i.getPosicao(), i.getAltura());

            if (Jogo.entrouEmContato(je, jd, jc, jb, ie, id, ic, ib)) {
                i.receberDano(getAtaque().forca());
            }
        }
    }

    public Velocidade correr() {
        return getDefaultVelocidade();
    }

    public Pulo pular() {
        return getDefaultPulo();
    }

    public void magia() {

    }

    public void baixo() {
    }

    public void cima() {

    }

    public void direita() {

    }

    public void esquerda() {

    }

    @Override
    public void receberDano(Integer dano) {
        AudioPlayer.playSound(Jogo.hurtUrl);
        getEstado().receberDano(escudo.defender(dano));
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

    public void mostraPos() {
        setChanged();
        notifyObservers();
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(List<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public int getAreaAtaque() {
        return areaAtaque;
    }

    public void setAreaAtaque(int areaAtaque) {
        this.areaAtaque = areaAtaque;
    }
}
