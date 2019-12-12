package controller.command.impl.BotaoR;

import controller.command.Command;
import model.Personagem.Jogador;

public class MagiaCommand implements Command {

    Jogador jogador;

    public MagiaCommand(Jogador j) {
        this.jogador = j;
    }

    @Override
    public void execute() {
        this.jogador.magia();
    }
}
