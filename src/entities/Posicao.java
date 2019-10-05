package entities;

public class Posicao {

    private int x;
    private int y;

    private int vel;

    public Posicao(int x, int y, int vel) {
        this.x = x;
        this.y = y;
        this.vel = vel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
//        toString();
    }

    public void movNorte() {
        this.y += vel;
//        toString();
    }

    public void movSul() {
        this.y -= vel;
//        toString();
    }

    public void movLeste() {
        this.x += vel;
//        toString();
    }

    public void movOeste() {
        this.x -= vel;
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
