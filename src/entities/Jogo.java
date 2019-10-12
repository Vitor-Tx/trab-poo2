package entities;

import entities.decorators.Item;
import entities.auxiliars.Acao;
import entities.estado.impl.EstadoMorto;
import entities.personagem.Personagem;
import entities.personagem.impl.Inimigo;
import entities.personagem.impl.Personagem01;

import javax.swing.*;
import java.awt.*;

public class Jogo extends JPanel {

    private Personagem p1;

    private Inimigo i1;

    private Item r1;

    private Acao acao;

    public static final int larguraJanela = 700;
    public static final int alturaJanela = 600;

    public static final int larguraPersonagem = 20;
    public static final int alturaPersonagem = 40;

    public static final String hurtUrl = System.getProperty("user.dir") + "/hurt.wav";
    public static final String inimigoHurtUrl = System.getProperty("user.dir") + "/inimigo-hurt.wav";
    public static final String itemCatchUrl = System.getProperty("user.dir") + "/item-catch.wav";

    public Jogo() {
        acao = new Acao(larguraJanela, alturaJanela);
        addKeyListener(acao);
        setFocusable(true);
    }

    public void iniciar(Jogo game) throws InterruptedException {
        JFrame frame = new JFrame("O Jogo");
        frame.add(game);
        frame.setSize(larguraJanela, alturaJanela);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarPersonagens();

        while (true) {
            if (i1.getEstado() instanceof EstadoMorto) {
                 p1.deleteObserver(i1);
            }

            if (p1.getEstado() instanceof EstadoMorto) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja reiniciar o jogo?", "Confirma\u00e7\u00e3o",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    inicializarPersonagens();
                } else {
                    System.exit(0);
                }
            } else {
                p1.mostraPos();
                acao.realizarMovimento();
            }
            game.repaint();
            Thread.sleep(50);
        }
    }

    public void paint(Graphics g) {
        super.paint(g); // Limpa a tela

        Graphics2D g2d = (Graphics2D) g;

//      Faz as bordas ficarem esmaecidas
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (p1 != null) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(p1.getPosicao().getX(), p1.getPosicao().getY(), larguraPersonagem, alturaPersonagem);
        }

        if (i1 != null) {
            g2d.setColor(Color.RED);
            g2d.fillRect(i1.getPosicao().getX(), i1.getPosicao().getY(), larguraPersonagem, alturaPersonagem);
        }

        if (r1 != null) {
            if (r1.getId() == 0) {
                g2d.setColor(Color.BLUE);
                g2d.fillRect(r1.getPosicao().getX(), r1.getPosicao().getY(), r1.getLargura(), r1.getAltura());
            } else if (r1.getId() == 1) {
                g2d.setColor(Color.MAGENTA);
                g2d.fillRect(r1.getPosicao().getX(), r1.getPosicao().getY(), r1.getLargura(), r1.getAltura());
            } else {
                g2d.setColor(Color.ORANGE);
                g2d.fillRect(r1.getPosicao().getX(), r1.getPosicao().getY(), r1.getLargura(), r1.getAltura());
            }
    }

        public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        private void inicializarPersonagens() {
            p1 = new Personagem01(larguraPersonagem, alturaPersonagem);
            acao.setP(p1);

            i1 = new Inimigo(300, 300, larguraPersonagem, alturaPersonagem);
            p1.addObserver(i1);

            r1 = new Item();
        }
}
