package application;

import entities.Jogo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Jogo j = new Jogo();
        j.iniciar(j);
    }
}
