package model.factory.impl;

import model.factory.FactoryJogador;
import model.Personagem.Jogador;
import model.Personagem.impl.*;

public class SimpleJogadorfactory extends FactoryJogador {

    private static SimpleJogadorfactory instancia = null;

    private SimpleJogadorfactory () {super(); }

    public static synchronized SimpleJogadorfactory getInstance(){
        if (instancia == null)
            instancia = new SimpleJogadorfactory();
        return instancia;
    }

    @Override
    public Jogador criaJogador() {
        double r = Math.random() * 1;

        Jogador j = null;

        if (r <= 0.2) {
            j = new Jogador01();
        } else if (r > 0.2 && r <= 0.4) {
            j = new Jogador02();
        } else if (r > 0.4 && r <= 0.6) {
            j = new Jogador03();
        } else if (r > 0.6 && r <= 0.8) {
            j = new Jogador04();
        } else if (r > 0.8 && r <= 1.0) {
            j = new Jogador05();
        }

        return j;
    }
}
