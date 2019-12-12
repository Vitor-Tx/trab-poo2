package controller;

import model.command.Controle;
import model.command.SimpleControleFactory;
import model.observer.Jogador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Acao implements KeyListener {

    private Jogador j;
    private Controle controle;

    private int larguraJanela;
    private int alturaJanela;

    private final Set<Integer> teclas = new HashSet<>();

    public Acao() { }

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

        if (teclas.contains(KeyEvent.VK_LEFT)) {
            if (isOnLimitBottomX()) {
                //j.getPosicao().movOeste();
                SimpleControleFactory.ExecuteCommands(j,0);
            }
        }
        if (teclas.contains(KeyEvent.VK_RIGHT)) {
            if (isOnLimitTopX()) {
                //j.getPosicao().movLeste();

                SimpleControleFactory.ExecuteCommands(j,1);
            }
        }

        if (teclas.contains(KeyEvent.VK_UP)) {
            if (isOnLimitBottomY()) {
                //j.getPosicao().movNorte();
                SimpleControleFactory.ExecuteCommands(j,2);
            }
        }

        if (teclas.contains(KeyEvent.VK_DOWN)) {
            if (isOnLimitTopY()) {
                //j.getPosicao().movSul();
                SimpleControleFactory.ExecuteCommands(j,3);
            }
        }
    }

    public void realizaAcao() {
        if (teclas.contains(KeyEvent.VK_SPACE)) {
            //j.atacar();
            SimpleControleFactory.ExecuteCommands(j, 4);
        }
        if (teclas.contains(KeyEvent.VK_A)) {
            //j.magia();
            SimpleControleFactory.ExecuteCommands(j, 5);
        }
        if (teclas.contains(KeyEvent.VK_S)) {
            //j.correr();
            SimpleControleFactory.ExecuteCommands(j,6);
        }
        if (teclas.contains(KeyEvent.VK_D)){
            j.pular();
            //SimpleControleFactory.ExecuteCommands(j,7);
        }
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
