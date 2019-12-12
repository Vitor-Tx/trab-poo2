package model.command.impl.BotaoR;

import model.command.Command;
import model.observer.Jogador;

public class MagiaCommand implements Command {

    Jogador jogador;

    public MagiaCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.magia();
    }
}
