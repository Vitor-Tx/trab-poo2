package entities.personagem.impl;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import entities.chain.Escudo;
import entities.chain.impl.EscudoForte;
import entities.chain.impl.EscudoFraco;
import entities.chain.impl.EscudoMedio;
import entities.estrategias.Ataque;
import entities.estrategias.Pulo;
import entities.estrategias.Velocidade;
import entities.personagem.Personagem;

public class Jogador extends Personagem {

    private Escudo escudo;

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

    @Override
    public void receberDano(Integer dano) {
        AudioPlayer.playSound(Jogo.hurtUrl);
        getEstado().receberDano(escudo.defender(dano));
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
