package entities;

import entities.auxiliars.Posicao;
import entities.estrategias.Ataque;
import entities.estrategias.impl.AtaqueFraco;
import entities.estrategias.impl.VelocidadeDevagar;

import java.util.Observable;
import java.util.Observer;

public class Inimigo extends Personagem implements Observer {

    public Inimigo(int x, int y) {
        setPosicao(new Posicao(x, y, this));
        setAtaque(new AtaqueFraco());
        setVelocidade(new VelocidadeDevagar());
    }

    public Inimigo(int x, int y, int l, int a) {
        super(l, a);
        setPosicao(new Posicao(x, y, this));
        setAtaque(new AtaqueFraco());
        setVelocidade(new VelocidadeDevagar());
    }

    public void atacar(Personagem p) {
        p.receberDano(getAtaque().forca());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Personagem) {
            Personagem p = (Personagem) o;

            int dx = getPosicao().getX() - p.getPosicao().getX();
            int dy = getPosicao().getY() - p.getPosicao().getY();

            if ((dx > -getLargura() && dx < getLargura()) && (dy > -getAltura() && dy < getAltura())) {
                System.out.println("\nInimigo " + this + " atacou personagem " + p);
                atacar(p);
            } else {
                if (p.getPosicao().getX() > getPosicao().getX()) getPosicao().movLeste();
                else getPosicao().movOeste();

                if (p.getPosicao().getY() > getPosicao().getY()) getPosicao().movSul();
                else getPosicao().movNorte();
            }
        }
    }
}
