package model.command.impl.botaoL;

import model.command.Command;
import model.observer.Jogador;

public class MovCimaCommand implements Command {

    private Jogador jogador;

    public MovCimaCommand(Jogador jogador) {
        this.jogador = jogador;
    }


    @Override
    public void execute() {
        this.jogador.cima();
    }
}
