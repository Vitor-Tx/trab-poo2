package model.command.impl.botaoL;

import model.command.Command;
import model.observer.Jogador;

public class MovDireitaCommand implements Command {

    private Jogador jogador;

    public MovDireitaCommand(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        this.jogador.direita();
    }
}
