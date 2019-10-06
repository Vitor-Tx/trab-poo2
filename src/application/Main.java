package application;

import entities.Jogo;
import entities.auxiliars.AudioPlayer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Jogo j = new Jogo();
        j.iniciar(j);
    }
}
