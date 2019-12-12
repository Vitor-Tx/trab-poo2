package model.command.impl.BotaoL;

import model.command.Command;
import model.observer.Jogador;

public class LeftCommand implements Command{

    Jogador jogador;

    public LeftCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.getPosicao().movOeste();
    }
}
