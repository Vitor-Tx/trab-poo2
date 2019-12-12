package model.command.impl.BotaoR;

import model.command.Command;
import model.observer.Jogador;

public class CorrerCommand implements Command {

    Jogador jogador;

    public CorrerCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.correr();
    }
}
