package model.command.impl.BotaoL;

import model.command.Command;
import model.observer.Jogador;

public class RightCommand implements Command {

    Jogador jogador;

    public RightCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.getPosicao().movLeste();
    }
}
