package controller.command.impl.BotaoR;

import controller.command.Command;
import model.Personagem.Jogador;

public class PularCommand implements Command {

    Jogador jogador;

    public PularCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.pular();
    }
}
