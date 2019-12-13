package controller;

import model.decorator.Item;
import model.Personagem.Personagem;

public class Posicao {

    private int x;
    private int y;

    private Personagem p;
    private Item z;

    public Posicao(int x, int y, Personagem p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public Posicao(int x, int y, Item z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public void movPulo() {
        if (p.getVelocidade() == null) return;

        this.x += p.getVelocidade().vel() * 2;
    }

    public void movCorrer() {
        if (p.getVelocidade() == null) return;

        this.x += p.getVelocidade().vel() * 5;
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
