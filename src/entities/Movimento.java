package entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Movimento implements KeyListener {

    Personagem p;

    int largura;
    int altura;

    private final Set<Integer> teclas = new HashSet<>();

    public Movimento(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public Personagem getP() {
        return p;
    }

    public void setP(Personagem p) {
        this.p = p;
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        teclas.add(e.getKeyCode());

        if (teclas.size() > 1) {
            if (teclas.contains(KeyEvent.VK_LEFT) && teclas.contains(KeyEvent.VK_UP) &&
                    !teclas.contains(KeyEvent.VK_RIGHT) && !teclas.contains(KeyEvent.VK_DOWN)) {
                if (isOnLimitBottomX() && isOnLimitBottomY()) {
                    p.getPosicao().movNoroeste();
                }
            } else if (!teclas.contains(KeyEvent.VK_LEFT) && teclas.contains(KeyEvent.VK_UP) &&
                    teclas.contains(KeyEvent.VK_RIGHT) && !teclas.contains(KeyEvent.VK_DOWN)) {
                if (isOnLimitTopX() && isOnLimitBottomY()) {
                    p.getPosicao().movNordeste();
                }
            } else if (!teclas.contains(KeyEvent.VK_LEFT) && !teclas.contains(KeyEvent.VK_UP) &&
                    teclas.contains(KeyEvent.VK_RIGHT) && teclas.contains(KeyEvent.VK_DOWN)) {
                if (isOnLimitTopX() && isOnLimitTopY()) {
                    p.getPosicao().movSudeste();
                }
            } else if (teclas.contains(KeyEvent.VK_LEFT) && !teclas.contains(KeyEvent.VK_UP) &&
                    !teclas.contains(KeyEvent.VK_RIGHT) && teclas.contains(KeyEvent.VK_DOWN)) {
                if (isOnLimitBottomX() && isOnLimitTopY()) {
                    p.getPosicao().movSudoeste();
                }
            }
        } else {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                if (isOnLimitBottomX())
                    p.getPosicao().movOeste();

            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                if (isOnLimitTopX())
                    p.getPosicao().movLeste();

            if (e.getKeyCode() == KeyEvent.VK_UP)
                if (isOnLimitBottomY())
                    p.getPosicao().movNorte();

            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                if (isOnLimitTopY())
                    p.getPosicao().movSul();
        }
    }

    @Override
    public synchronized void keyTyped(KeyEvent e) {

    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        teclas.remove(e.getKeyCode());
    }

    private boolean isOnLimitTopX() {
        return p.getPosicao().getX() < (largura - 20);
    }

    private boolean isOnLimitBottomX() {
        return p.getPosicao().getX() > 0;
    }

    private boolean isOnLimitTopY() {
        return p.getPosicao().getY() < (altura - 40);
    }

    private boolean isOnLimitBottomY() {
        return p.getPosicao().getY() > 0;
    }
}
