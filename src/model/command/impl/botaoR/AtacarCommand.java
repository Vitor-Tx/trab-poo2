package model.command.impl.BotaoR;

import model.command.Command;
import model.observer.Jogador;

public class AtacarCommand implements Command {

    Jogador jogador;

    public AtacarCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.atacar();
    }
}
