package controller.command.impl.BotaoR;

import controller.command.Command;
import model.Personagem.Jogador;

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
