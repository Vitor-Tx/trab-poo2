package entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public abstract class Personagem extends Observable implements KeyListener {

    private Pulo pulo;
    private Velocidade velocidade;
    private Ataque ataque;

    private Estado estado;
    private Integer saude;

    private Posicao posicao;

    public Personagem() {
        this.estado = new EstadoNormal(this);
        this.saude = 70;
        this.posicao = new Posicao(0, 0, 1);
    }

    public void setEstragetias(Pulo pulo, Velocidade velocidade, Ataque ataque) {
        this.pulo = pulo;
        this.velocidade = velocidade;
        this.ataque = ataque;
    }

    public Pulo getPulo() {
        return pulo;
    }

    public Velocidade getVelocidade() {
        return velocidade;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getSaude() {
        return saude;
    }

    public void setSaude(Integer saude) {
        this.saude = saude;
    }

    public void receberDano(Integer dano) {
        estado.receberDano(dano);
    }

    public void receberVida(Integer vida) {
        estado.receberVida(vida);
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void mostraPos() {
        setChanged();
        notifyObservers();
        System.out.println(String.format("\nPosição jogador\nX: %d \tY: %d\n", posicao.getX(), posicao.getY()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            posicao.movOeste();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            posicao.movLeste();

        if (e.getKeyCode() == KeyEvent.VK_UP)
            posicao.movNorte();

        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            posicao.movSul();
    }
}
