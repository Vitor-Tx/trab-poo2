package controller.command.impl.BotaoR;

import controller.command.Command;
import model.Personagem.Jogador;

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
