package controller.command.impl.BotaoL;

import controller.command.Command;
import model.Personagem.Jogador;

public class UpCommand implements Command {

    Jogador jogador;

    public UpCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.getPosicao().movNorte();
    }
}
