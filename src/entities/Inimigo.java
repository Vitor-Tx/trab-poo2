package entities;

import entities.auxiliars.Posicao;
import entities.estrategias.Ataque;
import entities.estrategias.impl.AtaqueFraco;

import java.util.Observable;
import java.util.Observer;

public class Inimigo extends Personagem implements Observer {

    private Posicao posicao;

    private Ataque ataque;

    private Integer saude;

    public Inimigo(int x, int y) {
        this.posicao = new Posicao(x, y, this);
        this.ataque = new AtaqueFraco();
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void atacar(Personagem p) {
        p.receberDano(ataque.forca());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Personagem) {
            Personagem p = (Personagem) o;

            if ((posicao.getX() - p.getPosicao().getX() == 0) && (posicao.getY() - p.getPosicao().getY() == 0)) {
                System.out.println("\nInimigo " + this + " atacou personagem " + p);
                atacar(p);
            } else {
                if (p.getPosicao().getX() > posicao.getX()) posicao.movLeste();
                else posicao.movOeste();

                if (p.getPosicao().getY() > posicao.getY()) posicao.movSul();
                else posicao.movNorte();
            }
        }
    }
}
