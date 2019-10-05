package entities;

import java.util.Observable;
import java.util.Observer;

public class Inimigo implements Observer {

    private Posicao posicao;

    private Atacar ataque;

    private Integer saude;

    public Inimigo() {
        this.posicao = new Posicao(10, 10, 1);
        this.ataque = new AtacarFraco();
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
                atacar(p);
                System.out.println("Inimigo " + this + " atacou personagem " + p);
            } else {
                if (p.getPosicao().getX() > posicao.getX()) posicao.movLeste();
                else posicao.movOeste();

                if (p.getPosicao().getY() > posicao.getY()) posicao.movNorte();
                else posicao.movSul();
            }
        }
    }
}
