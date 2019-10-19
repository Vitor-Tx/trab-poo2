package controller;

import model.observer.Jogador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Acao implements KeyListener {

    private Jogador j;

    private int larguraJanela;
    private int alturaJanela;

    private final Set<Integer> teclas = new HashSet<>();

    public Acao(int largura, int altura) {
        this.larguraJanela = largura;
        this.alturaJanela = altura;
    }

    public Jogador getJ() {
        return j;
    }

    public void setJ(Jogador j) {
        this.j = j;
    }

    public void realizarMovimento() {
        if (teclas.contains(KeyEvent.VK_LEFT))
            if (isOnLimitBottomX())
                j.getPosicao().movOeste();

        if (teclas.contains(KeyEvent.VK_RIGHT))
            if (isOnLimitTopX())
                j.getPosicao().movLeste();

        if (teclas.contains(KeyEvent.VK_UP))
            if (isOnLimitBottomY())
                j.getPosicao().movNorte();

        if (teclas.contains(KeyEvent.VK_DOWN))
            if (isOnLimitTopY())
                j.getPosicao().movSul();

        if (teclas.contains(KeyEvent.VK_SPACE))
            j.atacar();
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        teclas.add(e.getKeyCode());
    }

    @Override
    public synchronized void keyTyped(KeyEvent e) {

    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        teclas.remove(e.getKeyCode());
    }

    private boolean isOnLimitTopX() {
        return j.getPosicao().getX() < (larguraJanela - 20);
    }

    private boolean isOnLimitBottomX() {
        return j.getPosicao().getX() > 0;
    }

    private boolean isOnLimitTopY() {
        return j.getPosicao().getY() < (alturaJanela - 40);
    }

    private boolean isOnLimitBottomY() {
        return j.getPosicao().getY() > 0;
    }
}
