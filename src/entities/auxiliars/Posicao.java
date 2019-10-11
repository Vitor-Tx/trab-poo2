package entities.auxiliars;

import entities.personagem.Personagem;

public class Posicao {

    private int x;
    private int y;

    private Personagem p;

    public Posicao(int x, int y, Personagem p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Personagem getP() {
        return p;
    }

    public void setP(Personagem p) {
        this.p = p;
    }

    public void movNorte() {
        if (p.getVelocidade() == null) return;

        this.y -= p.getVelocidade().vel();
//        toString();
    }

    public void movSul() {
        if (p.getVelocidade() == null) return;

        this.y += p.getVelocidade().vel();
//        toString();
    }

    public void movLeste() {
        if (p.getVelocidade() == null) return;

        this.x += p.getVelocidade().vel();
//        toString();
    }

    public void movOeste() {
        if (p.getVelocidade() == null) return;

        this.x -= p.getVelocidade().vel();
//        toString();
    }

    public void movNordeste() {
        movNorte();
        movLeste();
//        toString();
    }

    public void movSudeste() {
        movSul();
        movLeste();
//        toString();
    }

    public void movSudoeste() {
        movSul();
        movOeste();
//        toString();
    }

    public void movNoroeste() {
        movNorte();
        movOeste();
//        toString();
    }

    @Override
    public String toString() {
        return String.format("X: %d \tY: %d", x, y);
    }
}
