package view;

import controller.Acao;
import controller.AudioPlayer;
import controller.Posicao;
import model.decorator.Item;
import model.factory.FactoryJogador;
import model.factory.impl.AdvancedJogadorfactory;
import model.factory.impl.SimpleJogadorfactory;
import model.observer.Inimigo;
import model.observer.Jogador;
import model.state.impl.EstadoMorto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo extends JPanel {

    public Random random = new Random();

    private Jogador jogador;
    private FactoryJogador jogadorFactory;

    private JLabel ataqueHUD = new JLabel("");

    private List<Inimigo> inimigos = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();

    private Acao acao;

    public static final int larguraJanela = 700;
    public static final int alturaJanela = 600;

    public static final int larguraPersonagem = 20;
    public static final int alturaPersonagem = 40;

    public static final int contagemInicialInimigos = 10;
    public static final int contagemInicialItens = 5;

    public static final String hurtUrl = System.getProperty("user.dir") + "/hurt.wav";
    public static final String inimigoHurtUrl = System.getProperty("user.dir") + "/inimigo-hurt.wav";
    public static final String itemCatchUrl = System.getProperty("user.dir") + "/item-catch.wav";
    public static final String deathUrl = System.getProperty("user.dir") + "/death-scream.wav";
    public static final String jumpUrl = System.getProperty("user.dir") + "/jump-sound.wav";

    public Jogo() {
        acao = new Acao(larguraJanela, alturaJanela);
        addKeyListener(acao);
        setFocusable(true);
    }

    public void iniciar(Jogo game) throws InterruptedException {
        JFrame frame = new JFrame("O Jogo");
        ataqueHUD.setFont(new Font("Arial", Font.BOLD, 16));
        ataqueHUD.setForeground(Color.RED);
        game.add(ataqueHUD);
        frame.add(game);
        frame.setSize(larguraJanela, alturaJanela);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarEntidades();

        while (true) {
            verificaInimigosMortos();
            verificaItensPegos();

            if (jogador.getEstado() instanceof EstadoMorto || jogador.getInimigos().size() == 0) {
                if (jogador.getEstado() instanceof EstadoMorto) {
                    AudioPlayer.playSound(Jogo.deathUrl);
                }
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja reiniciar o jogo?", "Confirma\u00e7\u00e3o",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    inicializarEntidades();
                } else {
                    System.exit(0);
                }
            } else {
                jogador.mostraPos();
                acao.realizarMovimento();
                acao.realizaAcao();
            }
            game.repaint();
            Thread.sleep(40);
        }
    }

    public void paint(Graphics g) {
        super.paint(g); // Limpa a tela

        Graphics2D g2d = (Graphics2D) g;

//      Faz as bordas ficarem esmaecidas
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        desenhaHUD(g2d);

        if (jogador != null) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(jogador.getPosicao().getX(), jogador.getPosicao().getY(), jogador.getLargura(), jogador.getAltura());
        }

        for (Inimigo i : inimigos) {
            if (i != null && !(i.getEstado() instanceof EstadoMorto)) {
                g2d.setColor(Color.RED);
                g2d.fillRect(i.getPosicao().getX(), i.getPosicao().getY(), larguraPersonagem, alturaPersonagem);

                g2d.setColor(Color.GREEN);
                g2d.fillRect(i.getPosicao().getX(), i.getPosicao().getY() - 10, i.getSaude(), 5);
            }
        }

        for (Item i : itens) {
            if (i != null && !i.isPego()) {
                if (i.getId() == 0) {
                    g2d.setColor(Color.CYAN);
                    g2d.fillRect(i.getPosicao().getX(), i.getPosicao().getY(), i.getLargura(), i.getAltura());
                } else if (i.getId() == 1) {
                    g2d.setColor(Color.MAGENTA);
                    g2d.fillRect(i.getPosicao().getX(), i.getPosicao().getY(), i.getLargura(), i.getAltura());
                } else {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillRect(i.getPosicao().getX(), i.getPosicao().getY(), i.getLargura(), i.getAltura());
                }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void inicializarEntidades() {
        String[] ops = {"Simple", "Avancado"};

        int op = JOptionPane.showOptionDialog(this, "Qual tipo de Jogador deseja?", "Selecione",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,ops, ops[0]);

        criaEntidade(op);

        acao.setJ(jogador);

        for (int i = 0; i < contagemInicialInimigos; i++) {
            Inimigo inimigo = new Inimigo(random.nextInt(larguraJanela), random.nextInt(alturaJanela), larguraPersonagem, alturaPersonagem);
            inimigos.add(inimigo);
            jogador.addObserver(inimigo);
        }

        for (int i = 0; i < contagemInicialItens; i++)
            itens.add(new Item());
    }

    private void verificaItensPegos() {
        int je = getEsquerda(jogador.getPosicao());
        int jd = getDireita(jogador.getPosicao(), jogador.getLargura());
        int jc = getCima(jogador.getPosicao());
        int jb = getBaixo(jogador.getPosicao(), jogador.getAltura());

        for (Item item : itens) {
            int ie = getEsquerda(item.getPosicao());
            int id = getDireita(item.getPosicao(), item.getLargura());
            int ic = getCima(item.getPosicao());
            int ib = getBaixo(item.getPosicao(), item.getAltura());

            if (entrouEmContato(je, jd, jc, jb, ie, id, ic, ib))
                item.catchItem(jogador);
        }
    }

    private void verificaInimigosMortos() {
        for (Inimigo i : inimigos) {
            if (i.getEstado() instanceof EstadoMorto) {
                jogador.deleteObserver(i);
            }
        }
    }

    private void desenhaHUD(Graphics2D g2d) {
        if (jogador == null) return;

        ataqueHUD.setText("Força de ataque: " + jogador.getAtaque().forca());

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, alturaJanela - 30, jogador.getSaude() * 5, 40);

        g2d.setColor(Color.BLUE);
        g2d.fillRect(larguraJanela - (jogador.getEscudo().getCargaTotal() * 5), alturaJanela - 30, jogador.getEscudo().getCargaTotal() * 5, 40);
    }

    private Jogador criaEntidade (int op) {

        if (op == 0) {
            jogadorFactory = SimpleJogadorfactory.getInstance();
            jogador = jogadorFactory.criaJogador();
        } else if (op == 1) {
            jogadorFactory = AdvancedJogadorfactory.getInstance();
            jogador = jogadorFactory.criaJogador();
        }

        return jogador;
    }

    public static int getEsquerda(Posicao p) {
        return p.getX();
    }

    public static int getDireita(Posicao p, int l) {
        return p.getX() + l;
    }

    public static int getCima(Posicao p) {
        return p.getY();
    }

    public static int getBaixo(Posicao p, int a) {
        return p.getY() + a;
    }

    public static boolean entrouEmContato(int ae, int ad, int ac, int ab, int be, int bd, int bc, int bb) {
        return ad >= be && ae <= bd && ab >= bc && ac <= bb;
    }
}
