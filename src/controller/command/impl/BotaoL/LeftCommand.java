package controller.command.impl.BotaoL;

import controller.command.Command;
import model.Personagem.Jogador;

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
