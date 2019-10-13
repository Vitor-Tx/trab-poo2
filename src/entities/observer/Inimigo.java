package entities.observer;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import entities.auxiliars.Posicao;
import entities.auxiliars.SetTimeout;
import entities.estado.impl.EstadoMorto;
import entities.estrategias.impl.AtaqueForte;
import entities.estrategias.impl.PuloBaixo;
import entities.estrategias.impl.VelocidadeDevagar;

import java.util.Observable;
import java.util.Observer;

public class Inimigo extends Personagem implements Observer {

    private boolean podeAtacar = true;
    private boolean podeAndar = true;
    private int delay = 1000;

    public Inimigo(int x, int y) {
        super(new PuloBaixo(), new VelocidadeDevagar(), new AtaqueForte());
        setPosicao(new Posicao(x, y, this));
    }

    public Inimigo(int x, int y, int l, int a) {
        super(l, a, new PuloBaixo(), new VelocidadeDevagar(), new AtaqueForte());
        setPosicao(new Posicao(x, y, this));
    }

    public void atacar(Personagem p) throws InterruptedException {
        if (podeAtacar && !(getEstado() instanceof EstadoMorto)) {
            System.out.println("\nInimigo " + this + " atacou personagem " + p);
            p.receberDano(getAtaque().forca());
            podeAtacar = false;
            SetTimeout.setTimeout(() -> podeAtacar = true, delay);
        }
    }

    @Override
    public void receberDano(Integer dano) {
        AudioPlayer.playSound(Jogo.inimigoHurtUrl);
        getEstado().receberDano(dano);
        podeAndar = false;
        SetTimeout.setTimeout(() -> podeAndar = true, delay);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Personagem) {
            Personagem p = (Personagem) o;

            int dx = getPosicao().getX() - p.getPosicao().getX();
            int dy = getPosicao().getY() - p.getPosicao().getY();

            if ((dx > -getLargura() && dx < getLargura()) && (dy > -getAltura() && dy < getAltura())) {
                try {
                    atacar(p);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (podeAndar) {
                if (p.getPosicao().getX() > getPosicao().getX()) getPosicao().movLeste();
                else getPosicao().movOeste();

                if (p.getPosicao().getY() > getPosicao().getY()) getPosicao().movSul();
                else getPosicao().movNorte();
            }
        }
    }
}
