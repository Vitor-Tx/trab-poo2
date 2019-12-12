package model.command.impl.BotaoR;

import model.command.Command;
import model.observer.Jogador;

public class PularCommand implements Command {

    Jogador jogador;

    public PularCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.pular();
    }
}
