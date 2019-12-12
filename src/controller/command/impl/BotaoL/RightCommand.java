package controller.command.impl.BotaoL;

import controller.command.Command;
import model.Personagem.Jogador;

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
